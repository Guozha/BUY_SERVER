/**
 * 
 */
package com.guozha.buyserver.web.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.account.AccAddressService;
import com.guozha.buyserver.web.controller.BaseController;

/**
 * @Package com.guozha.buyserver.web.controller.account
 * @Description: 我的地址
 * @author sunhanbin
 * @date 2015-3-17 下午03:51:46
 */
@Controller
@RequestMapping(value = "/account/address")
public class AddressController extends BaseController {

	@Autowired
	private AccAddressService addressService;

	/**
	 * 查询我的地址
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 * @param vo
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/list")
	public void list(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(addressService.list(vo), response);
	}

	/**
	 * 获取行区列表
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 * @param vo
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/listArea")
	public void listArea(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(addressService.listArea(vo), response);
	}

	/**
	 * 获取行区列表
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 * @param vo
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/listBuilding")
	public void listBuilding(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(addressService.listBuilding(vo), response);
	}

	/**
	 * 添加地址
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 * @param vo
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/insert")
	public void insert(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(addressService.insert(vo), response);
	}

	/**
	 * 删除地址
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 * @param vo
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/delete")
	public void delete(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(addressService.delete(vo), response);
	}

	/**
	 * 设置默认地址
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 * @param vo
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/default")
	public void defaultAddress(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(addressService.defaultAddress(vo), response);
	}

}
