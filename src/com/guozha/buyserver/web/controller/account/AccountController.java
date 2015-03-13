package com.guozha.buyserver.web.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.service.account.AccountService;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/account")
public class AccountController extends BaseController {
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * 获取账户余额
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value = "/balance")
	public void balance(SysUser vo, HttpServletResponse response) {
		responseJson(accountService.balance(vo), response);
	}

	/**
	 * 我的账户信息
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value = "/info")
	public void accountInfo(SysUser vo, HttpServletResponse response) {
		responseJson(accountService.info(vo), response);
	}

	/**
	 * 修改密码
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value = "/updatePasswd")
	public void updatePasswd(PasswdRequest vo, HttpServletResponse response) {
		responseJson(accountService.updatePasswd(vo), response);
	}
	
	@RequestMapping(value="/checkCodeForRegister")
	public void checkCodeForRegister(CheckCodeRequest vo, HttpServletResponse response) {
		this.responseJson(accountService.getCheckCodeForReg(vo), response);
	}
	
	@RequestMapping(value="/register")
	public void register(RegisterRequest vo, HttpServletResponse response) {
		this.responseJson(accountService.register(vo), response);
	}
	
	@RequestMapping(value="/login")
	public void login(LoginRequest vo, HttpServletRequest request, HttpServletResponse response) {
		this.responseJson(accountService.login(vo), response);
	}
	
	@RequestMapping(value="/logout")
	public void logout(LogoutRequest vo, HttpServletResponse response) {
		this.responseJson(accountService.logout(vo), response);
	}
	
	/**
	 * 查询我的地址
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 * @param vo
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/address/list")
	public void list(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(accountService.list(vo), response);
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
	@RequestMapping(value = "/address/listArea")
	public void listArea(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(accountService.listArea(vo), response);
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
	@RequestMapping(value = "/address/listBuilding")
	public void listBuilding(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(accountService.listBuilding(vo), response);
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
	@RequestMapping(value = "/address/insert")
	public void insert(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(accountService.insert(vo), response);
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
	@RequestMapping(value = "/address/delete")
	public void delete(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(accountService.delete(vo), response);
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
	@RequestMapping(value = "/address/default")
	public void defaultAddress(AddressRequest vo, HttpServletRequest request, HttpServletResponse response) {
		responseJson(accountService.defaultAddress(vo), response);
	}
	
	
	/**
	 * 我的菜票查询
	 * 
	 * @param ticket
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/ticket/list")
	public void list(TicketRequest ticket, HttpServletRequest request, HttpServletResponse response) {
		responseJson(accountService.list(ticket), response);
	}
	
	/**
	 * 汇总邀请信息
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 * @param user
	 * @param response
	 */
	@RequestMapping(value = "/invite/info")
	public void info(SysUser user, HttpServletResponse response) {
		responseJson(accountService.listInvite(user), response);
	}

	/**
	 * 生成邀请
	 * 
	 * @author sunhanbin
	 * @date 2015-03-13
	 * @param user
	 * @param response
	 */
	@RequestMapping(value = "/invite/insert")
	public void invite(SysUser user, HttpServletResponse response) {
		responseJson(accountService.invite(user), response);
	}
	

}
