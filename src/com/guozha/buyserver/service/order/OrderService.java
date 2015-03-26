package com.guozha.buyserver.service.order;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.order.CancelOrderRequest;
import com.guozha.buyserver.web.controller.order.InsertOrderRequest;
import com.guozha.buyserver.web.controller.order.InsertPrepareOrderRequest;
import com.guozha.buyserver.web.controller.order.InsertSupplyOrderRequest;
import com.guozha.buyserver.web.controller.order.MarketTimeResponse;
import com.guozha.buyserver.web.controller.order.OrderDetailResponse;
import com.guozha.buyserver.web.controller.order.SearchOrderRequest;
import com.guozha.buyserver.web.controller.order.SearchOrderResponse;

public interface OrderService extends BusinessObjectServiceMgr {
	
	List<MarketTimeResponse> findMarketTime(int marketId);
	
	MsgResponse cancelOrder(CancelOrderRequest vo);
	
	SearchOrderResponse listOrder(SearchOrderRequest vo);
	
	OrderDetailResponse getOrderDetail(int orderId);
	
	MsgResponse insertOrder(InsertOrderRequest vo);
	
	MsgResponse insertSupplyOrder(InsertSupplyOrderRequest vo);
	
	MsgResponse insertPrepareOrder(InsertPrepareOrderRequest vo);
	
	void sendOrder(int orderId);

}
