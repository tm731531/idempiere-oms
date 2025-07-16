package tw.tom.oms.DTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopeeOrderListResponse {

	public String error;
	public String message;
	public Response response;
	public String request_id;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class OrderList {
		public String order_sn;
		public String order_status;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Response {
		public boolean more;
		public String next_cursor;
		public ArrayList<OrderList> order_list;
	}
}
