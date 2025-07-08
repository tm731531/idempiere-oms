package tw.tom.oms.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.compiere.model.I_AD_CtxHelpMsg;
import org.compiere.model.MBPartner;
import org.compiere.model.MCtxHelpMsg;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tw.tom.oms.DTO.CyberbizOrder;
import tw.tom.oms.DTO.ParameterDto;
import tw.tom.oms.model.I_oms_channel;
import tw.tom.oms.model.MOMS_Channel;

public class OMSGetOrderProcess extends SvrProcess {

	/** Shipment */
//	private ParameterDto parameters = new ParameterDto();
    private String oms_channel_ID ;
	/**
	 * Prepare - e.g., get Parameters.
	 */
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

	protected String doIt() throws Exception {

		int AD_Client_ID = Env.getAD_Client_ID(getCtx());// 11
		int AD_Org_ID = Env.getAD_Org_ID(getCtx());
		Query query = new Query(Env.getCtx(), MOMS_Channel.Table_Name, "oms_channel_ID=?", get_TrxName());
		MOMS_Channel channeldata = query.setParameters(Integer.valueOf(oms_channel_ID)).first();
		if (channeldata != null) {
			List<CyberbizOrder> orders;
			var c= channeldata.getoms_platform().getName();
			var d= channeldata.getoms_platform_ID();
			System.out.println(channeldata.getoms_platform());
			System.out.println(channeldata.getoms_platform_ID());
			if ("cyberbizV1".equals(channeldata.getoms_platform().getName())) {
			    orders = cyberbizGetdata(channeldata);
			} else if ("cyberbizV2".equals(channeldata.getoms_platform().getName())) {
			    orders = cyberbizV2Getdata(channeldata);
			} else {
			    orders = Collections.emptyList();
			}
			// 循环处理订单：调用提取出的公共方法
			for (CyberbizOrder cyberbizOrder : orders) {
			    createOrderFromCyberbiz(cyberbizOrder, AD_Org_ID);
			}
		} else {
		}
		
		

//		if (parameters.platform.equals("cyberbiz")) {
//			var cyberbizOrders = cyberbizGetdata(parameters);
//
//			for (int i = 0; i < cyberbizOrders.size(); i++) {
//				MOrder order = new MOrder(getCtx(), 0, get_TrxName());
//				var cyberbizOrder = cyberbizOrders.get(i);
//
//				order.setBPartner(MBPartner.get(Env.getCtx(), 118));
//				order.setC_DocTypeTarget_ID(MOrder.DocSubTypeSO_Standard);
//				order.setDeliveryRule(MOrder.DELIVERYRULE_CompleteOrder);
//				order.setDocStatus(DocAction.STATUS_Drafted);
//				order.setDocAction(DocAction.ACTION_Complete);
//				Timestamp today = TimeUtil.getDay(System.currentTimeMillis());
//				order.setDatePromised(today);
//				order.setDocumentNo(String.valueOf(cyberbizOrder.order_number));
//				order.setDescription("fromCyberbiz");
//				order.setAD_Org_ID(AD_Org_ID); // 先設定組織
//				order.setM_Warehouse_ID(103);
//				order.saveEx();
//
//				for (int j = 0; j < cyberbizOrder.line_items.size(); j++) {
//					var lineItem = cyberbizOrder.line_items.get(j);
//
//					MOrderLine orderLine = new MOrderLine(getCtx(), 0, get_TrxName());
//					orderLine.setC_Order_ID(order.getC_Order_ID());
//					int M_Product_ID = getProductIdBySKU(lineItem.sku);
//					if (M_Product_ID <= 0) {
//						log.warning("找不到商品 SKU：" + lineItem.sku + "，此明細將略過");
//						continue; // 跳過這筆明細
//					}
//
//					// 設定商品與自動帶入資訊
//					orderLine.setM_Product_ID(M_Product_ID, true); // true = 自動帶入稅別與 UOM
//
//					// 設定數量與價格
//					orderLine.setQty(new BigDecimal(lineItem.quantity));
//					orderLine.setPrice(new BigDecimal(lineItem.price));
//
//					// 可選：設定說明
//					orderLine.setDescription(lineItem.title);
//
//					// 可選：設定倉儲與組織
//					orderLine.setM_Warehouse_ID(order.getM_Warehouse_ID());
//					orderLine.setAD_Org_ID(order.getAD_Org_ID());
//
//					// 儲存
//					orderLine.saveEx();
//				}
//			}
//		}else if (parameters.platform.equals("cyberbizV2")) {
//			var cyberbizOrders = cyberbizV2Getdata(parameters);
//
//			for (int i = 0; i < cyberbizOrders.size(); i++) {
//				MOrder order = new MOrder(getCtx(), 0, get_TrxName());
//				var cyberbizOrder = cyberbizOrders.get(i);
//
//				order.setBPartner(MBPartner.get(Env.getCtx(), 118));
//				order.setC_DocTypeTarget_ID(MOrder.DocSubTypeSO_Standard);
//				order.setDeliveryRule(MOrder.DELIVERYRULE_CompleteOrder);
//				order.setDocStatus(DocAction.STATUS_Drafted);
//				order.setDocAction(DocAction.ACTION_Complete);
//				Timestamp today = TimeUtil.getDay(System.currentTimeMillis());
//				order.setDatePromised(today);
//				order.setDocumentNo(String.valueOf(cyberbizOrder.order_number));
//				order.setDescription("fromCyberbiz");
//				order.setAD_Org_ID(AD_Org_ID); // 先設定組織
//				order.setM_Warehouse_ID(103);
//				order.saveEx();
//
//				for (int j = 0; j < cyberbizOrder.line_items.size(); j++) {
//					var lineItem = cyberbizOrder.line_items.get(j);
//
//					MOrderLine orderLine = new MOrderLine(getCtx(), 0, get_TrxName());
//					orderLine.setC_Order_ID(order.getC_Order_ID());
//					int M_Product_ID = getProductIdBySKU(lineItem.sku);
//					if (M_Product_ID <= 0) {
//						log.warning("找不到商品 SKU：" + lineItem.sku + "，此明細將略過");
//						continue; // 跳過這筆明細
//					}
//
//					// 設定商品與自動帶入資訊
//					orderLine.setM_Product_ID(M_Product_ID, true); // true = 自動帶入稅別與 UOM
//
//					// 設定數量與價格
//					orderLine.setQty(new BigDecimal(lineItem.quantity));
//					orderLine.setPrice(new BigDecimal(lineItem.price));
//
//					// 可選：設定說明
//					orderLine.setDescription(lineItem.title);
//
//					// 可選：設定倉儲與組織
//					orderLine.setM_Warehouse_ID(order.getM_Warehouse_ID());
//					orderLine.setAD_Org_ID(order.getAD_Org_ID());
//
//					// 儲存
//					orderLine.saveEx();
//				}
//			}
//		}

		return "Done";
	}
	private void createOrderFromCyberbiz(CyberbizOrder orderData, int AD_Org_ID) {
	    MOrder order = new MOrder(getCtx(), 0, get_TrxName());
	    order.setBPartner(MBPartner.get(getCtx(), 118));
	    order.setC_DocTypeTarget_ID(MOrder.DocSubTypeSO_Standard);
	    order.setDeliveryRule(MOrder.DELIVERYRULE_CompleteOrder);
	    order.setDocStatus(DocAction.STATUS_Drafted);
	    order.setDocAction(DocAction.ACTION_Complete);
	    Timestamp today = TimeUtil.getDay(System.currentTimeMillis());
	    order.setDatePromised(today);
	    order.setDocumentNo(String.valueOf(orderData.order_number));
	    order.setDescription("fromCyberbiz");
	    order.setAD_Org_ID(AD_Org_ID);
	    order.setM_Warehouse_ID(103);
	    order.saveEx();

	    // 遍历并创建订单行
	    for (var lineItem : orderData.line_items) {
	        MOrderLine orderLine = new MOrderLine(getCtx(), 0, get_TrxName());
	        orderLine.setC_Order_ID(order.getC_Order_ID());
	        int M_Product_ID = getProductIdBySKU(lineItem.sku);
	        if (M_Product_ID <= 0) {
	            log.warning("找不到商品 SKU：" + lineItem.sku + "，此明细将略过");
	            continue;
	        }
	        orderLine.setM_Product_ID(M_Product_ID, true);
	        orderLine.setQty(new BigDecimal(lineItem.quantity));
	        orderLine.setPrice(new BigDecimal(lineItem.price));
	        orderLine.setDescription(lineItem.title);
	        orderLine.setM_Warehouse_ID(order.getM_Warehouse_ID());
	        orderLine.setAD_Org_ID(order.getAD_Org_ID());
	        orderLine.saveEx();
	    }
	}

