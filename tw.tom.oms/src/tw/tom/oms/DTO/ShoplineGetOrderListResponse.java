package tw.tom.oms.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoplineGetOrderListResponse {
	public ArrayList<Item> items;
	public Pagination pagination;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class AffiliateData {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class AltTranslations {
		public String en;
		@JsonProperty("zh-hant")
		public String zhHant;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Amount {
		public String currency;
		public int value;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class AppliedTaxInfo {
		public Sales sales;
		public Delivery delivery;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class AuthNotify {
		public Detail detail;
		public String eventId;
		public Object merchantId;
		public Object orderId;
		public int resCode;
		public int riskLevel;
		public String uid;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class CartAttributes {
		public AffiliateData affiliate_data;
		public String shop_session_id;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Channel {
		public String created_by_channel_id;
		public Map<String, String> created_by_channel_name;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Color {
		public String en;
		@JsonProperty("zh-hant")
		public String zhHant;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Cost {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class CreatePayment {
		public Amount amount;
		public NextAction nextAction;
		public PaidAmount paidAmount;
		public String passthrough;
		public String status;
		public String tradeOrderId;
		public String payment_gateway;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class CustomDatum {
		public String value;
		public FieldTranslations field_translations;
		public String field_id;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class CustomerInfo {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Data {
		public Amount amount;
		public String channelDealId;
		public String channelReferenceId;
		public LastPayment lastPayment;
		public NextAction nextAction;
		public PaidAmount paidAmount;
		public String passthrough;
		public Object paymentError;
		public RiskResult riskResult;
		public String status;
		public String subStatus;
		public String tradeOrderId;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Delivery {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class DeliveryAddress {
		public String country_code;
		public String country;
		public String city;
		public String state;
		public String postcode;
		public String address_1;
		public String address_2;
		public Object key;
		public Object layer1;
		public Object layer2;
		public Object layer3;
		public Object district;
		public ArrayList<String> logistic_codes;
		public String recipient_name;
		public String recipient_phone;
		public Object recipient_phone_country_code;
		public Object remarks;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class DeliveryData {
		public Object hk_sfplus_home_region;
		public String location_code;
		public String location_name;
		public Object location_short_name;
		public NameTranslations name_translations;
		public String store_address;
		public Object url;
		public String tracking_number;
		public Object scheduled_delivery_date;
		public String time_slot_key;
		public Object time_slot_translations;
		public StoreAddressDetail store_address_detail;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class DescriptionTranslations {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Detail {
		public Object cybsDecision;
		public String decision;
		public Object ruleId;
		public Object toast;
		public Object toastId;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class DiscountedAmount {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class DiscountedPrice {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Extension {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Favicon {
		public double width;
		public double height;
		public String url;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class FaviconLarge {
		public double width;
		public double height;
		public String url;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class FaviconSmall {
		public double width;
		public double height;
		public String url;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class FeedVariations {
		public Color color;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Field {
		public NameTranslations name_translations;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class FieldsTranslations {
		public ArrayList<String> en;
		@JsonProperty("zh-hant")
		public ArrayList<String> zhHant;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class FieldTranslations {
		@JsonProperty("zh-hant")
		public String zhHant;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Images {
		public Original original;
		public FaviconSmall favicon_small;
		public Favicon favicon;
		public FaviconLarge favicon_large;
		public TransparentThumb transparent_thumb;
		public TransparentLarge transparent_large;
		public TransparentXlarge transparent_xlarge;
		public Thumb thumb;
		public Source source;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class InclusiveTaxInfo {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Invoice {
		public String tax_id;
		public String mailing_address;
		public String invoice_type;
		public String buyer_name;
		public String carrier_type;
		public String carrier_number;
		public String n_p_o_b_a_n;
		public String invoice_tax_type;
		public String invoice_number;
		public String invoice_status;
		public String invoice_date;
		public String invoice_cancelled_at;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Item {
		public String id;
		public String order_number;
		public String return_from_order_id;
		public String system_order_number;
		public Object merchant_order_number;
		public String status;
		public String type;
		public String order_remarks;
		public OrderPayment order_payment;
		public OrderDelivery order_delivery;
		public DeliveryAddress delivery_address;
		public DeliveryData delivery_data;
		public CartAttributes cart_attributes;
		public String customer_id;
		public String customer_name;
		public String customer_email;
		public String customer_phone;
		public String customer_phone_country_code;
		public CustomerInfo customer_info;
		public String currency_iso;
		public Subtotal subtotal;
		public OrderDiscount order_discount;
		public UserCredit user_credit;
		public TotalTaxFee total_tax_fee;
		public Total total;
		public int order_points;
		public OrderPointsToCash order_points_to_cash;
		public Invoice invoice;
		public ArrayList<SubtotalItem> subtotal_items;
		public ArrayList<PromotionItem> promotion_items;
		public ArrayList<CustomDatum> custom_data;
		public ArrayList<Object> custom_discount_items;
		public AffiliateData affiliate_data;
		public String ref_order_id;
		public String ref_customer_id;
		public Channel channel;
		public String parent_order_id;
		public ArrayList<Object> child_order_ids;
		public Object split_at;
		public Object confirmed_at;
		public String created_from;
		public String created_by;
		public String updated_at;
		public String created_at;
		public boolean skip_fulfillment;
		public UtmData utm_data;
		public boolean ga_tracked;
		public ArrayList<Object> order_comments;
		public ArrayList<OrderNotes> order_notes;
		public ArrayList<Object> payment_slips;
		public Object affiliate_campaign;
		public OrderSource order_source;
		public ArrayList<String> tags;
		public InclusiveTaxInfo inclusive_tax_info;
		public Object cart_page_id;
		public boolean is_guest_checkout;
		public AppliedTaxInfo applied_tax_info;
		public  UnifiedOrderDTO ConvertToUnfiedOrderDTO() {
	    	UnifiedOrderDTO t= new UnifiedOrderDTO();
	    	t.order_name=order_number;
	    	t.line_items=new ArrayList<UnifiedOrderDTO.LineItem>();
	    	for (var item : subtotal_items) {
	    		var uItem = new UnifiedOrderDTO.LineItem();
	    		uItem.id=item.id;
	    		uItem.product_id=item.item_id;
	    		uItem.product_variant_id=item.item_variation_key;
	    		uItem.title=item.item_id;
	    		uItem.sku=item.sku;
	    		uItem.quantity=item.quantity;
//	    		uItem.qc=item.quantity;
	    		uItem.price=item.price.dollars;
	    		t.line_items.add(uItem);
	    	}
	    	return t;
	    }
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class OrderNotes {
		public String owner_type;
		public String value;
		public String time;

	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class ItemData {
		public String cart_item_id;
		public Object promotion_id;
		public ArrayList<String> parent_item_ids;
		public String triggering_item_id;
		public OrderPromotionItems order_promotion_items;
		public DiscountedPrice discounted_price;
		public boolean has_exclude_promotion_tag;
		public VariationData variation_data;
		public String type;
		public Object tax_region_id;
		public ItemData item_data;
		public Object variation_id;
		public int quantity;
		public Object tax_price;
		public Object custom_price;
		public Object product_id;
		public Object addon_feature_id;
		public String id;
		public Object order_custom_discount_items;
		public ArrayList<SelectedChildProduct> selected_child_products;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class ItemPrice {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class LastPayment {
		public String bin;
		public String brand;
		public String cardCategory;
		public String cardType;
		public Extension extension;
		public String issuerBank;
		public String issuerCountry;
		public String last4;
		public PaymentInstrument paymentInstrument;
		public String paymentMethod;
		public PaymentMethodOptions paymentMethodOptions;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Media {
		public Images images;
		public String _id;
		public AltTranslations alt_translations;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class MediaHash {
		public Images images;
		public String _id;
		public AltTranslations alt_translations;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class MemberPrice {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class NameTranslations {
		public String en;
		@JsonProperty("zh-hant")
		public String zhHant;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class NextAction {
		public String payToken;
		public String type;
		public String url;
		public String confirmStatus;
		public Object data;
		public String method;
		public String target;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class NotifyResponse {
		public long created;
		public Data data;
		public String id;
		public String type;
		public String controller;
		public String action;
		public String payment_gateway;
		public OrderPayment order_payment;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class ObjectData {
		public String gender;
		public String age_group;
		public String adult;
		public String condition;
		public String status;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class OrderDelivery {
		public String id;
		public String delivery_option_id;
		public String platform;
		public String status;
		public String delivery_status;
		public NameTranslations name_translations;
		public Total total;
		public String shipped_at;
		public Object arrived_at;
		public Object collected_at;
		public Object returned_at;
		public String updated_at;
		public String remark;
		public Object request_accepted_at;
		public Object request_authorized_at;
		public Object request_submitted_at;
		public Object requested_fmt_at;
		public boolean require_expired_upload;
		public boolean require_storeclosed_upload;
		public Object return_order_id;
		public Object store_closed_at;
		public Object storeclosed_upload_at;
		public Object exp_type;
		public boolean requires_customer_address;
		public String delivery_type;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class OrderDiscount {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class OrderPayment {
		public String id;
		public String payment_method_id;
		public String payment_type;
		public NameTranslations name_translations;
		public String status;
		public PaymentFee payment_fee;
		public Total total;
		public String paid_at;
		public String updated_at;
		public String created_at;
		public PaymentData payment_data;
		public String last_four_digits;
		public String ref_payment_id;
		public String shopline_payment_payment;
		public long created;
		public Data data;
		public String type;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class OrderPointsToCash {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class OrderPromotionItems {
		public String discounted_price;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class OrderSource {
		public String id;
		public String type;
		public Object source_id;
		public Object name;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Original {
		public double width;
		public double height;
		public String url;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Pagination {
		public int current_page;
		public int per_page;
		public int total_pages;
		public int total_count;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class PaidAmount {
		public String currency;
		public int value;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class PaymentData {
		public CreatePayment create_payment;
		public NotifyResponse notify_response;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class PaymentFee {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class PaymentInstrument {
		public String paymentMethod;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class PaymentMethodOptions {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class PrePay {
		public Detail detail;
		public String eventId;
		public Object merchantId;
		public String orderId;
		public int resCode;
		public int riskLevel;
		public String uid;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Price {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class PriceSale {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Promotion {
		public String _id;
		public Object addon_product_id;
		public ArrayList<String> available_platforms;
		public ArrayList<Object> banner_media_ids;
		public ArrayList<String> codes;
		public String coupon_generated_by;
		public String coupon_type;
		public String created_at;
		public DescriptionTranslations description_translations;
		public Object discount_amount;
		public String discount_on;
		public double discount_percentage;
		public String discount_type;
		public ArrayList<Object> discountable_category_ids;
		public ArrayList<String> discountable_product_ids;
		public Object discountable_quantity;
		public Object discounted_point;
		public Object discounted_price;
		public int drew_coupon_count;
		public String end_at;
		public Object extended_promotion_id;
		public boolean first_purchase_only;
		public boolean for_affiliate_campaign;
		public boolean is_accumulated;
		public Object max_use_count;
		public Object membership_tier_id;
		public String merchant_id;
		public String min_price_type;
		public boolean multiple_code;
		public boolean requires_membership;
		public SeoDescriptionTranslations seo_description_translations;
		public Object seo_keywords;
		public SeoTitleTranslations seo_title_translations;
		public boolean show_coupon;
		public String start_at;
		public String status;
		public TermTranslations term_translations;
		public TitleTranslations title_translations;
		public String updated_at;
		public int use_count;
		public int user_max_use_count;
		public ArrayList<Object> whitelisted_tag_contents;
		public boolean is_extend_promotion;
		public String id;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class PromotionConditionsDatum {
		public int min_item_count;
		public Object min_price;
		public Object type;
		public ArrayList<String> whitelisted_product_ids;
		public ArrayList<Object> whitelisted_category_ids;
		public ArrayList<Object> blacklisted_product_ids;
		public String id;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class PromotionItem {
		public String id;
		public Object discountable_amount;
		public DiscountedAmount discounted_amount;
		public SubtotalAfter subtotal_after;
		public Promotion promotion;
		public String updated_at;
		public String created_at;
		public ItemData item_data;
		public ArrayList<PromotionConditionsDatum> promotion_conditions_data;
		public String coupon_code;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class RiskResult {
		// public AuthNotify authNotify;
		public Object captureNotify;
		public Object channelRiskResult;
		// public PrePay prePay;
		public Object refundAfter;
		public Object refundBefore;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Sales {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class SeoDescriptionTranslations {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class SeoTitleTranslations {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Source {
		public double width;
		public double height;
		public String url;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class StoreAddressDetail {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Subtotal {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class SubtotalAfter {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class SubtotalItem {
		public String id;
		public String item_type;
		public ItemData item_data;
		public String item_id;
		public String item_variation_id;
		public String item_variation_key;
		public ItemPrice item_price;
		public Price price;
		public PriceSale price_sale;
		public Cost cost;
		public Object ref_data;
		public Media media;
		public Object product_subscription_id;
		public TitleTranslations title_translations;
		public FieldsTranslations fields_translations;
		public String sku;
		public boolean is_preorder;
		public int quantity;
		public Total total;
		public Object order_discounted_price;
		public DiscountedPrice discounted_price;
		public int total_points;
		public int item_points;
		public String created_by;
		public ObjectData object_data;
		public ArrayList<ChildProduct> child_products;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class SelectedChildProduct {
		public String child_product_id;
		public String child_variation_id;
		public Integer quantity;
		public String stock_id;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ChildProduct {
		public TitleTranslations title_translations;
		public BigDecimal weight;
		public String id;
		public String variation_id;
		public FieldsTranslations fields_translations;
		public Price price;
		public PriceSale price_sale;
		public String sku;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class TermTranslations {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Thumb {
		public double width;
		public double height;
		public String url;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class TitleTranslations {
		@JsonProperty("zh-hant")
		public String zhHant;
		public String en;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class Total {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class TotalTaxFee {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class TransparentLarge {
		public double width;
		public double height;
		public String url;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class TransparentThumb {
		public double width;
		public double height;
		public String url;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class TransparentXlarge {
		public double width;
		public double height;
		public String url;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class UserCredit {
		public int cents;
		public String currency_symbol;
		public String currency_iso;
		public String label;
		public double dollars;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class UtmData {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class VariationData {
		public String _id;
		public String barcode_type;
		public Cost cost;
		public String created_at;
//	        public FeedVariations feed_variations;
		public ArrayList<Field> fields;
		public FieldsTranslations fields_translations;
		public String gtin;
		public String key;
		public Object location_id;
		public int max_order_quantity;
		public String media_id;
		public MemberPrice member_price;
		public Object mpn;
		public boolean out_of_stock_orderable;
		public Price price;
		public PriceSale price_sale;
		public String root_product_variation_id;
		public String sku;
		public ArrayList<String> stock_ids;
		public Object unlimited_quantity;
		public String updated_at;
		public ArrayList<String> variant_option_ids;
		public String wapos_id;
		public double weight;
		public MediaHash media_hash;
	}

}
