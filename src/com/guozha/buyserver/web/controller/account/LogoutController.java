package com.guozha.buyserver.web.controller.account;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.common.util.ParameterUtil;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/account")
public class LogoutController extends BaseController {
	
	@RequestMapping(value="/logout")
	public void logout(LogoutRequest vo, HttpServletResponse response) {
		
		ParameterUtil.removeToken(vo.getToken());
		
		LogoutResponse bo = new LogoutResponse();
		
		bo.setReturnCode("1");
		this.responseJson(bo, response);
	}

}
