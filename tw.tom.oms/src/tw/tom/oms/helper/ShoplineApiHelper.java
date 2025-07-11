package tw.tom.oms.helper;

/*
https://open-api.docs.shoplineapp.com/docs/openapi-request-example
shopline
* */
public class ShoplineApiHelper {
	public static String apiHost ="https://open.shopline.io/";
	public class Order {
		public static String Order = "v1/orders/%s";
		public static String OrderList = "v1/orders";
		public static String DeliveryOption = "v1/delivery_options";
		public static String SplitOrder = "v1/orders/%s/split";
		public static String ExecuteShipment = "v1/orders/%s/execute_shipment";
		public static String Label = "v1/orders/label";
		public static String UpdateOrder = "v1/orders/%s";
		public static String UpdateOrderStatus = "v1/orders/%s/status";
		public static String UpdateOrderDeliveryStatus = "v1/orders/%s/order_delivery_status";
	}

	public class Setting {
		public static String WebHooks = "v1/webhooks";
	}

	public class Product {
		public static String Detail = "v1/products";
		public static String Category = "v1/categories";
		public static String CreateProduct = "v1/products";

	}

	public class Refund {
		public static String RefundList = "v1/return_orders";

	}
}
