package tw.tom.oms.service;

import java.util.Map;

import org.compiere.util.DB;

import com.google.gson.Gson;

import tw.tom.oms.interfaces.IRefreshTokenService;
import tw.tom.oms.model.MOMS_Channel;

public class CyberbizV2RefreshTokenService implements IRefreshTokenService {

	@Override
	public String refreshToken(MOMS_Channel channelData) throws Exception {
		// TODO Auto-generated method stub
		var responseJson = refreshToken(channelData);
		// todo update token

		Gson gson = new Gson();
		// 將回傳的 JSON 轉成 Map
		Map<String, Object> responseMap = gson.fromJson(responseJson, Map.class);

		executeUpdate(String.valueOf( responseMap.get("access_token")),String.valueOf(responseMap.get("refresh_token")),channelData.getoms_channel_ID());

		return "Scheduler '" + channelData.getoms_channel_ID() + "' updated: A = B = " + channelData.gettoken2();
		}

	private int executeUpdate(String access_token,String refresh_token,int oms_channel_ID) {
		var sql = "update oms_channel set token1=? ,token2=? where oms_channel_id=?";
		Object[] params =  new Object[3];
		params[0]=access_token;
		params[1]=refresh_token;
		params[2]=Integer.valueOf(oms_channel_ID);
		return DB.executeUpdate(sql, params, false,null);
	}
}
