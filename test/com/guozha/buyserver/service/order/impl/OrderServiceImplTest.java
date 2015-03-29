package com.guozha.buyserver.service.order.impl;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.SystemResource;
import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.persistence.beans.AccAddress;
import com.guozha.buyserver.persistence.beans.BuyCart;
import com.guozha.buyserver.persistence.beans.BuyOrder;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.MarMarketGoods;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.persistence.mapper.AccAddressMapper;
import com.guozha.buyserver.persistence.mapper.BuyCartMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.account.AccAddressService;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.service.common.CommonService;
import com.guozha.buyserver.service.common.MenuUnitPriceBo;
import com.guozha.buyserver.service.order.OrderService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.AddressRequest;
import com.guozha.buyserver.web.controller.account.AddressResponse;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.LoginResponse;
import com.guozha.buyserver.web.controller.order.CancelOrderRequest;
import com.guozha.buyserver.web.controller.order.InsertOrderRequest;
import com.guozha.buyserver.web.controller.order.MarketTimeResponse;
import com.guozha.buyserver.web.controller.order.OrderDetailResponse;
import com.guozha.buyserver.web.controller.order.SearchOrderRequest;
import com.guozha.buyserver.web.controller.order.SearchOrderResponse;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class OrderServiceImplTest extends BaseJunitCase {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccAddressService accAddressService;
	private AccAddressMapper accAddressMapper;
	private CommonService commonService;
	
	private String token;
	private Integer userId;
	private String mobileNo;
	private Integer addressId;
	
	@Before
	public void before(){
		
		SysUser sysUser = accountService.getUserByMobileNo("15088668850");
		
		LoginRequest vo = new LoginRequest();
		vo.setMobileNo(sysUser.getMobileNo());
		vo.setPasswd(sysUser.getPasswd());
		
		LoginResponse loginResponse = accountService.login(vo);
		token = loginResponse.getToken();
		userId = loginResponse.getUserId();
		mobileNo = loginResponse.getMobileNo();
		
	}
	
	protected void insertAddress(){
		
		AddressRequest addressRequest = new AddressRequest();
		addressRequest.setUserId(userId);
		addressRequest.setReceiveName("朱田祥");
		addressRequest.setMobileNo("15088668850");
		addressRequest.setProvinceId(1);
		addressRequest.setCityId(2);
		addressRequest.setCountyId(3);
		addressRequest.setBuildingId(1);
		addressRequest.setBuildingName("金地自在城");
		addressRequest.setDetailAddr("41幢2302");
		addressRequest.setDefaultFlag("1");
		
		accAddressService.insert(addressRequest);
		
		AddressRequest p = new AddressRequest();
		p.setUserId(userId);
		List<AddressResponse> pos = accAddressService.list(p);
		for(AddressResponse po : pos){
			if(!"1".equals(po.getDefaultFlag())) continue;
			addressId = po.getAddressId();
			break;
		}
	}
	
	@Test
	public void testFindMarketTime(){
		int marketId = Integer.parseInt(RandomStringUtils.randomNumeric(9));
		List<MarketTimeResponse> response = orderService.findMarketTime(marketId);
		assertNotNull("Response should not be null", response);
	}
	
	@Test
	public void testCancelOrder(){
		CancelOrderRequest vo = new CancelOrderRequest();
		int orderId = Integer.parseInt(RandomStringUtils.randomNumeric(9));
		vo.setOrderId(orderId);
		vo.setOldStatus("01"); //ORDER_STATUS 01-新创建
		MsgResponse response = orderService.cancelOrder(vo);
		assertNotNull("Response should not be null", response);
		assertEquals("Cancel order failure", response.getReturnCode(), "1");
	}
	
	@Test
	public void testListOrderInDo(){
		SearchOrderRequest vo = new SearchOrderRequest();
		vo.setPageNum(1);
		vo.setPageSize(20);
		vo.setUserId(userId);
		vo.setSearchType("1");// ORDER_SEARCH_TYPE 1-进行中
		SearchOrderResponse response = orderService.listOrder(vo);
		assertNotNull("Response should not be null", response);
	}
	
	@Test
	public void testListOrderFinished(){
		SearchOrderRequest vo = new SearchOrderRequest();
		vo.setPageNum(1);
		vo.setPageSize(20);
		vo.setUserId(userId);
		vo.setSearchType("2");// ORDER_SEARCH_TYPE 2-已完成
		SearchOrderResponse response = orderService.listOrder(vo);
		assertNotNull("Response should not be null", response);
	}
	
	@Test
	public void testInsertOrder(){
		
		/**
		 * -------------------------start:Mock object-----------------------------
		 */
		BuyCartMapper mockBuyCartMapper = createMock("mockBuyCartMapper", BuyCartMapper.class);
		List<BuyCart> buyCartList = new ArrayList<BuyCart>();
		
		int goodsId1 = 1;
		int goodsId2 = 2;
		int menuId1 = 1;
		int goodsAmount1 = 300;
		int goodsAmount2 = 300;
		BuyCart buyCart = new BuyCart();
		buyCart.setSplitType("01"); //SPLIT_TYPE 01-菜谱
		buyCart.setGoodsOrMenuId(menuId1);
		buyCart.setAmount(2);
		buyCartList.add(buyCart);
		
		buyCart = new BuyCart();
		buyCart.setSplitType("02"); //SPLIT_TYPE 02-食材
		buyCart.setGoodsOrMenuId(goodsId1);
		buyCart.setAmount(500);
		buyCartList.add(buyCart);
		
		buyCart = new BuyCart();
		buyCart.setSplitType("02"); //SPLIT_TYPE 02-食材
		buyCart.setGoodsOrMenuId(goodsId2);
		buyCart.setAmount(500);
		buyCartList.add(buyCart);
		
		expect(mockBuyCartMapper.findByUserId(userId)).andReturn(buyCartList);
		replay(mockBuyCartMapper);
		BuyCartMapper buyCartMapper = orderService.getBuyCartMapper();
		orderService.setBuyCartMapper(mockBuyCartMapper);
		
		AccAddressMapper mockAccAddressMapper = createMock("mockAccAddressMapper", AccAddressMapper.class);
		
		int addressId = 1;
		AccAddress accAddress = new AccAddress();
		accAddress.setAddressId(addressId);
		accAddress.setReceiveName("朱田祥");
		accAddress.setMobileNo(mobileNo);
		accAddress.setDetailAddr("41幢2302");
		
		expect(mockAccAddressMapper.load(addressId)).andReturn(accAddress);
		replay(mockAccAddressMapper);
		AccAddressMapper accAddressMapper = orderService.getAccAddressMapper();
		orderService.setAccAddressMapper(mockAccAddressMapper);
		
		CommonService mockCommonService = createMock("mockCommonService", CommonService.class);
		int marketId = 1;
		expect(mockCommonService.getMaketId(addressId)).andReturn(marketId);
		expect(mockCommonService.getPaperNo(SystemResource.getConfig("area_code.hangzhou"), "01")).andReturn(RandomStringUtils.randomNumeric(10));
		MenuUnitPriceBo priceBo = new MenuUnitPriceBo();
		priceBo.setStatus("1");
		priceBo.setUnitPrice(1500);
		expect(mockCommonService.getMenuUnitPrice(marketId, menuId1)).andReturn(priceBo);
		expect(mockCommonService.getMenuGoodsAmount(goodsId1, goodsAmount1, "01")).andReturn(400);
		expect(mockCommonService.getMenuGoodsAmount(goodsId2, goodsAmount2, "01")).andReturn(500);
		replay(mockCommonService);
		CommonService commonService = orderService.getCommonService();
		orderService.setCommonService(mockCommonService);
		
		MarMarketGoodsMapper mockMarMarketGoodsMapper = createMock("mockMarMarketGoodsMapper", MarMarketGoodsMapper.class);
		List<MarMarketGoods> marMarketGoodsList = new ArrayList<MarMarketGoods>();
		MarMarketGoods marMarketGoods = new MarMarketGoods();
		marMarketGoods.setGoodsId(goodsId1);
		marMarketGoods.setUnitPrice(500);
		marMarketGoodsList.add(marMarketGoods);
		marMarketGoods = new MarMarketGoods();
		marMarketGoods.setGoodsId(goodsId2);
		marMarketGoods.setUnitPrice(500);
		marMarketGoodsList.add(marMarketGoods);
		
		expect(mockMarMarketGoodsMapper.findByMarketId(marketId)).andReturn(marMarketGoodsList);
		replay(mockMarMarketGoodsMapper);
		MarMarketGoodsMapper marMarketGoodsMapper = orderService.getMarMarketGoodsMapper();
		orderService.setMarMarketGoodsMapper(mockMarMarketGoodsMapper);
		
		GooGoodsMapper mockGooGoodsMapper = createMock("mockGooGoodsMapper", GooGoodsMapper.class);
		GooGoods gooGoods = new GooGoods();
		gooGoods.setGoodsId(goodsId1);
		gooGoods.setGoodsName("西红柿");
		gooGoods.setGoodsImg(null);
		gooGoods.setBackTypeId(1);
		gooGoods.setUnit("01"); //UNIT 01-500克
		expect(mockGooGoodsMapper.load(1)).andReturn(gooGoods);
		gooGoods = new GooGoods();
		gooGoods.setGoodsId(goodsId2);
		gooGoods.setGoodsName("普通鸡蛋");
		gooGoods.setGoodsImg(null);
		gooGoods.setBackTypeId(2);
		gooGoods.setUnit("01"); //UNIT 01-500克
		expect(mockGooGoodsMapper.load(2)).andReturn(gooGoods);
		replay(mockGooGoodsMapper);
		GooGoodsMapper gooGoodsMapper = orderService.getGooGoodsMapper();
		orderService.setGooGoodsMapper(mockGooGoodsMapper);
		
		MnuMenuMapper mockMnuMenuMapper = createMock("mockMnuMenuMapper", MnuMenuMapper.class);
		MnuMenu mnuMenu = new MnuMenu();
		mnuMenu.setMenuId(menuId1);
		mnuMenu.setMenuName("西红柿炒蛋");
		mnuMenu.setMenuImg(null);
		expect(mockMnuMenuMapper.load(menuId1)).andReturn(mnuMenu);
		replay(mockMnuMenuMapper);
		MnuMenuMapper mnuMenuMapper = orderService.getMnuMenuMapper();
		orderService.setMnuMenuMapper(mockMnuMenuMapper);
		
		MnuMenuGoodsMapper mockMnuMenuGoodsMapper = createMock("mockMnuMenuGoodsMapper", MnuMenuGoodsMapper.class);
		List<MenuGoodsInfo> menuGoodsInfoList = new ArrayList<MenuGoodsInfo>();
		MenuGoodsInfo menuGoodsInfo = new MenuGoodsInfo();
		menuGoodsInfo.setGoodsId(goodsId1);
		menuGoodsInfo.setGoodsName("西红柿");
		menuGoodsInfo.setGoodsImg(null);
		menuGoodsInfo.setBackTypeId(1);
		menuGoodsInfo.setUnit("01"); //UNIT 01-500克
		menuGoodsInfo.setAmount(goodsAmount1);
		menuGoodsInfoList.add(menuGoodsInfo);
		
		menuGoodsInfo = new MenuGoodsInfo();
		menuGoodsInfo.setGoodsId(goodsId2);
		menuGoodsInfo.setGoodsName("普通鸡蛋");
		menuGoodsInfo.setGoodsImg(null);
		menuGoodsInfo.setBackTypeId(2);
		menuGoodsInfo.setUnit("01"); //UNIT 01-500克
		menuGoodsInfo.setAmount(goodsAmount2);
		menuGoodsInfoList.add(menuGoodsInfo);
		expect(mockMnuMenuGoodsMapper.findMenuGoodsInfo(menuId1)).andReturn(menuGoodsInfoList);
		replay(mockMnuMenuGoodsMapper);
		MnuMenuGoodsMapper mnuMenuGoodsMapper = orderService.getMnuMenuGoodsMapper();
		orderService.setMnuMenuGoodsMapper(mockMnuMenuGoodsMapper);
		
		
		/**
		 * -------------------------end:Mock object-----------------------------
		 */
		
		
		/**
		 * -------------------------start:常规代码-----------------------------
		 */
		InsertOrderRequest vo = new InsertOrderRequest();
		vo.setUserId(userId);
		vo.setAddressId(addressId);
		vo.setWantUpTime(1503201530);
		vo.setWantDownTime(1503201630);
		vo.setMemo("尽快送达");
		MsgResponse response = orderService.insertOrder(vo);
		assertNotNull("Response should not be null", response);
		assertEquals("insert order failure", response.getReturnCode(), "1");
		/**
		 * -------------------------end:常规代码-----------------------------
		 */
		
		/**
		 * -------------------------start:验证并恢复现场-----------------------------
		 */
		// 验证声明的方法调用预期被触发了
		verify(mockAccAddressMapper);
		
		// 恢复现场,以便其他的测试方法恢复使用原始对象影响
		orderService.setAccAddressMapper(accAddressMapper);
		orderService.setCommonService(commonService);
		orderService.setBuyCartMapper(buyCartMapper);
		orderService.setMarMarketGoodsMapper(marMarketGoodsMapper);
		orderService.setGooGoodsMapper(gooGoodsMapper);
		orderService.setMnuMenuMapper(mnuMenuMapper);
		orderService.setMnuMenuGoodsMapper(mnuMenuGoodsMapper);
		/**
		 * -------------------------end:验证并恢复现场-----------------------------
		 */
	}
	
	@Test
	public void testInsertSupplyOrder(){
		fail("Not implements yet");
	}
	
	@Test
	public void testInsertPrepareOrder(){
		fail("Not implements yet");
	}
	
	@Test
	public void testGetOrderDetail(){
		testInsertOrder();
		
		SearchOrderRequest vo = new SearchOrderRequest();
		vo.setPageNum(1);
		vo.setPageSize(20);
		vo.setUserId(userId);
		vo.setSearchType("1");// ORDER_SEARCH_TYPE 1-进行中
		SearchOrderResponse searchOrderResponse = orderService.listOrder(vo);
		List<BuyOrder> buyOrderList = searchOrderResponse.getBuyOrderList();
		BuyOrder buyOrder = buyOrderList.get(buyOrderList.size()-1);
		OrderDetailResponse response = orderService.getOrderDetail(buyOrder.getOrderId());
		assertNotNull("Response should not be null", response);
	}
	
	@Test
	public void sendOrder(){
		fail("Not implements yet");
	}

}
