package com.guozha.buyserver.web.controller.goods;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.goods.SpecialService;
import com.guozha.buyserver.web.controller.BaseController;

/**
 * 特供商品
 * @Package com.guozha.buyserver.web.controller.goods
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-10 下午5:41:04
 */
@Controller
@RequestMapping(value="/goods")
public class SpecialController extends BaseController {
   
	@Autowired
	private SpecialService specialService;
	
	/**
	 *特供商品列表
	 * @param vo
	 * @param response /special/list
	 */
	@RequestMapping(value="/special/list")
	public void special(GoodsRequest vo,HttpServletResponse response){
		responseJson(specialService.findGoods(vo), response);
	}
	
	
	/**
	 *特供详情
	 * @param vo
	 * @param response /special/detail
	 */
	@RequestMapping(value="/special/detail")
	public void detail(GoodsRequest vo,HttpServletResponse response){
		responseJson(specialService.findGoodsById(vo), response);
	}
}
