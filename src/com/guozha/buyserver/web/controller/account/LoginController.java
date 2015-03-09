package com.guozha.buyserver.web.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.account.LoginService;
import com.guozha.buyserver.service.account.User;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/account")
public class LoginController extends BaseController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login")
	public void getRegCheckCode(LoginRequest vo, HttpServletRequest request, HttpServletResponse response) {
		
		LoginResponse bo = new LoginResponse();
		
		User user = loginService.getLoginUser(vo);
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
				bo.setUserId(String.valueOf(user.getUserId()));
				bo.setMobileNo(vo.getMobileNo());
				bo.setReturnCode("1");
				bo.setMsg("登录成功");
				
				Session session = new Session();
				session.setToken(token);
				session.setUserId(user.getUserId());
				session.setMobileNo(user.getMobileNo());
				session.setHeadUrl(user.getHeadUrl());
				session.setPlanNotiTime(user.getPlanNotifTime());
				request.getSession().setAttribute("session", session);
			}
			
		}
		
		this.responseJson(bo, response);
	}

}
