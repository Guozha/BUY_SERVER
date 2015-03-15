package com.guozha.buyserver.web.controller.menuplan;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.web.controller.BaseController;

/**
 * 菜谱计划
 * 
 * @author sunhanbin
 * @date 2015-03-15
 * 
 */
@Controller
@RequestMapping(value = "/menuplan")
public class MenuPlanController extends BaseController {

	/**
	 * 新增菜谱
	 * 
	 * @author sunhanbin
	 * @date 2015-03-15
	 * @param request
	 * @param reponse
	 */
	@RequestMapping(value = "/insert")
	public void insert(MenuPlanRequest request, HttpServletResponse reponse) {
		responseJson(request, reponse);
	}

}
