package com.guozha.buyserver.service.order;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.order.CancelOrderRequest;
import com.guozha.buyserver.web.controller.order.MarketTimeResponse;

public interface OrderService extends BusinessObjectServiceMgr {
	
	List<MarketTimeResponse> findMarketTime(int marketId);
	
	MsgResponse cancelOrder(CancelOrderRequest vo);

}
