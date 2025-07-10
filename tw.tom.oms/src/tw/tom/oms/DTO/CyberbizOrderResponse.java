package tw.tom.oms.DTO;


import java.util.ArrayList;
import java.util.List;

public class CyberbizOrderResponse {
    public String created_at;
    public String updated_at;
    public int order_number;
    public String order_name;
    public Customer customer;
    public Buyer buyer;
    public Receiver receiver;
    public List<LineItem> line_items;
    public static class Customer {
        public String name;
        public String status;
        public String email;
        public String mobile;
        public List<Tag> tags;
        public Address address;
    }
    public static class Buyer {
        public String email;
        public String mobile;
    }
    public static class Receiver {
        public String name;
        public String phone;
        public String address;
    }
    public static class LineItem {
        public long id;
        public long product_id;
        public long product_variant_id;
        public String title;
        public String sku;
        public String qc;
        public int quantity;
        public double price;
    }
 // Tag.java
    public static class Tag {
        public String name;
    }
 // Address.java
    public static class Address {
        public String phone;
        public String address;
        public DetailAddress detail_address;
    }// DetailAddress.java
    public static class DetailAddress {
        public String zip;
        public String country;
        public String province;
        public String city;
        public String district;
        public String address1;
        public String address2;
    }
    public  UnifiedOrderDTO ConvertToTempAll() {
    	UnifiedOrderDTO t= new UnifiedOrderDTO();
    	t.order_name=order_name;
    	t.line_items=new ArrayList<UnifiedOrderDTO.LineItem>();
    	for (var item : line_items) {
    		var uItem = new UnifiedOrderDTO.LineItem();
    		uItem.id=item.id;
    		uItem.product_id=item.product_id;
    		uItem.product_variant_id=item.product_variant_id;
    		uItem.title=item.title;
    		uItem.sku=item.sku;
    		uItem.quantity=item.quantity;
    		uItem.qc=item.qc;
    		uItem.price=item.price;
    		t.line_items.add(uItem);
    	}
    	return t;
    }

}
