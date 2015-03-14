package com.guozha.buyserver.web.controller.account;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.account.MyFavoService;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/account/myfavo")
public class MyFavoController extends BaseController {
	
	@Autowired
	private MyFavoService myFavoService;
	
	@RequestMapping(value="/insert")
	public void insert(FavoMenuRequest vo, HttpServletResponse response) {
		this.responseJson(myFavoService.favoMenu(vo), response);
	}
	
	@RequestMapping(value="/list")
	public void list(int userId, HttpServletResponse response) {
		this.responseJson(myFavoService.findFavo(userId), response);
	}
	
	@RequestMapping(value="/insertDir")
	public void insertDir(InsertDirRequest vo, HttpServletResponse response) {
		this.responseJson(myFavoService.insertDir(vo), response);
	}
	
	@RequestMapping(value="/adjust")
	public void adjust(AdjustFavoRequest vo, HttpServletResponse response) {
		this.responseJson(myFavoService.adjustFavo(vo), response);
	}
	
	@RequestMapping(value="/delete")
	public void delete(DeleteFavoRequest vo, HttpServletResponse response) {
		this.responseJson(myFavoService.deleteFavo(vo), response);
	}
	
	@RequestMapping(value="/seeDir")
	public void seeDir(int parentId, HttpServletResponse response) {
		this.responseJson(myFavoService.findMenuByDir(parentId), response);
	}

}
