package tw.tom.oms.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyGraphQLGetOrderResponse {

	public static String GRAPHQL_ORDER_RETURNS_NODES_RETURNLINEITEMS_CURSOR = "gornrc_s";
	public static String GRAPHQL_ORDER_RETURNS_CURSOR = "gorc_s";
	public static String GRAPHQL_ORDER_REFUNDS_REFUNDLINEITEMS_CURSOR = "gorrc_s";
	public static String GRAPHQL_ORDER_LINEITEMS_CURSOR = "golc_s";
	public static String GRAPHQL_ORDER_FULFILLMENTORDERS_CURSOR = "gofc_s";
	public static String GRAPHQL_ORDER_DISCOUNTAPPLICATIONS_CURSOR = "godc_s";
	public Data data;
	public ShopifyGraphQLExtension extensions;
	public List<Error> errors;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class AllocatedAmountSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class App {
		public String id;
		public String name;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Cost {
		public int requestedQueryCost;
		public int actualQueryCost;
		public ThrottleStatus throttleStatus;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class CurrentTotalDiscountsSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class CurrentTotalPriceSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class CustomAttribute {
		public String key;
		public String value;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Customer {
		public Object firstName;
		public String lastName;
		public String phone;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Data {
		public Order order;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DeliveryProfile {
		public String id;
		public String name;
		@JsonProperty("default")
		public boolean mydefault;
		public boolean legacyMode;
		public int zoneCountryCount;
		public int originLocationCount;
		public int locationsWithoutRatesCount;
		public int activeMethodDefinitionsCount;
		public ArrayList<UnassignedLocation> unassignedLocations;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DiscountAllocation {
		public AllocatedAmountSet allocatedAmountSet;
		public DiscountApplication discountApplication;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DiscountApplication {
		public int index;
		public String targetSelection;
		public String targetType;
		public Value value;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DiscountApplications {
		public ArrayList<DiscountApplicationsEdge> edges;
		public ShopifyGraphQLPageInfo pageInfo;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DiscountApplicationsEdge {
		public DiscountApplicationsNode node;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DiscountApplicationsNode {
		public String allocationMethod;
		public String index;
		public String targetSelection;
		public String targetType;
		public Object value;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DiscountedTotalSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DiscountedUnitPriceSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Extensions {
		public Cost cost;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class FulfillmentOrders {
		public ArrayList<FulfillmentOrderEdge> edges;
		public ShopifyGraphQLPageInfo pageInfo;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class FulfillmentOrderEdge {
		public FulfillmentOrderNode node;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class FulfillmentOrderNode {
		public String id;
		public String fulfillBy;
		public String fulfillAt;
		public DeliveryMethod deliveryMethod;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class InventoryItem {
		public String id;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class LineItem {
		public String id;
		public String name;
		public int currentQuantity;
		public int nonFulfillableQuantity;
		public int quantity;
		public int refundableQuantity;
		public boolean restockable;
		public String sku;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class LineItems {
		public ArrayList<LineItemsNode> nodes;
		public ShopifyGraphQLPageInfo pageInfo;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class LineItemsNode {
		public String id;
		public String name;
		public int quantity;
		public int currentQuantity;
		public int nonFulfillableQuantity;
		public int refundableQuantity;
		public boolean requiresShipping;
		public boolean restockable;
		public String sku;
		public String title;
		public int unfulfilledQuantity;
		public String variantTitle;
		public String vendor;
		public ArrayList<Map<String, Object>> customAttributes;
		public ArrayList<DiscountAllocation> discountAllocations;
		public Product product;
		public Variant variant;
		public DiscountedTotalSet discountedTotalSet;
		public DiscountedUnitPriceSet discountedUnitPriceSet;
		public OriginalTotalSet originalTotalSet;
		public OriginalUnitPriceSet originalUnitPriceSet;
		public TotalDiscountSet totalDiscountSet;
		public UnfulfilledDiscountedTotalSet unfulfilledDiscountedTotalSet;
		public UnfulfilledOriginalTotalSet unfulfilledOriginalTotalSet;
		public List<TaxLine> taxLines;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Order {
		public String id;
		public String name;
		public String[] tags;
		public String currencyCode;
		public String createdAt;
		public String cancelledAt;
		public Object closedAt;
		public String updatedAt;
		public boolean confirmed;
		public boolean closed;
		public String cancelReason;
		public String displayFinancialStatus;
		public String displayFulfillmentStatus;
		public String note;
		public ArrayList<String> paymentGatewayNames;
		public ArrayList<String> discountCodes;
		public int currentSubtotalLineItemsQuantity;
		public boolean refundable;
		public Object physicalLocation;
		public ArrayList<CustomAttribute> customAttributes;
		public Customer customer;
		public ShippingAddress shippingAddress;
		public App app;
		public DiscountApplications discountApplications;
		public ArrayList<Fulfillment> fulfillments;
		public FulfillmentOrders fulfillmentOrders;
		public LineItems lineItems;
		public ArrayList<Refund> refunds;
		public Returns returns;
		public CurrentTotalDiscountsSet currentTotalDiscountsSet;
		public CurrentTotalPriceSet currentTotalPriceSet;
		public TotalShippingPriceSet totalShippingPriceSet;
		public Object originalTotalAdditionalFeesSet;
		public Object currentTotalAdditionalFeesSet;
		public TotalDiscountsSet totalDiscountsSet;

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class OriginalTotalSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class OriginalUnitPriceSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class PriceSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Product {
		public String id;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Refund {
		public String id;
		public String note;
		public String createdAt;
		public String legacyResourceId;
		public ArrayList<Object> duties;
		public RefundLineItems refundLineItems;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class RefundLineItems {
		public ArrayList<RefundLineItemsNode> nodes;
		public ShopifyGraphQLPageInfo pageInfo;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class RefundLineItemsNode {
		public ArrayList<LineItem> nodes;
		public ShopifyGraphQLPageInfo pageInfo;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Returns {
		public ArrayList<ReturnsNode> nodes;
		public ShopifyGraphQLPageInfo pageInfo;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ReturnsNode {
		public String id;
		public String name;
		public String status;
		public int totalQuantity;
		public Decline decline;
		public ReturnLineItem returnLineItems;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Decline {
		public String note;
		public String reason;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ReturnLineItem {
		public ArrayList<ReturnLineItemNode> nodes;

		public ShopifyGraphQLPageInfo pageInfo;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ReturnLineItemNode {
		public String id;
		public int quantity;
		public int refundableQuantity;
		public int refundedQuantity;
		public String returnReason;
		public String returnReasonNote;
		public WithCodeDiscountedTotalPriceSet withCodeDiscountedTotalPriceSet;
		public FulfillmentLineItem fulfillmentLineItem;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WithCodeDiscountedTotalPriceSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class FulfillmentLineItem {
		public FulfillmentLineItemLineItem lineItem;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class FulfillmentLineItemLineItem {
		public String id;
		public String name;
		public String sku;
		public FulfillmentLineItemLineItemProduct product;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class FulfillmentLineItemLineItemProduct {
		public String id;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ShippingAddress {
		public String address1;
		public String address2;
		public String city;
		public String company;
		public boolean coordinatesValidated;
		public String country;
		public String name;
		public String phone;
		public String province;
		public String zip;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ShopMoney {
		public BigDecimal amount;
		public String currencyCode;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class TaxLine {
		public boolean channelLiable;
		public double rate;
		public double ratePercentage;
		public String title;
		public PriceSet priceSet;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ThrottleStatus {
		public double maximumAvailable;
		public int currentlyAvailable;
		public double restoreRate;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class TotalDiscountSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class TotalDiscountsSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class TotalShippingPriceSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class UnfulfilledDiscountedTotalSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class UnfulfilledOriginalTotalSet {
		public ShopMoney shopMoney;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Value {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Variant {
		public String id;
		public boolean availableForSale;
		public String barcode;
		public String createdAt;
		public String defaultCursor;
		public String displayName;
		public int inventoryQuantity;
		public String legacyResourceId;
		public int position;
		public String sku;
		public String taxCode;
		public boolean taxable;
		public String title;
		public String updatedAt;
		public double weight;
		public String compareAtPrice;
		public InventoryItem inventoryItem;
		public DeliveryProfile deliveryProfile;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Error {
		public String message;
		public ErrorExtension extensions;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ErrorExtension {
		public String code;
		public String documentation;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Fulfillment {
		public String id;
		public String createdAt;
		public List<Tracking> trackingInfo;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Tracking {
		public String company;
		public String number;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DeliveryMethod {
		public String methodType;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class UnassignedLocation {
		public String id;
	}

	public static boolean hasNextCursor(ShopifyGraphQLGetOrderResponse tempResponse, Map<String, String> cursorMap) {
		boolean rtliCursor = false;
		boolean rtCursor = false;
		boolean rfliCursor = false;
		boolean liCursor = false;
		boolean foCursor = false;
		boolean dalCursor = false;

		if (tempResponse.data != null && tempResponse.data.order != null && tempResponse.data.order.returns != null) {
			if (tempResponse.data.order.returns.nodes != null) {
				for (var node : tempResponse.data.order.returns.nodes) {
					if (node.returnLineItems != null) {
						if (node.returnLineItems.pageInfo != null) {
							rtliCursor = node.returnLineItems.pageInfo.hasNextPage;

							if (rtliCursor) {
								cursorMap.put(GRAPHQL_ORDER_RETURNS_NODES_RETURNLINEITEMS_CURSOR,
										node.returnLineItems.pageInfo.endCursor);
							}
						}
					}
				}
			}

			if (tempResponse.data.order.returns.pageInfo != null) {
				rtCursor = tempResponse.data.order.returns.pageInfo.hasNextPage;

				if (rtCursor) {
					cursorMap.put(GRAPHQL_ORDER_RETURNS_CURSOR, tempResponse.data.order.returns.pageInfo.endCursor);
				}
			}
		}

		if (tempResponse.data != null && tempResponse.data.order != null && tempResponse.data.order.refunds != null) {
			for (var refund : tempResponse.data.order.refunds) {
				if (refund.refundLineItems != null && refund.refundLineItems.pageInfo != null) {
					rfliCursor = refund.refundLineItems.pageInfo.hasNextPage;

					if (rfliCursor) {
						cursorMap.put(GRAPHQL_ORDER_REFUNDS_REFUNDLINEITEMS_CURSOR,
								refund.refundLineItems.pageInfo.endCursor);
					}
				}
			}
		}

		if (tempResponse.data != null && tempResponse.data.order != null && tempResponse.data.order.lineItems != null) {
			if (tempResponse.data.order.lineItems.pageInfo != null) {
				liCursor = tempResponse.data.order.lineItems.pageInfo.hasNextPage;

				if (liCursor) {
					cursorMap.put(GRAPHQL_ORDER_LINEITEMS_CURSOR, tempResponse.data.order.lineItems.pageInfo.endCursor);
				}
			}
		}

		if (tempResponse.data != null && tempResponse.data.order != null
				&& tempResponse.data.order.fulfillmentOrders != null) {
			if (tempResponse.data.order.fulfillmentOrders.pageInfo != null) {
				foCursor = tempResponse.data.order.fulfillmentOrders.pageInfo.hasNextPage;

				if (foCursor) {
					cursorMap.put(GRAPHQL_ORDER_FULFILLMENTORDERS_CURSOR,
							tempResponse.data.order.fulfillmentOrders.pageInfo.endCursor);
				}
			}
		}

		if (tempResponse.data != null && tempResponse.data.order != null
				&& tempResponse.data.order.discountApplications != null) {
			if (tempResponse.data.order.discountApplications.pageInfo != null) {
				dalCursor = tempResponse.data.order.discountApplications.pageInfo.hasNextPage;

				if (dalCursor) {
					cursorMap.put(GRAPHQL_ORDER_DISCOUNTAPPLICATIONS_CURSOR,
							tempResponse.data.order.discountApplications.pageInfo.endCursor);
				}
			}
		}

		return rtliCursor || rtCursor || rfliCursor || liCursor || foCursor || dalCursor;
	}

	public static Map<String, ShopifyGraphQLGetOrderResponse.LineItemsNode> groupOrderLineItems(
			ShopifyGraphQLGetOrderResponse tempResponse, String orderId,
			Map<String, ShopifyGraphQLGetOrderResponse.LineItemsNode> lineItemMap) {
		if (tempResponse.data != null && tempResponse.data.order != null && tempResponse.data.order.lineItems != null
				&& tempResponse.data.order.lineItems.nodes != null) {
			for (var lineItem : tempResponse.data.order.lineItems.nodes) {
				String key = orderId + lineItem.id;
				if (!lineItemMap.containsKey(key)) {
					lineItemMap.put(key, lineItem);
				}
			}
		}

		return lineItemMap;
	}
}
