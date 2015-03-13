package com.guozha.buyserver.web.controller.account;

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

}
