package tw.tom.oms.DTO;


import java.util.List;

public class CyberbizOrder {
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


}
