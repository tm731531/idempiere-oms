package tw.tom.oms.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyGraphQLExtension {
	public ExtensionCost cost;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ExtensionCost {
		public int requestedQueryCost;
		public int actualQueryCost;
		public ExtensionThrottleStatus throttleStatus;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ExtensionThrottleStatus {
		public float maximumAvailable;
		public int currentlyAvailable;
		public float restoreRate;
	}
}
