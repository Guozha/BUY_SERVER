package com.guozha.buyserver.service.account.impl;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.service.account.MyFavoService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.AdjustFavoRequest;
import com.guozha.buyserver.web.controller.account.DeleteFavoRequest;
import com.guozha.buyserver.web.controller.account.FavoGoodsRequest;
import com.guozha.buyserver.web.controller.account.FavoMenuRequest;
import com.guozha.buyserver.web.controller.account.InsertDirRequest;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.LoginResponse;
import com.guozha.buyserver.web.controller.account.SearchDirResponse;
import com.guozha.buyserver.web.controller.account.SearchGoodsFavoRequest;
import com.guozha.buyserver.web.controller.account.SearchGoodsFavoResponse;
import com.guozha.buyserver.web.controller.account.SearchMenuFavoResponse;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class MyFavoServiceImplTest extends BaseJunitCase {
	
	@Autowired
	private MyFavoService myFavoService;
	@Autowired
	private AccountService accountService;
	private String token;
	private Integer userId;
	private String mobileNo;
	
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
	
	@Test
	public void testFavoGoods(){
		
		// 创建一个mock来模拟目标对类
		GooGoodsMapper mockGooGoodsMapper = createMock("mockGooGoodsMapper", GooGoodsMapper.class);
		int goodsId = Integer.parseInt(RandomStringUtils.randomNumeric(9));
		GooGoods gooGoods = new GooGoods();
		gooGoods.setGoodsName("番茄");
		
		// 开始声明预期
		expect(mockGooGoodsMapper.load(goodsId)).andReturn(gooGoods);
		
		// 声明mock
		replay(mockGooGoodsMapper);
		
		// 记录被mock的原始对象现场
		GooGoodsMapper gooGoodsMapper = myFavoService.getGooGoodsMapper();
		// 用mock接替目标类
		myFavoService.setGooGoodsMapper(mockGooGoodsMapper);
		
		FavoGoodsRequest vo = new FavoGoodsRequest();
		vo.setUserId(userId);
		vo.setGoodsId(goodsId);
		
		MsgResponse response = myFavoService.favoGoods(vo);
		
		assertNotNull("Response should not be null", response);
		assertEquals("Favorite goods failure", response.getReturnCode(), "1");
		
		// 验证声明的方法调用预期被触发了
		verify(mockGooGoodsMapper);
		
		// 恢复现场,以便其他测试方法不受此次mock影响
		myFavoService.setGooGoodsMapper(gooGoodsMapper);
	}
	
	@Test
	public void testFavoMenu(){
		
		// 创建一个mock来模拟目标对类
		MnuMenuMapper mockMnuMenuMapper = createMock("mnuMenuMapper", MnuMenuMapper.class);
		int menuId = Integer.parseInt(RandomStringUtils.randomNumeric(9));
		MnuMenu mnuMenu = new MnuMenu();
		mnuMenu.setMenuName("番茄炒蛋");
		
		int menuId2 = Integer.parseInt(RandomStringUtils.randomNumeric(9));
		MnuMenu mnuMenu2 = new MnuMenu();
		mnuMenu2.setMenuName("金针菇肉丝");
		
		// 开始声明预期
		expect(mockMnuMenuMapper.load(menuId)).andReturn(mnuMenu);
		expect(mockMnuMenuMapper.load(menuId2)).andReturn(mnuMenu2);
		
		// 声明mock
		replay(mockMnuMenuMapper);
		
		// 记录被mock的原始对象现场
		MnuMenuMapper mnuMenuMapper = myFavoService.getMnuMenuMapper();
		// 用mock接替目标类
		myFavoService.setMnuMenuMapper(mockMnuMenuMapper);
		
		FavoMenuRequest vo = new FavoMenuRequest();
		vo.setUserId(userId);
		String menuIds = menuId + "," + menuId2;
		vo.setMenuIds(menuIds);
		
		MsgResponse response = myFavoService.favoMenu(vo);
		
		assertNotNull("Response should not be null", response);
		assertEquals("Favorite goods failure", response.getReturnCode(), "1");
		
		// 验证声明的方法调用预期被触发了
		verify(mockMnuMenuMapper);
		
		// 恢复现场,以便其他测试方法不受此次mock影响
		myFavoService.setMnuMenuMapper(mnuMenuMapper);
	}
	
	@Test
	public void testFindGoodsFavo(){
		SearchGoodsFavoRequest vo = new SearchGoodsFavoRequest();
		vo.setUserId(userId);
		vo.setMarketId(Integer.parseInt(RandomStringUtils.randomNumeric(9)));
		
		List<SearchGoodsFavoResponse> response = myFavoService.findGoodsFavo(vo);
		assertNotNull("Response should not be null", response);
	}
	
	@Test
	public void testFindMenuFavo(){
		List<SearchMenuFavoResponse> response = myFavoService.findMenuFavo(userId);
		assertNotNull("Response should not be null", response);
	}
	
	@Test
	public void testInsertDir(){
		InsertDirRequest vo = new InsertDirRequest();
		vo.setUserId(userId);
		vo.setFavoName("我爱吃的");
		
		MsgResponse response = myFavoService.insertDir(vo);
		assertNotNull("Response should not be null", response);
		assertEquals("insert dir failure", response.getReturnCode(), "1");
	}
	
	@Test
	public void testFindDir(){
		List<SearchDirResponse> response = myFavoService.findDir(userId);
		assertNotNull("Response should not be null", response);
	}
	
	@Test
	public void testAdjustFavo(){
		AdjustFavoRequest vo = new AdjustFavoRequest();
		vo.setMyFavoId(new Random().nextInt(100000000));
		vo.setParentId(new Random().nextInt(100000000));
		MsgResponse response = myFavoService.adjustFavo(vo);
		assertNotNull("Response should not be null", response);
		assertEquals("adjust favorite failure", response.getReturnCode(), "1");
	}
	
	@Test
	public void testDeleteFavoIsMenu(){
		DeleteFavoRequest vo = new DeleteFavoRequest();
		vo.setMyFavoId(new Random().nextInt(100000000));
		vo.setDirFlag("0"); // 0-非文件夹  即菜谱
		MsgResponse response = myFavoService.deleteFavo(vo);
		assertNotNull("Response should not be null", response);
		assertEquals("delete favorite failure", response.getReturnCode(), "1");
	}
	
	@Test
	public void testDeleteFavoIsDir(){
		DeleteFavoRequest vo = new DeleteFavoRequest();
		vo.setMyFavoId(new Random().nextInt(100000000));
		vo.setDirFlag("1"); // 1-文件夹 
		MsgResponse response = myFavoService.deleteFavo(vo);
		assertNotNull("Response should not be null", response);
		assertEquals("delete favorite failure", response.getReturnCode(), "1");
	}
	
	@Test
	public void testFindMenuByDir(){
		List<SearchMenuFavoResponse> response = myFavoService.findMenuByDir(new Random().nextInt(100000000));
		assertNotNull("Response should not be null", response);
	}
	
}
