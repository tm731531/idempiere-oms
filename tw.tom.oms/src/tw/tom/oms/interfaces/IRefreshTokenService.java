package tw.tom.oms.interfaces;

import java.util.List;

import tw.tom.oms.DTO.RefreshTokenDTO;
import tw.tom.oms.DTO.UnifiedOrderDTO;
import tw.tom.oms.model.MOMS_Channel;
import tw.tom.oms.model.MOMS_Platform;

public interface IRefreshTokenService {
	RefreshTokenDTO refreshToken(MOMS_Channel channelData,MOMS_Platform platformData) throws Exception;

}
