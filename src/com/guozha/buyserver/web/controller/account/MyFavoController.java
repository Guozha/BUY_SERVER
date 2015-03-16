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
	
	@RequestMapping(value="/insertGoodsFavo")
	public void insertGoodsFavo(FavoGoodsRequest vo, HttpServletResponse response) {
		this.responseJson(myFavoService.favoGoods(vo), response);
	}
	
	@RequestMapping(value="/insertMenuFavo")
	public void insertMenuFavo(FavoMenuRequest vo, HttpServletResponse response) {
		this.responseJson(myFavoService.favoMenu(vo), response);
	}
	
	@RequestMapping(value="/listGoodsFavo")
	public void listGoodsFavo(SearchGoodsFavoRequest vo, HttpServletResponse response) {
		this.responseJson(myFavoService.findGoodsFavo(vo), response);
	}
	
	@RequestMapping(value="/listMenuFavo")
	public void listMenuFavo(int userId, HttpServletResponse response) {
		this.responseJson(myFavoService.findMenuFavo(userId), response);
	}
	
	@RequestMapping(value="/insertDir")
	public void insertDir(InsertDirRequest vo, HttpServletResponse response) {
		this.responseJson(myFavoService.insertDir(vo), response);
	}
	
	@RequestMapping(value="/listDir")
	public void listDir(int userId, HttpServletResponse response) {
		this.responseJson(myFavoService.findDir(userId), response);
	}
	
	@RequestMapping(value="/adjustMenuFavo")
	public void adjustMenuFavo(AdjustFavoRequest vo, HttpServletResponse response) {
		this.responseJson(myFavoService.adjustFavo(vo), response);
	}
	
	@RequestMapping(value="/delete")
	public void delete(DeleteFavoRequest vo, HttpServletResponse response) {
		this.responseJson(myFavoService.deleteFavo(vo), response);
	}
	
	@RequestMapping(value="/seeDir")
	public void seeDir(int myFavoId, HttpServletResponse response) {
		this.responseJson(myFavoService.findMenuByDir(myFavoId), response);
	}

}
