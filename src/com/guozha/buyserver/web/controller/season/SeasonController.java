package com.guozha.buyserver.web.controller.season;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.season.SeasonService;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/season")
public class SeasonController extends BaseController {
	@Autowired
	private SeasonService seasonService;
	
	/**
	 * 查询节气食材
	 * @param response
	 */
	@RequestMapping(value="/list")
	public void list(HttpServletResponse response){
		responseJson(seasonService.find(), response);
	}

}
