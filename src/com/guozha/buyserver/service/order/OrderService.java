package com.guozha.buyserver.service.order;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.mapper.AccAddressMapper;
import com.guozha.buyserver.persistence.mapper.BuyCartMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.common.CommonService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.order.CancelOrderRequest;
import com.guozha.buyserver.web.controller.order.InsertOrderRequest;
import com.guozha.buyserver.web.controller.order.InsertPrepareOrderRequest;
import com.guozha.buyserver.web.controller.order.InsertSupplyOrderRequest;
import com.guozha.buyserver.web.controller.order.MarkRequest;
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

	// 订单评价
	MsgResponse orderMark(MarkRequest mark);
	
	// 订单商品评价
	MsgResponse goodsMark(MarkRequest mark);
	
	AccAddressMapper getAccAddressMapper();

	void setAccAddressMapper(AccAddressMapper accAddressMapper);
	
	CommonService getCommonService();

	void setCommonService(CommonService commonService);
	
	BuyCartMapper getBuyCartMapper();

	void setBuyCartMapper(BuyCartMapper buyCartMapper);

	MarMarketGoodsMapper getMarMarketGoodsMapper();

	void setMarMarketGoodsMapper(MarMarketGoodsMapper marMarketGoodsMapper);
	
	MnuMenuMapper getMnuMenuMapper();

	void setMnuMenuMapper(MnuMenuMapper mnuMenuMapper);
	
	GooGoodsMapper getGooGoodsMapper();

	void setGooGoodsMapper(GooGoodsMapper gooGoodsMapper);
	
	MnuMenuGoodsMapper getMnuMenuGoodsMapper();

	void setMnuMenuGoodsMapper(MnuMenuGoodsMapper mnuMenuGoodsMapper);

}
