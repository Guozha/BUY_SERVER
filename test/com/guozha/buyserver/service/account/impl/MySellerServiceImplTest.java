package com.guozha.buyserver.service.account.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.service.account.MySellerService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.InsertMySellerRequest;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.LoginResponse;
import com.guozha.buyserver.web.controller.account.SearchMySellerResponse;
import com.guozha.buyserver.web.controller.account.UpdateMySellerRequest;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class MySellerServiceImplTest extends BaseJunitCase {
	
	@Autowired
	private MySellerService mySellerService;
	
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
	public void testFindMySeller(){
		
		List<SearchMySellerResponse> response = mySellerService.findMySeller(userId);
		
		assertNotNull("Response should not be null", response);
	}
	
	@Test
	public void testUpdateMySeller(){
		
		UpdateMySellerRequest vo = new UpdateMySellerRequest();
		vo.setMySellerId(Integer.parseInt(RandomStringUtils.randomNumeric(9)));
		vo.setSellerTag("1"); //SELLER_TAG 1-首选
		
		MsgResponse response = mySellerService.updateMySeller(vo);
		
		assertNotNull("Response should not be null", response);
		assertEquals("Update sellerTag failure", response.getReturnCode(), "1");
	}
	
	@Test
	public void testInsertMySeller(){
		
		InsertMySellerRequest vo = new InsertMySellerRequest();
		vo.setUserId(userId);
		vo.setSellerId(Integer.parseInt(RandomStringUtils.randomNumeric(9)));
		
		MsgResponse response = mySellerService.insertMySeller(vo);
		
		assertNotNull("Response should not be null", response);
		assertEquals("Insert my seller failure", response.getReturnCode(), "1");
	}
	
}
