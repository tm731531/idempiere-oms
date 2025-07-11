package tw.tom.oms.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.apache.http.client.utils.URIBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDateTime;
import java.time.ZoneId;

import tw.tom.oms.DTO.ShoplineGetOrderListResponse;
import tw.tom.oms.DTO.UnifiedOrderDTO;
import tw.tom.oms.helper.ShoplineApiHelper;
import tw.tom.oms.model.MOMS_Channel;

public class ShoplineOrderService implements OrderService {

	@Override
	public List<UnifiedOrderDTO> fetchOrders(MOMS_Channel channelData) throws Exception {
		// TODO Auto-generated method stub
//		return null;
		 SimpleDateFormat formatterdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK);
	        HashMap<String, String> headerMap = new HashMap();

	        headerMap.put("accept", "application/json");
	        headerMap.put("User-Agent", "OneEC");
	       var dt= LocalDateTime.now();                                
	       Date enddate = (Date) Date.from(dt.atZone(ZoneId.systemDefault()).toInstant());
	       Date startdate = (Date) Date.from(dt.plusHours(-1).atZone(ZoneId.systemDefault()).toInstant());

	        String startTime = formatterdt.format(startdate);
	        String  endTime = formatterdt.format(enddate);
	        
	        var apiUrlPath = ShoplineApiHelper.Order.OrderList;

            URIBuilder uriBuilder = new URIBuilder(ShoplineApiHelper.apiHost)
                    .setPath(apiUrlPath);
            uriBuilder.addParameter("created_after", startTime)
            .addParameter("created_before", endTime);
	        uriBuilder.addParameter("include_fields[]", "type")
            .addParameter("per_page", "50")
            .addParameter("page", String.valueOf(1));
	     var q =   uriBuilder.build();

	     URL obj = new URL(q.toString());
	        
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization", "Bearer " + channelData.gettoken1());

			// 5. 讀取回應
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
				/* JSON 字串放這裡 */;

				// Step 1: Parse 為 JsonArray
				JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();

				List<ShoplineGetOrderListResponse> lc = new ArrayList();
				Gson gson = new Gson();
				// 取第一筆（或你需要的那筆）資料
				for (JsonElement element : jsonArray) {
					JsonObject jsonObject = element.getAsJsonObject();

					// Step 2: 用 Gson 轉成 Java 物件
					ShoplineGetOrderListResponse.Item order = gson.fromJson(jsonObject, ShoplineGetOrderListResponse.Item.class);

//					lc.add(order);
				}
				return null;//lc.stream().map(ShoplineGetOrderListResponse.Item::ConvertToUnfiedOrderDTO).collect(Collectors.toList());
			}
	       
	}

}
