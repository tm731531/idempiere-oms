package tw.tom.oms.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.DB;
import org.compiere.util.Env;

import com.google.gson.Gson;

import tw.tom.oms.DTO.UnifiedOrderDTO;
import tw.tom.oms.interfaces.IOrderService;
import tw.tom.oms.interfaces.IRefreshTokenService;
import tw.tom.oms.model.MOMS_Channel;
import tw.tom.oms.model.MOMS_Platform;
import tw.tom.oms.service.OrderServiceFactory;
import tw.tom.oms.service.RefreshTokenServiceFactory;

public class OMSRefreshTokenProcess extends SvrProcess{

//	private String target_scheduler = null;
    private String oms_channel_ID ;
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			System.out.println("name :" + name);
			if (name.equals("oms_channel_ID")) {
				System.out.println("value :" + para[i].getParameterAsString());
				oms_channel_ID = para[i].getParameterAsString();
			} 
		}
	} // prepare

	@Override
	protected String doIt() throws Exception {

		Query query = new Query(Env.getCtx(), MOMS_Channel.Table_Name, "oms_channel_ID=?", get_TrxName());
		MOMS_Channel channelData = query.setParameters(Integer.valueOf(oms_channel_ID)).first();

		String platformName = channelData.getoms_platform().getName();

		IRefreshTokenService service = RefreshTokenServiceFactory.getService(platformName);
		var result = service.refreshToken(channelData);
		
//		if (target_scheduler == null || target_scheduler.isEmpty()) {
//			throw new AdempiereUserError("Target Scheduler Name is required");
//		}
		// 1. 找出目標 Scheduler
//		int targetSchedulerID = new Query(getCtx(), "AD_Scheduler", "Name=?", get_TrxName())
//				.setParameters(target_scheduler).firstId();

//		if (targetSchedulerID <= 0)
//			throw new AdempiereUserError("Scheduler not found: " + target_scheduler);
//
//		String bValue = getParameterdefault(targetSchedulerID, "token2");
//		String bValueUU = getParameterUU(targetSchedulerID, "token2");
//		String aValueUU = getParameterUU(targetSchedulerID, "token1");
//		String platform = getParameterdefault(targetSchedulerID, "platform");
//		String channelSn = getParameterdefault(targetSchedulerID, "channel_sn");

//		if (channelData.getoms_platform().getName().equals("cyberbizV2")) {
//			var responseJson = refreshToken(channelData);
//			// todo update token
//
//			Gson gson = new Gson();
//			// 將回傳的 JSON 轉成 Map
//			Map<String, Object> responseMap = gson.fromJson(responseJson, Map.class);
//
//			executeUpdate(String.valueOf( responseMap.get("access_token")),String.valueOf(responseMap.get("refresh_token")));
//		}
//		// 3. 更新 A 與 B
////        updateSchedulerParam(targetSchedulerID, "A", bValue);
////        updateSchedulerParam(targetSchedulerID, "B", bValue);
		return result;// "Scheduler '" + oms_channel_ID + "' updated: A = B = " + channelData.gettoken2();
	}

	private String getParameterdefault(int AD_Scheduler_ID, String name) {
		String sql = "select asp.parameterdefault  from AD_Scheduler_Para asp inner join ad_process_para adp on asp.ad_process_para_id= adp.ad_process_para_id where AD_Scheduler_ID=? AND adp.name=?";

		return DB.getSQLValueStringEx(null, sql, AD_Scheduler_ID, name);
	}

	private int executeUpdate(String access_token,String refresh_token) {
		var sql = "update oms_channel set token1=? ,token2=? where oms_channel_id=?";
		Object[] params =  new Object[3];
		params[0]=access_token;
		params[1]=refresh_token;
		params[2]=Integer.valueOf(oms_channel_ID);
		return DB.executeUpdate(sql, params, false,null);
	}

	private String getParameterUU(int AD_Scheduler_ID, String name) {
		String sql = "select asp.ad_scheduler_para_uu  from AD_Scheduler_Para asp inner join ad_process_para adp on asp.ad_process_para_id= adp.ad_process_para_id where AD_Scheduler_ID=? AND adp.name=?";

		return DB.getSQLValueStringEx(null, sql, AD_Scheduler_ID, name);
	}

	public String refreshToken(MOMS_Channel channeldata) {
		
		String urlStr = "https://" + channeldata.getchannel_sn() + "/admin/oauth/token";
		
		Query query = new Query(Env.getCtx(), MOMS_Platform.Table_Name, "oms_platform_ID=?", get_TrxName());
		MOMS_Platform platformdata = query.setParameters(channeldata.getoms_platform_ID()).first();
		
		
		String clientId = platformdata.getplatform_id();//  MSysConfig.getValue("z_thirdly_cyberbiz_openapi_id", "", getAD_Client_ID());
		String clientSecret =platformdata.getplatform_key();// MSysConfig.getValue("z_thirdly_cyberbiz_openapi_key", "", getAD_Client_ID());
		Map<String, String> params = new HashMap<>();
		params.put("grant_type", "refresh_token");
		params.put("refresh_token", channeldata.gettoken2());
		params.put("client_id", clientId);
		params.put("client_secret", clientSecret);

		Gson gson = new Gson();
		String jsonInputString = gson.toJson(params);

		HttpURLConnection con = null;
		try {
			URL url = new URL(urlStr);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setDoOutput(true);

			// 寫入 JSON Body
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
				os.write(input, 0, input.length);
			}

			int responseCode = con.getResponseCode();

			BufferedReader br;
			if (responseCode >= 200 && responseCode < 300) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
			} else {
				// 錯誤時讀錯誤流
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), StandardCharsets.UTF_8));
				log.severe("Refresh token failed. HTTP code: " + responseCode);
			}

			StringBuilder responseBuilder = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				responseBuilder.append(line.trim());
			}
			br.close();

			String responseJson = responseBuilder.toString();
			log.info("Response JSON: " + responseJson);

			return responseJson;

		} catch (Exception e) {
			log.severe("Exception when refreshing token: " + e.getMessage());
			return null;
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
	}
}
