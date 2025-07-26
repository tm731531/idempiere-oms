package tw.tom.oms.service;

import tw.tom.oms.interfaces.IOrderService;
import tw.tom.oms.service.*;

public class OrderServiceFactory {
	public static IOrderService getService(String platform) {
		switch (platform) {
		case "cyberbizV1":
			return new CyberbizOrderService();
		case "cyberbizV2":
			return new CyberbizV2OrderService();
		case "shopline":
			return new ShoplineOrderService();
		case "momo":
			return new MomoOrderService();
		default:
			throw new IllegalArgumentException("Unsupported platform: " + platform);
		}
	}
}
