package tw.tom.oms.helper;

public class ShopeeApiMethod {

    public class Version {
        public static String version2 = "/api/v2";
    }

    public class Shop {
        public static String GetShopInfo = "/shop/get_shop_info";
    }

    public class ShopCategory {
        public static String GetShopCategories = "/shop_category/get_shop_category_list";
        public static String AddShopCategory = "/shop_category/add_shop_category";
        public static String AddItems = "/shop_category/add_item_list";
        public static String GetItems = "/shop_category/get_item_list";
    }

    public class Product {
        public static String GetCategories = "/api/v2/product/get_category";
        public static String AddItem = "/api/v2/product/add_item";
        public static String GetAttributes = "/api/v2/product/get_attributes";
        public static String InitTierVariation = "/api/v2/product/init_tier_variation";
        public static String GetItemsList = "/api/v2/product/get_item_list";
        public static String GetItemDetail = "/product/get";
        public static String UnlistItem = "/product/unlist_item";
        public static String UpdatePrice = "/api/v2/product/update_price";
        public static String UpdateStock = "/api/v2/product/update_stock";
        public static String GetDaysToShipLimit = "product/get_dts_limit";
        public static String UpdateItem = "/product/update_item";
        public static String SupportSizeChart = "product/support_size_chart";
        public static String UpdateSizeChart = "product/update_size_chart";
        public static String AddModel = "product/add_model";
        public static String GetModelList = "/api/v2/product/get_model_list";
        public static String GetItemBaseInfo = "/api/v2/product/get_item_base_info";
        public static String GetModelStatus = "/api/v2/product/get_model_list";
        public static String GetItemStatus = "/api/v2/product/get_item_base_info";
        public static String UpdateStatus = "/api/v2/product/update_item";
        public static String GetBrandList = "/api/v2/product/get_brand_list";

    }
    public class Media {
        public static String InitVideoUpload = "media_space/init_video_upload";
        public static String UploadVideoPart = "media_space/upload_video_part";
        public static String UploadVideoComplete = "media_space/complete_video_upload";
        public static String GetUploadResult = "media_space/get_video_upload_result";
        public static String UploadImg = "/api/v2/media_space/upload_image";
    }

    public class Logistics {
        public static String GetChannelList = "/api/v2/logistics/get_channel_list";
        public static String UpdateChannel = "/logistics/update_channel";
        public static String GetShippingDocumentParameter = "/logistics/get_shipping_document_parameter";
        public static String CreateShippingDocument = "/logistics/create_shipping_document";
        public static String GetShippingDocumentResult = "/logistics/get_shipping_document_result";
        public static String DownloadShippingDocument = "/logistics/download_shipping_document";
        public static String ShipOrder = "/logistics/ship_order";
        public static String GetTrackingInfo = "/logistics/get_tracking_info";
        public static String GetTrackingNumber = "/logistics/get_tracking_number";
        public static String GetShippingParameter = "/logistics/get_shipping_parameter";

    }

    public class Order {
        public static String GetOrderList = "/api/v2/order/get_order_list";
        public static String GetOrderDetail = "/api/v2/order/get_order_detail";
        public static String cancelOrder = "/api/v2/order/cancel_order";
    }

    public class Return {
        public static String GetReturnList = "/api/v2/returns/get_return_list";
        public static String GetReturnDetail = "/api/v2/returns/get_return_detail";
    }

    public class Payment {
        public static String GetEscrowDetail = "/api/v2/payment/get_escrow_detail";
    }
}
