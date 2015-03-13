package com.guozha.buyserver.service.account.impl;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.ParameterUtil;
import com.guozha.buyserver.common.util.SmsUtil;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.persistence.mapper.UserMapper;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.web.controller.account.CheckCodeRequest;
import com.guozha.buyserver.web.controller.account.CheckCodeResponse;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.LoginResponse;
import com.guozha.buyserver.web.controller.account.LogoutRequest;
import com.guozha.buyserver.web.controller.account.LogoutResponse;
import com.guozha.buyserver.web.controller.account.RegisterRequest;
import com.guozha.buyserver.web.controller.account.RegisterResponse;

@Transactional(rollbackFor = Exception.class)
@Service("accountService")
public class AccountServiceImpl extends AbstractBusinessObjectServiceMgr implements AccountService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public CheckCodeResponse getCheckCodeForReg(CheckCodeRequest vo) {
		
		Object[] arr = new Object[1];
		arr[0] = RandomStringUtils.randomNumeric(6);
		SmsUtil.sendSms("01", vo.getMobileNo(), arr);// SMS_TYPE 01-注册获取验证码
		
		CheckCodeResponse bo = new CheckCodeResponse();
		bo.setReturnCode("1");
		
		return bo;
	}
	
	@Override
	public RegisterResponse register(RegisterRequest vo) {
		
		RegisterResponse bo = new RegisterResponse();
		
		String checkCode = SmsUtil.getCheckCode(vo.getMobileNo());//获取服务端缓存的验证码
		if(!(vo.getCheckCode().equals(checkCode))){
			bo.setReturnCode("0");
			bo.setMsg("验证码错误");
		}
		
		SysUser sysUser = userMapper.getUserByMobileNo(vo.getMobileNo());
		if(sysUser == null){
			
			sysUser = new SysUser();
			sysUser.setMobileNo(vo.getMobileNo());
			sysUser.setPasswd(vo.getPasswd());
			sysUser.setRegTime(new Date());
			sysUser.setStatus("1");// USER_STATUS 1-可用
			userMapper.insert(sysUser);
			
			SmsUtil.removeCheckCode(vo.getMobileNo());
			
			bo.setReturnCode("1");
			bo.setMsg("注册成功");
		}else{
			bo.setReturnCode("0");
			bo.setMsg("该手机已经注册过了");
		}
		
		return bo;
		
	}
	
	@Override
	public LoginResponse login(LoginRequest vo) {
		
		LoginResponse bo = new LoginResponse();
		
		SysUser sysUser = userMapper.getLoginUser(vo);
		if(sysUser == null){
			bo.setReturnCode("0");
			bo.setMsg("用户名或密码错误");
		}else{
			if("3".equals(sysUser.getStatus())){// USER_STATUS 3-停用
				bo.setMobileNo(vo.getMobileNo());
				bo.setReturnCode("0");
				bo.setMsg("该账户已被停用");
			}else{
				String token = RandomStringUtils.randomAlphanumeric(32);
				
				bo.setToken(token);
				bo.setUserId(sysUser.getUserId());
				bo.setMobileNo(vo.getMobileNo());
				bo.setReturnCode("1");
				bo.setMsg("登录成功");
				
			}
			
		}
		
		return bo;
	}

	@Override
	public LogoutResponse logout(LogoutRequest vo) {
		
		LogoutResponse bo = new LogoutResponse();
		
		ParameterUtil.removeToken(vo.getToken());
		
		bo.setReturnCode("1");
		return bo;
	}

}
