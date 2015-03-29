package com.guozha.buyserver.service.account.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.verify;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.SmsUtil;
import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.persistence.mapper.SysUserMapper;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.LoginResponse;
import com.guozha.buyserver.web.controller.account.RegisterRequest;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
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
	public void testRegisterMobileIsExist(){
		
		RegisterRequest vo = new RegisterRequest();
		vo.setMobileNo("15088668855");
		vo.setPasswd("000000");
		String checkCode = RandomStringUtils.randomNumeric(6);
		SmsUtil.cacheCheckCode(vo.getMobileNo(), checkCode);
		vo.setCheckCode(checkCode);
		accountService.register(vo);
		
		RegisterRequest vo2 = new RegisterRequest();
		vo2.setMobileNo(vo.getMobileNo());
		vo2.setPasswd(vo.getPasswd());
		vo2.setCheckCode(vo.getCheckCode());
		
		MsgResponse msgResponse = accountService.register(vo2);
		assertNotNull("Response is null", msgResponse);
		assertEquals("Mobile number registerd yet", msgResponse.getReturnCode(), "0");
		
	}
	
	@Test
	public void testRegisterSuccess(){
		RegisterRequest vo = new RegisterRequest();
		vo.setMobileNo("15088668855");
		vo.setPasswd("000000");
		SmsUtil.cacheCheckCode(vo.getMobileNo(), RandomStringUtils.randomNumeric(6));
		vo.setCheckCode(SmsUtil.getCheckCode(vo.getMobileNo()));
		
		MsgResponse msgResponse = accountService.register(vo);
		assertNotNull("Response is null", msgResponse);
		assertEquals("Register is not success", msgResponse.getReturnCode(), "1");
	}
	
	@Test
	public void testLoginInputWrong(){
		LoginRequest vo = new LoginRequest();
		vo.setMobileNo(RandomStringUtils.randomNumeric(11));
		vo.setPasswd(RandomStringUtils.randomNumeric(6));
		
		LoginResponse loginResponse = accountService.login(vo);
		assertNotNull("Response is null", loginResponse);
		assertEquals("MobileNo or passwd should be wrong", loginResponse.getReturnCode(), "0");
	}
	
	@Test
	public void testLoginAccountStop(){
		
		// 创建一个mock来模拟目标对类
		SysUserMapper mockSysUserMapper = createMock("mockSysUserMapper", SysUserMapper.class);
		
		SysUser sysUser = new SysUser();
		sysUser.setStatus("3");
		
		LoginRequest vo = new LoginRequest();
		vo.setMobileNo(sysUser.getMobileNo());
		
		// 开始声明预期
		expect(mockSysUserMapper.getLoginUser(vo)).andReturn(sysUser);
		
		// 声明mock
		replay(mockSysUserMapper);
		
		// 记录被mock的原始对象现场
		SysUserMapper oriSysUserMapper = accountService.getSysUserMapper();
		// 用mock接替目标类
		accountService.setSysUserMapper(mockSysUserMapper);
		
		// 调用业务逻辑
		LoginResponse response = accountService.login(vo);
		
		// 断言
		assertNotNull("Response is null", response);
		assertEquals("Account should be invalible", response.getReturnCode(), "0");
		
		// 验证声明的方法调用预期被触发了
		verify(mockSysUserMapper);
		
		// 恢复现场,以便其他测试方法不受此次mock影响
		accountService.setSysUserMapper(oriSysUserMapper);
		
	}
	
	@Test
	public void testLoginSuccess(){
		
		RegisterRequest vo = new RegisterRequest();
		vo.setMobileNo("15088668855");
		vo.setPasswd("000000");
		String checkCode = RandomStringUtils.randomNumeric(6);
		SmsUtil.cacheCheckCode(vo.getMobileNo(), checkCode);
		vo.setCheckCode(checkCode);
		accountService.register(vo);
		
		LoginRequest vo2 = new LoginRequest();
		vo2.setMobileNo(vo.getMobileNo());
		vo2.setPasswd(vo.getPasswd());
		
		LoginResponse response = accountService.login(vo2);
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
