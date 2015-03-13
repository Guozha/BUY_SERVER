package com.guozha.buyserver.web.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/account")
public class AccountController extends BaseController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/checkCodeForRegister")
	public void checkCodeForRegister(CheckCodeRequest vo, HttpServletResponse response) {
		this.responseJson(accountService.getCheckCodeForReg(vo), response);
	}
	
	@RequestMapping(value="/register")
	public void register(RegisterRequest vo, HttpServletResponse response) {
		this.responseJson(accountService.register(vo), response);
	}
	
	@RequestMapping(value="/login")
	public void login(LoginRequest vo, HttpServletRequest request, HttpServletResponse response) {
		this.responseJson(accountService.login(vo), response);
	}
	
	@RequestMapping(value="/logout")
	public void logout(LogoutRequest vo, HttpServletResponse response) {
		this.responseJson(accountService.logout(vo), response);
	}
	

}
