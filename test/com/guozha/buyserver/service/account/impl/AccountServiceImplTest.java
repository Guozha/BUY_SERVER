package com.guozha.buyserver.service.account.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.web.controller.MsgResponse;


public class AccountServiceImplTest extends BaseJunitCase {
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void testGetCheckCodeForReg(){
		String mobileNo = "15088668850";
		MsgResponse msgResponse = accountService.checkCodeForResetPasswd(mobileNo);
		assertNotNull("Response is null", msgResponse);
		assertEquals("Business failure", msgResponse.getReturnCode(), "1");
	}
	
	@Test
	public void register(){
		fail("Not implements yet");
	}
	
	@Test
	public void login(){
		fail("Not implements yet");
	}
	
	@Test
	public void logout(){
		fail("Not implements yet");
	}

}
