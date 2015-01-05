package com.guozha.buyserver.web.controller.account;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.account.MySellerService;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/account/myseller")
public class MySellerController extends BaseController {
	
	@Autowired
	private MySellerService mySellerService;
	
	@RequestMapping(value="/list")
	public void list(int userId, HttpServletResponse response) {
		this.responseJson(mySellerService.findMySeller(userId), response);
	}
	
	@RequestMapping(value="/update")
	public void update(UpdateMySellerRequest vo, HttpServletResponse response) {
		this.responseJson(mySellerService.updateMySeller(vo), response);
	}
	
	@RequestMapping(value="/insert")
	public void insert(InsertMySellerRequest vo, HttpServletResponse response) {
		this.responseJson(mySellerService.insertMySeller(vo), response);
	}

}
