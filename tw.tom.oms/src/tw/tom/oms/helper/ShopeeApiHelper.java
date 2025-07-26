package tw.tom.oms.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.google.gson.Gson;

public class ShopeeApiHelper {
    private String _partnerId;
    private String _partnerKey;
    private String _shopId;
    private String _accessToken;
    private String _merchantId;
    private String _refreshToken;
    private long _timest;

    public ShopeeApiHelper(String partnerId, String partnerKey, String shopId, String accessToken, String merchantId, String refreshToken) {
        this._partnerId = partnerId;
        this._partnerKey = partnerKey;
        this._shopId = shopId;
        this._accessToken = accessToken;
        this._merchantId = merchantId;
        this._refreshToken = refreshToken;
    }

    public String getPartnerId() {
        return _partnerId;
    }

    public String getPartnerKey() {
        return _partnerKey;
    }

    public String getShopId() {
        return _shopId;
    }

    public long getTimeStamp() {
        return _timest;
    }

    public String getAccessToken() {
        return _accessToken;
    }

    public String getRefreshToken() {
        return _refreshToken;
    }

    public String getMerchantId() {
        return _merchantId;
    }
    public String createSignForShopLevelAPI(String path, String partnerId, String partnerKey, String accessToken, String shopId, long timest) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {

        var base_string = String.format("%s%s%s%s%s", partnerId, path, timest, accessToken, shopId);
        var sign = calculateHMAC256(base_string, partnerKey);
        return sign;
    }


    public  String createSignForMerchantLevelAPI(String path, String partnerId, String partnerKey, String accessToken, String merchantId, long timest) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {

        var base_string = String.format("%s%s%s%s%s", partnerId, path, timest, accessToken, merchantId);
        var sign = calculateHMAC256(base_string, partnerKey);
        return sign;
    }

    public  String createSignForPublicLevelAPI(String path, String partnerId, String partnerKey, String accessToken, long timest) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {

        var base_string = String.format("%s%s%s%s%s", partnerId, path, timest, accessToken);
        var sign = calculateHMAC256(base_string, partnerKey);
        return sign;
    }

    public  String createSignForRefreshToken(String path, String partnerId, String partnerKey, long timest) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {

        var base_string = String.format("%s%s%s", partnerId, path, timest);
        var sign = calculateHMAC256(base_string, partnerKey);
        return sign;
    }

    private  String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public  String calculateHMAC256(String data, String key) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        String HMAC_SHA256 = "HmacSHA256";
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), HMAC_SHA256);
        Mac mac = Mac.getInstance(HMAC_SHA256);
        mac.init(secretKeySpec);
        return toHexString(mac.doFinal(data.getBytes()));
    }
    public  String shopGetTokenByRefreshToken(String refreshToken,String mainUrl , String partnerId, String partnerKey,String shopId, long timest) throws IOException, SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        var path = "/api/v2/auth/access_token/get";
        var sign = createSignForRefreshToken(path,partnerId,partnerKey,timest);
        var par = String.format("?partner_id=%s&timestamp=%s&sign=%s", partnerId, timest, sign);
        var url = mainUrl + path + par;
        HashMap jsonData = new HashMap();
        HashMap header = new HashMap();
        jsonData.put("refresh_token", refreshToken);
        jsonData.put("partner_id",Integer.valueOf(partnerId) );
        jsonData.put("shop_id", Integer.valueOf(shopId));
        header.put("Content-Type", "application/json");
        String result= null;
        
        URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");

		Gson gson = new Gson();
		String jsonInputString = gson.toJson(jsonData);
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
			os.write(input, 0, input.length);
		}

		int responseCode = con.getResponseCode();
		System.out.println("Response Code: " + responseCode);

		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {

			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			System.out.println("Response Body:\n" + response.toString());
			String json = response.toString();
	        return json;
		}
        
//        var APIResponse = HttpClient.getInstance().postJSON(url, header, JSONMapper.toJSON((jsonData)));
//        if (APIResponse.code() == 200) {
//            result= APIResponse.body();
//        } else {
//
//        }
    }
}
