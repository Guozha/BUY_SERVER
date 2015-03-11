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
	 * 类目列表
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/frontType")
	public void frontType(FrontTypeRequest vo,HttpServletResponse response){
		responseJson(generalService.findFrontType(vo), response);
	}
	
	/**
	 * 普通商品列表
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/general")
	public void general(GoodsRequest vo,HttpServletResponse response){
		responseJson(generalService.findGoods(vo), response);
	}
	
	/**
	 * 商品详情
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/info")
	public void info(GoodsInfoRequest vo,HttpServletResponse response){
		responseJson(generalService.findGoodsById(vo.getGoodsId()), response);
	}
	
	/**
	 * 商品價格
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/price")
	public void price(GoodsPriceRequest vo,HttpServletResponse response){
		responseJson(generalService.findGoodsPriceByGoodsId(vo.getGoodsId()), response);
	}
    
	/**
	 * 商品菜谱
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/menu")
	public void menu(GoodsMenuRequest vo,HttpServletResponse response){
		responseJson(generalService.findMenuByGoodsId(vo.getGoodsId()), response);
	}

}
