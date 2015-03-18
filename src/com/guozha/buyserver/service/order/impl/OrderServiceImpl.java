package com.guozha.buyserver.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.mapper.BuyOrderMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketTimeMapper;
import com.guozha.buyserver.service.order.OrderService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.order.CancelOrderRequest;
import com.guozha.buyserver.web.controller.order.MarketTimeResponse;

@Transactional(rollbackFor = Exception.class)
@Service("orderService")
public class OrderServiceImpl extends AbstractBusinessObjectServiceMgr
		implements OrderService {
	
	@Autowired
	private MarMarketTimeMapper marMarketTimeMapper;
	@Autowired
	private BuyOrderMapper buyOrderMapper;

	@Override
	public List<MarketTimeResponse> findMarketTime(int marketId) {
		return marMarketTimeMapper.findTimeByMarketId(marketId);
	}

	@Override
	public MsgResponse cancelOrder(CancelOrderRequest vo) {
		buyOrderMapper.updateStatus(vo.getOrderId(), vo.getOldStatus(), "00"); //ORDER_STATUS 00-取消
		return new MsgResponse(MsgResponse.SUCC, "订单取消成功");
	}

}
