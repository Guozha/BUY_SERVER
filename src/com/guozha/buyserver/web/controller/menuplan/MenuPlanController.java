package com.guozha.buyserver.web.controller.menuplan;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.menuplan.MenuPlanService;
import com.guozha.buyserver.web.controller.BaseController;

/**
 * @Package com.guozha.buyserver.web.controller.account
 * @Description: 菜谱计划
 * @author sunhanbin
 * @date 2015-3-19 下午12:33:17
 */
@Controller
@RequestMapping(value = "/menuplan")
public class MenuPlanController extends BaseController {

	@Autowired
	private MenuPlanService menuPlanService;

	/**
	 * 菜谱推荐
	 * 
	 * @author sunhanbin
	 * @date 2015-03-19
	 * @param response
	 */
	@RequestMapping(value = "/list")
	public void list(HttpServletResponse response) {
		responseJson(menuPlanService.listMenu(), response);
	}

	/**
	 * 菜谱详情
	 * 
	 * @author sunhanbin
	 * @date 2015-03-19
	 * @param response
	 */
	@RequestMapping(value = "/detail")
	public void detail(MenuDetailRequest request, HttpServletResponse response) {
		responseJson(menuPlanService.detail(request), response);
	}

	/**
	 * 添加菜谱计划
	 * 
	 * @author sunhanbin
	 * @date 2015-03-19
	 * @param requset
	 * @param reponse
	 */
	@RequestMapping(value = "/insert")
	public void insert(MenuUserPlanRequest requset, HttpServletResponse response) {
		responseJson(menuPlanService.insert(requset), response);
	}
	
	/**
	 * 商品相关菜谱列表
	 * @author txf
	 * @date 2015-03-23
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/goodsMenuList")
	public void menu(int goodsId,HttpServletResponse response){
		responseJson(menuPlanService.findByGoodsId(goodsId), response);
	}

}
