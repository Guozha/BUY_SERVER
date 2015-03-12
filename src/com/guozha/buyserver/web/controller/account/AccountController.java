package com.guozha.buyserver.web.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.common.util.ParameterUtil;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.service.account.User;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/account")
public class AccountController extends BaseController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/reg")
	public void doReg(RegisterRequest vo, HttpServletResponse response) {
		
		RegisterResponse bo = new RegisterResponse();
		
		String checkCode = ParameterUtil.getCheckCode(vo.getMobileNo());//获取服务端缓存的验证码
		if(!(vo.getCheckCode().equals(checkCode))){
			bo.setMobileNo(vo.getMobileNo());
			bo.setReturnCode("0");
			bo.setMsg("验证码错误");
			this.responseJson(bo, response);
		}
		
		User user = accountService.getRegUser(vo.getMobileNo());
		if(user.getSysUser()==null){
			accountService.register(vo);
			
			ParameterUtil.removeCheckCode(vo.getMobileNo());
			
			bo.setMobileNo(vo.getMobileNo());
			bo.setReturnCode("1");
			bo.setMsg("注册成功");
			this.responseJson(bo, response);
		}else{
			bo.setMobileNo(vo.getMobileNo());
			bo.setReturnCode("0");
			bo.setMsg("该手机已经注册过了");
			this.responseJson(bo, response);
		}
		
	}
	
	@RequestMapping(value="/login")
	public void getRegCheckCode(LoginRequest vo, HttpServletRequest request, HttpServletResponse response) {
		
		LoginResponse bo = new LoginResponse();
		
		User user = accountService.getLoginUser(vo);
		if(user.getSysUser()==null){
			bo.setReturnCode("0");
			bo.setMsg("用户名或密码错误");
		}else{
			if("3".equals(user.getStatus())){// USER_STATUS 3-停用
				bo.setMobileNo(vo.getMobileNo());
				bo.setReturnCode("0");
				bo.setMsg("该账户已被停用");
			}else{
				String token = RandomStringUtils.randomAlphanumeric(32);
				
				bo.setToken(token);
				bo.setUserId(user.getUserId());
				bo.setMobileNo(vo.getMobileNo());
				bo.setReturnCode("1");
				bo.setMsg("登录成功");
				
			}
			
		}
		
		this.responseJson(bo, response);
	}
	
	@RequestMapping(value="/logout")
	public void logout(LogoutRequest vo, HttpServletResponse response) {
		
		ParameterUtil.removeToken(vo.getToken());
		
		LogoutResponse bo = new LogoutResponse();
		
		bo.setReturnCode("1");
		this.responseJson(bo, response);
	}
	
	@RequestMapping(value="/regCheckCode")
	public void getRegCheckCode(CheckCodeRequest vo, HttpServletResponse response) {
		
		CheckCodeResponse bo = new CheckCodeResponse();
		
		String checkCode = RandomStringUtils.randomNumeric(6);
		ParameterUtil.cacheCheckCode(vo.getMobileNo(), checkCode);
		
		bo.setMobileNo(vo.getMobileNo());
		bo.setCheckCode(checkCode);
		this.responseJson(bo, response);
	}
	

}