	private int getDocTypeTargetID(String docBaseType) {
		String sql = "SELECT C_DocType_ID FROM C_DocType WHERE DocBaseType = ? AND IsSOTrx='Y' AND IsActive='Y' AND AD_Client_ID=?";
		return DB.getSQLValueEx(get_TrxName(), sql, docBaseType, Env.getAD_Client_ID(getCtx()));
	}

	private int getProductIdBySKU(String sku) {
		String sql = "SELECT M_Product_ID FROM M_Product WHERE Value = ?";
		return DB.getSQLValueEx(null, sql, sku);
	}

    private  String getCurrentGMTTime() {
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
        return now.format(formatter); // e.g. Tue, 08 Jul 2025 06:20:36 GMT
  }

    private  String generateHmacSignature(String data, String secretKey) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        mac.init(keySpec);
        byte[] hmacBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hmacBytes);
    }
	private List<CyberbizOrder> cyberbizGetdata(MOMS_Channel parameters) throws Exception {
		var uri = "/v1/orders?page=1&per_page=20&offset=0";
		String url = "https://api.cyberbiz.co" + uri;
		String httpMethod = "GET";
		String requestLine = httpMethod + " " + uri + " HTTP/1.1";
		 String xDate = getCurrentGMTTime();

		String apiKey =parameters.gettoken1();
		String apiSecret =parameters.gettoken2();

		// 1. 準備 HMAC 簽章內容
		String signData = "x-date: " + xDate + "\n" + requestLine;

		// 2. 使用 HMAC-SHA256 加密並做 Base64 編碼
		String signature = generateHmacSignature(signData, apiSecret);
		// 3. 組出 Authorization header
		String authorization = String.format(
				"hmac username=\"%s\", algorithm=\"hmac-sha256\", headers=\"x-date request-line\", signature=\"%s\"",
				apiKey, signature);

		// 4. 建立 HttpURLConnection 並發送請求
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod(httpMethod);
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("x-date", xDate);
		con.setRequestProperty("Authorization", authorization);

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

			List<CyberbizOrder> lc = new ArrayList();
			Gson gson = new Gson();
			// 取第一筆（或你需要的那筆）資料
			for (JsonElement element : jsonArray) {
				JsonObject jsonObject = element.getAsJsonObject();

				// Step 2: 用 Gson 轉成 Java 物件
				CyberbizOrder order = gson.fromJson(jsonObject, CyberbizOrder.class);

				System.out.println("訂單編號：" + order.order_number);
				System.out.println("客戶姓名：" + order.customer.name);
				System.out.println("SKU：" + order.line_items.get(0).sku);
				System.out.println("商品數量：" + order.line_items.size());
				lc.add(order);
			}
			return lc;
		}
	}
	
	private List<CyberbizOrder> cyberbizV2Getdata(MOMS_Channel parameters) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

		
		String url = "https://app-store-api.cyberbiz.io/v1/orders?page=1&per_page=20&offset=0";

		// 4. 建立 HttpURLConnection 並發送請求
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization", "Bearer " + parameters.gettoken1());

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

			List<CyberbizOrder> lc = new ArrayList();
			Gson gson = new Gson();
			// 取第一筆（或你需要的那筆）資料
			for (JsonElement element : jsonArray) {
				JsonObject jsonObject = element.getAsJsonObject();

				// Step 2: 用 Gson 轉成 Java 物件
				CyberbizOrder order = gson.fromJson(jsonObject, CyberbizOrder.class);

				System.out.println("訂單編號：" + order.order_number);
				System.out.println("客戶姓名：" + order.customer.name);
				System.out.println("SKU：" + order.line_items.get(0).sku);
				System.out.println("商品數量：" + order.line_items.size());
				lc.add(order);
			}
			return lc;
		}
	}

}
