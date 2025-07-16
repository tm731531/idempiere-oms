package tw.tom.oms.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopeeOrderDetailResponse {

	public String error;
	public String message;
	public Response response;
	public String request_id;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Response {
		public ArrayList<OrderList> order_list;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ImageInfo {
		public String image_url;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ItemList {
		public long item_id;
		public String item_name;
		public String item_sku;
		public int model_quantity_purchased;
		public int model_original_price;
		public int model_discounted_price;
		public ImageInfo image_info;
		public long model_id;
		public String model_name;
		public String model_sku;
		public boolean wholesale;
		public int weight;
		public boolean add_on_deal;
		public boolean main_item;
		public long add_on_deal_id;
		public String promotion_type;
		public long promotion_id;
		public long order_item_id;
		public long promotion_group_id;
		public Object product_location_id;
		public boolean is_prescription_item;

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class RecipientAddress {
		public String name;
		public String phone;
		public String town;
		public String district;
		public String city;
		public String state;
		public String region;
		public String zipcode;
		public String full_address;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class InvoiceData {
		public String number;
		public String series_number;
		public String access_key;
		public long issue_date;
		public BigDecimal total_value;
		public BigDecimal products_total_value;
		public String tax_code;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class PackageList {
		public String package_number;
		public String logistics_status;
		public String shipping_carrier;
		@JsonIgnoreProperties(value = { "intValue" })
		public int parcel_chargeable_weight_gram;

		public ArrayList<PackageItemList> item_list;
		private long order_item_id;
		private long promotion_group_id;
		private String product_location_id;
		public String virtual_contact_number;
		public String package_query_number;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class PackageItemList {
		public long item_id;
		public long model_id;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class OrderList {
		public int actual_shipping_fee;
		public boolean actual_shipping_fee_confirmed;
		public String buyer_cancel_reason;
		public Object buyer_cpf_id;
		public long buyer_user_id;
		public String buyer_username;
		public String cancel_by;
		public String cancel_reason;
		public String checkout_shipping_carrier;
		public boolean cod;
		public long create_time;
		public String currency;
		public int days_to_ship;
		public String dropshipper;
		public String dropshipper_phone;
		public int estimated_shipping_fee;
		public String fulfillment_flag;
		public boolean goods_to_declare;
		public InvoiceData invoice_data;
		public ArrayList<ItemList> item_list;
		public String message_to_seller;
		public String note;
		public long note_update_time;
		public String order_sn;
		public String order_status;
		public ArrayList<PackageList> package_list;
		public long pay_time;
		public String payment_method;
		public long pickup_done_time;
		public RecipientAddress recipient_address;
		public String region;
		public int reverse_shipping_fee;
		public long ship_by_date;
		public String shipping_carrier;
		public boolean split_up;
		public int total_amount;
		public long update_time;

	}
}
