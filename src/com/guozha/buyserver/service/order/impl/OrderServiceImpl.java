package com.guozha.buyserver.service.order.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.PriceUtils;
import com.guozha.buyserver.common.util.SystemResource;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.AccAddress;
import com.guozha.buyserver.persistence.beans.BuyCart;
import com.guozha.buyserver.persistence.beans.BuyOrder;
import com.guozha.buyserver.persistence.beans.BuyOrderChild;
import com.guozha.buyserver.persistence.beans.BuyOrderGoods;
import com.guozha.buyserver.persistence.beans.BuyOrderMenu;
import com.guozha.buyserver.persistence.beans.BuyOrderMenuGoods;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.MarMarketGoods;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.SysSeller;
import com.guozha.buyserver.persistence.mapper.AccAddressMapper;
import com.guozha.buyserver.persistence.mapper.BuyCartMapper;
import com.guozha.buyserver.persistence.mapper.BuyOrderChildMapper;
import com.guozha.buyserver.persistence.mapper.BuyOrderGoodsMapper;
import com.guozha.buyserver.persistence.mapper.BuyOrderMapper;
import com.guozha.buyserver.persistence.mapper.BuyOrderMenuGoodsMapper;
import com.guozha.buyserver.persistence.mapper.BuyOrderMenuMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketTimeMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.persistence.mapper.SysSellerMapper;
import com.guozha.buyserver.service.common.CommonService;
import com.guozha.buyserver.service.order.OrderService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.order.CancelOrderRequest;
import com.guozha.buyserver.web.controller.order.GoodsInfo;
import com.guozha.buyserver.web.controller.order.InsertOrderRequest;
import com.guozha.buyserver.web.controller.order.InsertPrepareOrderRequest;
import com.guozha.buyserver.web.controller.order.InsertSupplyOrderRequest;
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
	@Autowired
	private BuyCartMapper buyCartMapper;
	@Autowired
	private AccAddressMapper accAddressMapper;
	@Autowired
	private GooGoodsMapper gooGoodsMapper;
	@Autowired
	private MarMarketGoodsMapper marMarketGoodsMapper;
	@Autowired
	private MnuMenuMapper mnuMenuMapper;
	@Autowired
	private MnuMenuGoodsMapper mnuMenuGoodsMapper;
	@Autowired
	private BuyOrderChildMapper buyOrderChildMapper;
	@Autowired
	private SysSellerMapper sysSellerMapper;
	@Autowired
	private CommonService commonService;

	@Override
	public List<MarketTimeResponse> findMarketTime(int marketId) {
		return marMarketTimeMapper.findTimeByMarketId(marketId);
	}

	@Override
	public MsgResponse cancelOrder(CancelOrderRequest vo) {
		buyOrderMapper.updateStatus(vo.getOrderId(), vo.getOldStatus(), "00"); //ORDER_STATUS 00-取消
		return new MsgResponse(MsgResponse.SUCC, "订单取消成功");
	}
	
	public int getPageCount(int totalCount, int pageSize){
		return (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
	}

	@Override
	public SearchOrderResponse listOrder(SearchOrderRequest vo) {
		
		SearchOrderResponse response = new SearchOrderResponse();
		
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
		
		int totalCount = buyOrderMapper.findOrderCount(vo.getUserId(), statusList);
		
		List<BuyOrder> buyOrderList = buyOrderMapper.findOrder(vo.getUserId(), statusList, vo.getStartIndex(), vo.getPageSize());
		response.setBuyOrderList(buyOrderList);
		response.setTotalCount(totalCount);
		response.setPageCount(getPageCount(totalCount, vo.getPageSize()));
		return response;
	}
	
	/**
	 * 
	 * @param wantUpTime  [yymmddhhmm]
	 * @param wantDownTime [yymmddhhmm]
	 * @return 3月20 16点至17点
	 */
	private String getWantArrivalTimeScope(int wantUpTime, int wantDownTime) {
		// TODO
		return "";
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
		response.setAboutArrivalTime(buyOrder.getAboutArrivalTime());
		response.setWantArrivalTimeScope(getWantArrivalTimeScope(buyOrder.getWantUpTime(), buyOrder.getWantDownTime()));
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
	
	public int getServiceFeeForNormalOrder(int totalPrice){
		return totalPrice < Integer.parseInt(SystemResource.getConfig("service.free_price"))? Integer.parseInt(SystemResource.getConfig("service.fee")) : 0;
	}
	
	public Map<Integer, Integer> getMarketGoodsPriceMap(int marketId){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<MarMarketGoods> marMarketGoodsList = marMarketGoodsMapper.findByMarketId(marketId);
		for(MarMarketGoods marMarketGoods : marMarketGoodsList){
			map.put(marMarketGoods.getGoodsId(), marMarketGoods.getUnitPrice());
		}
		return map;
	}
	
	@Override
	public MsgResponse insertOrder(InsertOrderRequest vo) {
		
		List<BuyCart> buyCartList = buyCartMapper.findByUserId(vo.getUserId());
		AccAddress accAddress = accAddressMapper.load(vo.getAddressId());
		int marketId = commonService.getMaketId(accAddress.getAddressId());
		
		/**
		 * start：添加订单主信息
		 */
		BuyOrder buyOrder = new BuyOrder();
		buyOrder.setOrderNo(commonService.getPaperNo(SystemResource.getConfig("area_code.hangzhou"), "01"));// PAPER_TYPE 01-用户订单
		buyOrder.setOrderType("1");// ORDER_TYPE 1-普通订单
		buyOrder.setUserId(vo.getUserId());
		buyOrder.setQuantity(buyCartList.size()); //汇总件数
		buyOrder.setReceiveMen(accAddress.getReceiveName());
		buyOrder.setReceiveMobile(accAddress.getMobileNo());
		buyOrder.setReceiveAddr(accAddress.getDetailAddr());
		buyOrder.setWantUpTime(vo.getWantUpTime());
		buyOrder.setWantDownTime(vo.getWantDownTime());
		buyOrder.setMemo(vo.getMemo());
		buyOrder.setCreateTime(new Date());
		buyOrder.setStatus("01");// ORDER_STATUS 01-新创建
		
		buyOrderMapper.insert(buyOrder);
		/**
		 * end：添加订单主信息
		 */
		
		int totalPrice = 0;// 总金额
		Map<Integer, Integer> marketGoodsPriceMap = getMarketGoodsPriceMap(marketId);
		
		/**
		 * start：添加订单食材信息
		 */
		for(BuyCart buyCart : buyCartList) {
			
			if("01".equals(buyCart.getSplitType())) continue; //过滤掉菜谱  SPLIT_TYPE 01-菜谱  
			
			GooGoods gooGoods = gooGoodsMapper.load(buyCart.getGoodsOrMenuId());
			int unitPrice = marketGoodsPriceMap.get(gooGoods.getGoodsId());
			
			BuyOrderGoods buyOrderGoods = new BuyOrderGoods();
			buyOrderGoods.setOrderId(buyOrder.getOrderId());
			buyOrderGoods.setMarketId(marketId);
			buyOrderGoods.setGoodsId(gooGoods.getGoodsId());
			buyOrderGoods.setGoodsName(gooGoods.getGoodsName());
			buyOrderGoods.setGoodsImg(gooGoods.getGoodsImg());
			buyOrderGoods.setBackTypeId(gooGoods.getBackTypeId());
			buyOrderGoods.setUnit(gooGoods.getUnit());
			buyOrderGoods.setUnitPrice(unitPrice);
			buyOrderGoods.setAmount(buyCart.getAmount());
			buyOrderGoods.setPrice(unitPrice * buyCart.getAmount());
			
			buyOrderGoodsMapper.insert(buyOrderGoods);
			totalPrice += buyOrderGoods.getPrice();
		}
		/**
		 * end：添加订单食材信息
		 */
		
		/**
		 * start：添加订单菜谱信息
		 */
		for(BuyCart buyCart : buyCartList) {
			
			if("02".equals(buyCart.getSplitType())) continue; //过滤掉食材 SPLIT_TYPE 02-食材
			
			MnuMenu mnuMenu = mnuMenuMapper.load(buyCart.getGoodsOrMenuId());
			
			BuyOrderMenu buyOrderMenu = new BuyOrderMenu();
			buyOrderMenu.setOrderId(buyOrder.getOrderId());
			buyOrderMenu.setMarketId(marketId);
			buyOrderMenu.setMenuId(mnuMenu.getMenuId());
			buyOrderMenu.setMenuName(mnuMenu.getMenuName());
			buyOrderMenu.setMenuImg(mnuMenu.getMenuImg());
			int menuUnitPrice = commonService.getMenuUnitPrice(marketId, mnuMenu.getMenuId());
			buyOrderMenu.setUnitPrice(menuUnitPrice);
			buyOrderMenu.setAmount(buyCart.getAmount());
			buyOrderMenu.setPrice(menuUnitPrice*buyCart.getAmount());
			
			buyOrderMenuMapper.insert(buyOrderMenu);
			totalPrice += buyOrderMenu.getPrice();
			
			/**
			 * start：添加订单菜谱食材信息
			 */
			List<MenuGoodsInfo> menuGoodsInfoList = mnuMenuGoodsMapper.findMenuGoodsInfo(mnuMenu.getMenuId());
			
			for(MenuGoodsInfo menuGoodsInfo : menuGoodsInfoList){
				
				int goodsUnitPrice = marketGoodsPriceMap.get(menuGoodsInfo.getGoodsId());
				int amount = commonService.getMenuGoodsAmount(menuGoodsInfo.getGoodsId(), menuGoodsInfo.getAmount());
				
				BuyOrderMenuGoods orderMenuGoods = new BuyOrderMenuGoods();
				orderMenuGoods.setOrderId(buyOrder.getOrderId());
				orderMenuGoods.setOrderMenuId(buyOrderMenu.getOrderMenuId());
				orderMenuGoods.setMarketId(marketId);
				orderMenuGoods.setUnitPrice(goodsUnitPrice);
				orderMenuGoods.setAmount(menuGoodsInfo.getAmount());
				orderMenuGoods.setPrice(goodsUnitPrice * amount);
				orderMenuGoods.setGoodsId(menuGoodsInfo.getGoodsId());
				orderMenuGoods.setGoodsName(menuGoodsInfo.getGoodsName());
				orderMenuGoods.setGoodsImg(menuGoodsInfo.getGoodsImg());
				orderMenuGoods.setBackTypeId(menuGoodsInfo.getBackTypeId());
				orderMenuGoods.setUnit(menuGoodsInfo.getUnit());
				
				buyOrderMenuGoodsMapper.insert(orderMenuGoods);
			}
			/**
			 * end：添加订单菜谱食材信息
			 */
		}
		/**
		 * end：添加订单菜谱信息
		 */
		
		/**
		 * 更新订单信息
		 */
		buyOrderMapper.updateCount(buyOrder.getOrderId(), totalPrice, PriceUtils.getServiceFee(totalPrice));
		
		return new MsgResponse(MsgResponse.SUCC, "订单提交成功");
	}
	
	@Override
	public MsgResponse insertSupplyOrder(InsertSupplyOrderRequest vo) {
		
		MarMarketGoods marMarketGoods = marMarketGoodsMapper.load(vo.getMarketGoodsId());
		GooGoods gooGoods = gooGoodsMapper.load(marMarketGoods.getGoodsId());
		AccAddress accAddress = accAddressMapper.load(vo.getAddressId());
		
		BuyOrder buyOrder = new BuyOrder();
		buyOrder.setOrderNo(commonService.getPaperNo(SystemResource.getConfig("area_code.hangzhou"), "01"));// PAPER_TYPE 01-用户订单
		buyOrder.setOrderType("2"); // ORDER_TYPE 2-特供
		buyOrder.setUserId(vo.getUserId());
		buyOrder.setQuantity(1); //汇总件数
		buyOrder.setReceiveMen(accAddress.getReceiveName());
		buyOrder.setReceiveMobile(accAddress.getMobileNo());
		buyOrder.setReceiveAddr(accAddress.getDetailAddr());
		buyOrder.setWantUpTime(vo.getWantUpTime());
		buyOrder.setWantDownTime(vo.getWantDownTime());
		buyOrder.setMemo(vo.getMemo());
		buyOrder.setCreateTime(new Date());
		buyOrder.setTotalPrice(marMarketGoods.getUnitPrice() * vo.getAmount());
		buyOrder.setServiceFee(0);
		buyOrder.setStatus("01");// ORDER_STATUS 01-新创建
		
		buyOrderMapper.insert(buyOrder);
		
		BuyOrderGoods buyOrderGoods = new BuyOrderGoods();
		buyOrderGoods.setOrderId(buyOrder.getOrderId());
		buyOrderGoods.setMarketId(marMarketGoods.getMarketId());
		buyOrderGoods.setGoodsId(gooGoods.getGoodsId());
		buyOrderGoods.setGoodsName(gooGoods.getGoodsName());
		buyOrderGoods.setGoodsImg(gooGoods.getGoodsImg());
		buyOrderGoods.setBackTypeId(gooGoods.getBackTypeId());
		buyOrderGoods.setUnit(gooGoods.getUnit());
		buyOrderGoods.setUnitPrice(marMarketGoods.getUnitPrice());
		buyOrderGoods.setAmount(vo.getAmount());
		buyOrderGoods.setPrice(marMarketGoods.getUnitPrice() * vo.getAmount());
		
		buyOrderGoodsMapper.insert(buyOrderGoods);
		
		return new MsgResponse(MsgResponse.SUCC, "订单提交成功");
	}
	
	private Date getAboutArrivalTime(Date prepareEndDate, int arrivalDays){
		Date abouteArrivalTime = null;
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
			String nowDate = sf.format(prepareEndDate);
			Calendar cal = Calendar.getInstance();  
			cal.setTime(sf.parse(nowDate));  
			cal.add(Calendar.DAY_OF_YEAR, + arrivalDays);  
			String time = sf.format(cal.getTime());
			abouteArrivalTime = sf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return abouteArrivalTime;
	}
	
	@Override
	public MsgResponse insertPrepareOrder(InsertPrepareOrderRequest vo) {
		
		MarMarketGoods marMarketGoods = marMarketGoodsMapper.load(vo.getMarketGoodsId());
		GooGoods gooGoods = gooGoodsMapper.load(marMarketGoods.getGoodsId());
		AccAddress accAddress = accAddressMapper.load(vo.getAddressId());
		
		BuyOrder buyOrder = new BuyOrder();
		buyOrder.setOrderNo(commonService.getPaperNo(SystemResource.getConfig("area_code.hangzhou"), "01"));// PAPER_TYPE 01-用户订单
		buyOrder.setOrderType("3"); // ORDER_TYPE 3-预售
		buyOrder.setUserId(vo.getUserId());
		buyOrder.setQuantity(1); //汇总件数
		buyOrder.setReceiveMen(accAddress.getReceiveName());
		buyOrder.setReceiveMobile(accAddress.getMobileNo());
		buyOrder.setReceiveAddr(accAddress.getDetailAddr());
		buyOrder.setAboutArrivalTime(this.getAboutArrivalTime(gooGoods.getPrepareEndDate(), gooGoods.getArrivalDays()));
		buyOrder.setMemo(vo.getMemo());
		buyOrder.setCreateTime(new Date());
		buyOrder.setTotalPrice(marMarketGoods.getUnitPrice() * vo.getAmount());
		buyOrder.setServiceFee(0);
		buyOrder.setStatus("01");// ORDER_STATUS 01-新创建
		
		buyOrderMapper.insert(buyOrder);
		
		BuyOrderGoods buyOrderGoods = new BuyOrderGoods();
		buyOrderGoods.setOrderId(buyOrder.getOrderId());
		buyOrderGoods.setMarketId(marMarketGoods.getMarketId());
		buyOrderGoods.setGoodsId(gooGoods.getGoodsId());
		buyOrderGoods.setGoodsName(gooGoods.getGoodsName());
		buyOrderGoods.setGoodsImg(gooGoods.getGoodsImg());
		buyOrderGoods.setBackTypeId(gooGoods.getBackTypeId());
		buyOrderGoods.setUnit(gooGoods.getUnit());
		buyOrderGoods.setUnitPrice(marMarketGoods.getUnitPrice());
		buyOrderGoods.setAmount(vo.getAmount());
		buyOrderGoods.setPrice(marMarketGoods.getUnitPrice() * vo.getAmount());
		
		buyOrderGoodsMapper.insert(buyOrderGoods);
		
		return new MsgResponse(MsgResponse.SUCC, "订单提交成功");
	}

	@Override
	public void sendOrder(int orderId) {
		List<BuyOrderChild> buyOrderChildList = buyOrderChildMapper.findByOrder(orderId);
		
		for(BuyOrderChild buyOrderChild: buyOrderChildList){
			int marketId = buyOrderChild.getMarketId();
			int backTypeId = buyOrderChild.getBackTypeId();
			
			//查找本农贸市场中负责此种后台类目的卖家信息
			List<SysSeller> sysSellerList = sysSellerMapper.findForOrderSend(marketId, backTypeId);
			
			//唯独只有一家的情况下，系统自动帮后台人员做出卖方选择
			if(sysSellerList.size()==1){
				SysSeller sysSeller = sysSellerList.get(0);
				buyOrderChildMapper.updateBySend(buyOrderChild.getOrderChildId(), sysSeller.getSellerId(), sysSeller.getSellerId(), "03"); // ORDER_CHILD 03-已抢单
			}else{
				// 否则 no code，留给后台操作人员主动分配卖家
			}
			
		}
	}
	
}
