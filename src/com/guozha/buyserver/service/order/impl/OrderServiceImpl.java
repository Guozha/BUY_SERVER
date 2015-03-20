package com.guozha.buyserver.service.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BuyOrder;
import com.guozha.buyserver.persistence.beans.BuyOrderGoods;
import com.guozha.buyserver.persistence.beans.BuyOrderMenu;
import com.guozha.buyserver.persistence.beans.BuyOrderMenuGoods;
import com.guozha.buyserver.persistence.mapper.BuyOrderGoodsMapper;
import com.guozha.buyserver.persistence.mapper.BuyOrderMapper;
import com.guozha.buyserver.persistence.mapper.BuyOrderMenuGoodsMapper;
import com.guozha.buyserver.persistence.mapper.BuyOrderMenuMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketTimeMapper;
import com.guozha.buyserver.service.order.OrderService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.order.CancelOrderRequest;
import com.guozha.buyserver.web.controller.order.GoodsInfo;
import com.guozha.buyserver.web.controller.order.MarketTimeResponse;
import com.guozha.buyserver.web.controller.order.MenuInfo;
import com.guozha.buyserver.web.controller.order.OrderDetailResponse;
import com.guozha.buyserver.web.controller.order.SearchOrderRequest;
import com.guozha.buyserver.web.controller.order.SearchOrderResponse;

@Transactional(rollbackFor = Exception.class)
@Service("orderService")
public class OrderServiceImpl extends AbstractBusinessObjectServiceMgr
		implements OrderService {
	
	@Autowired
	private MarMarketTimeMapper marMarketTimeMapper;
	@Autowired
	private BuyOrderMapper buyOrderMapper;
	@Autowired
	private BuyOrderGoodsMapper buyOrderGoodsMapper;
	@Autowired
	private BuyOrderMenuMapper buyOrderMenuMapper;
	@Autowired
	private BuyOrderMenuGoodsMapper buyOrderMenuGoodsMapper;

	@Override
	public List<MarketTimeResponse> findMarketTime(int marketId) {
		return marMarketTimeMapper.findTimeByMarketId(marketId);
	}

	@Override
	public MsgResponse cancelOrder(CancelOrderRequest vo) {
		buyOrderMapper.updateStatus(vo.getOrderId(), vo.getOldStatus(), "00"); //ORDER_STATUS 00-取消
		return new MsgResponse(MsgResponse.SUCC, "订单取消成功");
	}

	@Override
	public List<SearchOrderResponse> listOrder(SearchOrderRequest vo) {
		List<String> statusList = new ArrayList<String>();
		if("1".equals(vo.getSearchType())){// ORDER_SEARCH_TYPE 1-进行中
			statusList.add("01");// ORDER_STATUS 01-新创建
			statusList.add("02");// ORDER_STATUS 02-新订单
			statusList.add("03");// ORDER_STATUS 03-已接收
			statusList.add("04");// ORDER_STATUS 04-已称重
			statusList.add("05");// ORDER_STATUS 05-配送中
		}else if("2".equals(vo.getSearchType())){ // ORDER_SEARCH_TYPE 2-已完成
			statusList.add("06");// ORDER_STATUS 06-已签收
		}
		return buyOrderMapper.findOrder(vo.getUserId(), statusList, vo.getStartIndex(), vo.getPageSize());
	}

	@Override
	public OrderDetailResponse getOrderDetail(int orderId) {
		OrderDetailResponse response = new OrderDetailResponse();
		
		BuyOrder buyOrder = buyOrderMapper.load(orderId);
		List<BuyOrderGoods> buyOrderGoodsList = buyOrderGoodsMapper.findByOrder(orderId);
		List<BuyOrderMenu> buyOrderMenuList = buyOrderMenuMapper.findByOrder(orderId);
		
		response.setOrderId(buyOrder.getOrderId());
		response.setOrderNo(buyOrder.getOrderNo());
		response.setCreateTime(buyOrder.getCreateTime());
		response.setArrivalTime(buyOrder.getArrivalTime());
		response.setReceiveMen(buyOrder.getReceiveMen());
		response.setReceiveMobile(buyOrder.getReceiveMobile());
		response.setReceiveAddr(buyOrder.getReceiveAddr());
		response.setQuantity(buyOrder.getQuantity());
		response.setTotalPrice(buyOrder.getTotalPrice());
		response.setStatus(buyOrder.getStatus());
		
		for(BuyOrderGoods buyOrderGoods : buyOrderGoodsList){
			
			GoodsInfo goodsInfo = new GoodsInfo();
			goodsInfo.setGoodsId(buyOrderGoods.getGoodsId());
			goodsInfo.setGoodsName(buyOrderGoods.getGoodsName());
			goodsInfo.setGoodsImg(buyOrderGoods.getGoodsImg());
			goodsInfo.setUnitPrice(buyOrderGoods.getUnitPrice());
			goodsInfo.setAmount(buyOrderGoods.getAmount());
			goodsInfo.setPrice(buyOrderGoods.getPrice());
			goodsInfo.setGoodsStar(buyOrderGoods.getGoodStar());
			
			response.getGoodsInfoList().add(goodsInfo);
		}
		
		for(BuyOrderMenu buyOrderMenu : buyOrderMenuList){
			
			MenuInfo menuInfo = new MenuInfo();
			menuInfo.setMenuId(buyOrderMenu.getMenuId());
			menuInfo.setMenuName(buyOrderMenu.getMenuName());
			menuInfo.setMenuImg(buyOrderMenu.getMenuImg());
			menuInfo.setUnitPrice(buyOrderMenu.getUnitPrice());
			menuInfo.setAmount(buyOrderMenu.getAmount());
			menuInfo.setPrice(buyOrderMenu.getPrice());
			
			List<BuyOrderMenuGoods> buyOrderMenuGoodsList = buyOrderMenuGoodsMapper.findByOrderMenu(buyOrderMenu.getOrderMenuId());
			for(BuyOrderMenuGoods buyOrderMenuGoods : buyOrderMenuGoodsList){
				
				GoodsInfo goodsInfo = new GoodsInfo();
				goodsInfo.setGoodsId(buyOrderMenuGoods.getGoodsId());
				goodsInfo.setGoodsName(buyOrderMenuGoods.getGoodsName());
				goodsInfo.setGoodsImg(buyOrderMenuGoods.getGoodsImg());
				goodsInfo.setUnitPrice(buyOrderMenuGoods.getUnitPrice());
				goodsInfo.setAmount(buyOrderMenuGoods.getAmount());
				goodsInfo.setPrice(buyOrderMenuGoods.getPrice());
				goodsInfo.setGoodsStar(buyOrderMenuGoods.getGoodsStar());
				
				menuInfo.getGoodsInfoList().add(goodsInfo);
			}
			
			response.getMenuInfoList().add(menuInfo);
		}
		
		return response;
	}

}
