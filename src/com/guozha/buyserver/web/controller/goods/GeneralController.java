package com.guozha.buyserver.web.controller.goods;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.goods.GeneralService;
import com.guozha.buyserver.web.controller.BaseController;


/**
 * 普通商品
 * @Package com.guozha.buyserver.web.controller.goods
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-10 下午5:40:53
 */
@Controller
@RequestMapping(value="/goods")
public class GeneralController extends BaseController {
	
	@Autowired
	private GeneralService generalService;
	
	/**
	 * 类目列表 仅一级(一或者二)
	 * @param vo
	 * @param response /frontType/typeList
	 */
	@RequestMapping(value="/frontType/typeList")
	public void typeList(FrontTypeRequest vo,HttpServletResponse response){
		responseJson(generalService.findFrontType(vo), response);
	}
	
	/**
	 * 类目列表 所有
	 * @param vo
	 * @param response /frontType/list
	 */
	@RequestMapping(value="/frontType/list")
	public void frontTypelist(HttpServletResponse response){
		responseJson(generalService.findFrontType(), response);
	}
	
	/**
	 * 普通商品列表 首页
	 * @param vo
	 * @param response  /general/list
	 */
	@RequestMapping(value="/general/list")
	public void  generalList(GoodsRequest vo,HttpServletResponse response){
		responseJson(generalService.findGoods(vo), response);
	}
	
	/**
	 * 普通类目商品列表
	 * @param vo
	 * @param response /general/typeList
	 */
	@RequestMapping(value="/general/typeList")
	public void generalTypeList(GoodsRequest vo,HttpServletResponse response){
		responseJson(generalService.findGoodsByFrontTypeId(vo), response);
	}
	
	/**
	 * 商品详情
	 * @param vo
	 * @param response /general/detail
	 */
	@RequestMapping(value="/general/detail")
	public void detail(GoodsRequest vo,HttpServletResponse response){
		responseJson(generalService.findGoodsById(vo), response);
	}
	
	/**
	 * 商品價格
	 * @param vo
	 * @param response /price
	 */
	@RequestMapping(value="/price")
	public void price(GoodsRequest vo,HttpServletResponse response){
		responseJson(generalService.findGoodsPriceByGoodsId(vo), response);
	}
    
	
}
