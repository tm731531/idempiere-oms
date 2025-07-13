package tw.tom.oms.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tw.tom.oms.DTO.CyberbizOrderResponse;
import tw.tom.oms.DTO.UnifiedOrderDTO;
import tw.tom.oms.helper.CyberbizApiHelper;
import tw.tom.oms.interfaces.IOrderService;
import tw.tom.oms.model.MOMS_Channel;

public class CyberbizV2OrderService implements IOrderService {

	@Override
	public List<UnifiedOrderDTO> fetchOrders(MOMS_Channel channelData) throws Exception {
		// TODO Auto-generated method stub

		String url = CyberbizApiHelper.apiHostV2 + CyberbizApiHelper.Order.listV1 + "?page=1&per_page=20&offset=0";

		// 4. 建立 HttpURLConnection 並發送請求
		URL obj = new URL(url);
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

			List<CyberbizOrderResponse> lc = new ArrayList();
			Gson gson = new Gson();
			// 取第一筆（或你需要的那筆）資料
			for (JsonElement element : jsonArray) {
				JsonObject jsonObject = element.getAsJsonObject();

				// Step 2: 用 Gson 轉成 Java 物件
				CyberbizOrderResponse order = gson.fromJson(jsonObject, CyberbizOrderResponse.class);

				System.out.println("訂單編號：" + order.order_number);
				System.out.println("客戶姓名：" + order.customer.name);
				System.out.println("SKU：" + order.line_items.get(0).sku);
				System.out.println("商品數量：" + order.line_items.size());
				lc.add(order);
			}
			return lc.stream().map(CyberbizOrderResponse::ConvertToUnfiedOrderDTO).collect(Collectors.toList());
		}
	}

}
