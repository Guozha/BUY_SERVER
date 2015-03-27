package com.guozha.buyserver.service.account.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guozha.buyserver.common.util.SmsUtil;
import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.LoginResponse;
import com.guozha.buyserver.web.controller.account.RegisterRequest;


public class AccountServiceImplTest extends BaseJunitCase {
	
	@Autowired
	private AccountService accountService;
	
	@Test
	@Ignore
	public void testGetCheckCodeForReg(){
		String mobileNo = "15088668850";
		MsgResponse msgResponse = accountService.checkCodeForResetPasswd(mobileNo);
		assertNotNull("Response is null", msgResponse);
		assertEquals("Business failure", msgResponse.getReturnCode(), "1");
	}
	
	@Test
	public void testRegisterCheckCodeWrong(){
		RegisterRequest vo = new RegisterRequest();
		vo.setMobileNo("15088668850");
		vo.setPasswd("000000");
		vo.setCheckCode(RandomStringUtils.randomNumeric(6));
		
		MsgResponse msgResponse = accountService.register(vo);
		assertNotNull("Response is null", msgResponse);
		assertEquals("The checkCode should be wrong", msgResponse.getReturnCode(), "0");
	}
	
	@Test
	@Ignore
	public void testRegisterMobileIsExist(){
		RegisterRequest vo = new RegisterRequest();
		vo.setMobileNo("15088668850");
		vo.setPasswd("000000");
		vo.setCheckCode(SmsUtil.getCheckCode(vo.getMobileNo()));
		
		SysUser sysUser = accountService.getUserByMobileNo(vo.getMobileNo());
		if(sysUser != null){
			MsgResponse msgResponse = accountService.register(vo);
			assertNotNull("Response is null", msgResponse);
			assertEquals("MobileNo had register yet", msgResponse.getReturnCode(), "0");
		}
		
	}
	
	@Test
	public void testRegisterSuccess(){
		RegisterRequest vo = new RegisterRequest();
		vo.setMobileNo("15088668850");
		vo.setPasswd("000000");
		vo.setCheckCode(SmsUtil.getCheckCode(vo.getMobileNo()));
		
		SysUser sysUser = accountService.getUserByMobileNo(vo.getMobileNo());
		if(sysUser == null){
			MsgResponse msgResponse = accountService.register(vo);
			assertNotNull("Response is null", msgResponse);
			assertEquals("Register is not success", msgResponse.getReturnCode(), "1");
		}
	}
	
	@Test
	public void testLoginInputWrong(){
		LoginRequest vo = new LoginRequest();
		vo.setMobileNo("15088668850");
		vo.setPasswd(RandomStringUtils.randomNumeric(6));
		
		LoginResponse loginResponse = accountService.login(vo);
		assertNotNull("Response is null", loginResponse);
		assertEquals("MobileNo or passwd should be wrong", loginResponse.getReturnCode(), "0");
	}
	
	@Test
	public void testLoginAccountStop(){
		
		SysUser sysUser = accountService.getUserByMobileNo("15088668851");
		
		LoginRequest vo = new LoginRequest();
		vo.setMobileNo(sysUser.getMobileNo());
		vo.setPasswd(sysUser.getPasswd());
		
		LoginResponse response = accountService.login(vo);
		assertNotNull("Response is null", response);
		assertEquals("Account should be invalible", response.getReturnCode(), "0");
		
	}
	
	@Test
	public void testLoginSuccess(){
		SysUser sysUser = accountService.getUserByMobileNo("15088668850");
		
		LoginRequest vo = new LoginRequest();
		vo.setMobileNo(sysUser.getMobileNo());
		vo.setPasswd(sysUser.getPasswd());
		
		LoginResponse response = accountService.login(vo);
		assertNotNull("Response is null", response);
		assertEquals("Login failure", response.getReturnCode(), "1");
	}
	
	@Test
	public void testLogout(){
		String token = RandomStringUtils.randomAlphanumeric(32);
		MsgResponse response = accountService.logout(token);
		
		assertNotNull("Response is null", response);
		assertEquals("Logout failure", response.getReturnCode(), "1");
	}

}
