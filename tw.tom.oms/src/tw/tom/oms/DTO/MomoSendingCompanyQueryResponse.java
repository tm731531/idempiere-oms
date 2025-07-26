package tw.tom.oms.DTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MomoSendingCompanyQueryResponse {

	/**
	 * 基本檢查有錯時回傳
	 */
	public List<String> basicCheckMsgList;
	/**
	 * 基本檢查正確時回傳
	 */
	public List<Data> dataList;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Data {
		public String itemNo; // 項次
		@JsonProperty("slip_i_no")
		public String slipINo; // 出貨單號
		@JsonProperty("slip_no")
		public String slipNo; // 配送編號
		public String completeOrderNo; // 訂單編號
		@JsonProperty("remark5_vStr")
		public String remark5VStr; // 配送狀態
		@JsonProperty("msg_note")
		public String msgNote; // 配送訊息
		@JsonProperty("scm_dely_date")
		public String scmDelyDate; // 約定配送日
		@JsonProperty("dely_hope_date")
		public String delyHopeDate; // 預計出貨日
		@JsonProperty("order_gb_str")
		public String orderGbStr; // 訂單類別
		@JsonProperty("goods_code")
		public String goodsCode; // 商品編號
		@JsonProperty("entp_goods_no")
		public String entpGoodsNo; // 商品原廠編號
		@JsonProperty("goods_name")
		public String goodsName; // 商品名稱
		@JsonProperty("goodsdt_code")
		public String goodsdtCode; // 單品編號
		@JsonProperty("goodsdt_info")
		public String goodsdtInfo; // 單品詳細
		public String syslast; // 數量
		@JsonProperty("cust_name_mask")
		public String custNameMask; // 訂購人姓名(隱碼)
		@JsonProperty("receiver_mask")
		public String receiverMask; // 收件人姓名(隱碼)

		public UnifiedOrderDTO ConvertToUnfiedOrderDTO() {
			UnifiedOrderDTO t = new UnifiedOrderDTO();
			String[] parts = slipINo.split("-");
			t.order_name = parts[0]; // XXXXX-001-001-001
			t.line_items = new ArrayList<UnifiedOrderDTO.LineItem>();
			var uItem = new UnifiedOrderDTO.LineItem();
			uItem.id = parts[1] + "-" + parts[2];
			uItem.product_id = String.valueOf(goodsCode);
			uItem.product_variant_id = String.valueOf(goodsdtCode);
			uItem.title = goodsName;
			uItem.sku = entpGoodsNo;
			uItem.quantity = 1;
			uItem.qc = entpGoodsNo;
//        		uItem.price=item.price;
			t.line_items.add(uItem);
			return t;
		}

	}
}
