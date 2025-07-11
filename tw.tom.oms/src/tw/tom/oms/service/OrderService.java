package tw.tom.oms.service;

import java.util.List;

import tw.tom.oms.DTO.UnifiedOrderDTO;
import tw.tom.oms.model.MOMS_Channel;

public interface OrderService {
	List<UnifiedOrderDTO> fetchOrders(MOMS_Channel channelData) throws Exception;

}
