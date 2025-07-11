package tw.tom.oms.service;

import tw.tom.oms.service.CyberbizOrderService;

public class OrderServiceFactory {
	public static OrderService getService(String platform) {
		switch (platform.toLowerCase()) {
		case "cyberbizV1":
			return new CyberbizOrderService();
		case "cyberbizV2":
			return new CyberbizV2OrderService();
		case "shopline":
			return new ShoplineOrderService();
		default:
			throw new IllegalArgumentException("Unsupported platform: " + platform);
		}
	}
}
