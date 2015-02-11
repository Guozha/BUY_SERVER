package com.guozha.buyserver.web.controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.cart.CartService;
import com.guozha.buyserver.web.controller.BaseController;

/**
 * 购物车
 * @Package com.guozha.buyserver.web.controller.cart
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-2-11 上午9:36:47
 */
@Controller
@RequestMapping(value="/cart")
public class CartController extends BaseController {
	
	@Autowired
	private CartService cartService;
	
	/**
	 * 添加购物车
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/add")
	public void add(CartRequest vo,HttpServletRequest request,HttpServletResponse response){
		responseJson(cartService.add(vo), response);
	}
	
	/**
	 * 查询购物车
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/list")
	public void list(CartRequest vo,HttpServletResponse response){
		responseJson(cartService.find(vo), response);
	}
	
	/**
	 * 清空购物车
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/clear")
	public void clear(CartRequest vo,HttpServletResponse response){
		responseJson(cartService.clear(vo), response);
	}
	
	/**
	 * 删除购物车
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/del")
	public void del(CartRequest vo,HttpServletResponse response){
		responseJson(cartService.del(vo), response);
	}
	
	
	/**
	 * 修改购物车
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="/update")
	public void update(CartRequest vo,HttpServletResponse response){
		responseJson(cartService.update(vo), response);
	}
	
}
