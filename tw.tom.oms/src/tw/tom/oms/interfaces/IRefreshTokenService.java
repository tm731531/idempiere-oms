package tw.tom.oms.interfaces;

import java.util.List;

import tw.tom.oms.DTO.UnifiedOrderDTO;
import tw.tom.oms.model.MOMS_Channel;

public interface IRefreshTokenService {
	String refreshToken(MOMS_Channel channelData) throws Exception;

}
