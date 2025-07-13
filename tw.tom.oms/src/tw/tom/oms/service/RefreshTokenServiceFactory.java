package tw.tom.oms.service;

import tw.tom.oms.interfaces.IRefreshTokenService;
import tw.tom.oms.service.*;

public class RefreshTokenServiceFactory {
	public static IRefreshTokenService getService(String platform) {
		switch (platform.toLowerCase()) {
		case "cyberbizV2":
			return new CyberbizV2RefreshTokenService();
		default:
			throw new IllegalArgumentException("Unsupported platform: " + platform);
		}
	}
}
