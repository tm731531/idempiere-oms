package tw.tom.oms.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

import com.google.gson.Gson;

import tw.tom.oms.DTO.RefreshTokenDTO;
import tw.tom.oms.interfaces.IRefreshTokenService;
import tw.tom.oms.model.MOMS_Channel;
import tw.tom.oms.model.MOMS_Platform;

public class CyberbizV2RefreshTokenService implements IRefreshTokenService {

	@Override
	public RefreshTokenDTO refreshToken(MOMS_Channel channelData,MOMS_Platform platformData) throws Exception {
		// TODO Auto-generated method stub
		var responseJson = refreshTokenCallAPI(channelData,platformData);
		// todo update token

		Gson gson = new Gson();
		// 將回傳的 JSON 轉成 Map
		Map<String, Object> responseMap = gson.fromJson(responseJson, Map.class);
		RefreshTokenDTO model = new RefreshTokenDTO();
		model.newToken=String.valueOf( responseMap.get("access_token"));
		model.refreshToken=String.valueOf( responseMap.get("refresh_token"));

//		executeUpdate(String.valueOf( responseMap.get("access_token")),String.valueOf(responseMap.get("refresh_token")),channelData.getoms_channel_ID());

		return model;//"Scheduler '" + channelData.getoms_channel_ID() + "' updated: A = B = " + channelData.gettoken2();
		}

	private int executeUpdate(String access_token,String refresh_token,int oms_channel_ID) {
		var sql = "update oms_channel set token1=? ,token2=? where oms_channel_id=?";
		Object[] params =  new Object[3];
		params[0]=access_token;
		params[1]=refresh_token;
		params[2]=Integer.valueOf(oms_channel_ID);
		return DB.executeUpdate(sql, params, false,null);
	}

    public String refreshTokenCallAPI(MOMS_Channel channeldata,MOMS_Platform platformData) {
		
		String urlStr = "https://" + channeldata.getchannel_sn() + "/admin/oauth/token";
		
		
		String clientId = platformData.getplatform_id();//  MSysConfig.getValue("z_thirdly_cyberbiz_openapi_id", "", getAD_Client_ID());
		String clientSecret =platformData.getplatform_key();// MSysConfig.getValue("z_thirdly_cyberbiz_openapi_key", "", getAD_Client_ID());
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
			}

			StringBuilder responseBuilder = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				responseBuilder.append(line.trim());
			}
			br.close();

			String responseJson = responseBuilder.toString();
			System.out.print("Response JSON: " + responseJson);

			return responseJson;

		} catch (Exception e) {
			System.out.print("Exception when refreshing token: " + e.getMessage());
			return null;
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
	}
}
