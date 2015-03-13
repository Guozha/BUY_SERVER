package com.guozha.buyserver.service.account;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.AccMyTicket;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.AccountInfoResponse;
import com.guozha.buyserver.web.controller.account.AddressRequest;
import com.guozha.buyserver.web.controller.account.AddressResponse;
import com.guozha.buyserver.web.controller.account.BalanceResponse;
import com.guozha.buyserver.web.controller.account.CheckCodeRequest;
import com.guozha.buyserver.web.controller.account.CheckCodeResponse;
import com.guozha.buyserver.web.controller.account.InviteResponse;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.LoginResponse;
import com.guozha.buyserver.web.controller.account.LogoutRequest;
import com.guozha.buyserver.web.controller.account.PasswdRequest;
import com.guozha.buyserver.web.controller.account.PasswdResponse;
import com.guozha.buyserver.web.controller.account.RegisterRequest;
import com.guozha.buyserver.web.controller.account.TicketRequest;

public interface AccountService extends BusinessObjectServiceMgr {

	// 获取账户余额
	BalanceResponse balance(SysUser user);

	// 我的账户信息
	AccountInfoResponse info(SysUser user);

	// 修改密码
	PasswdResponse updatePasswd(PasswdRequest request);

	CheckCodeResponse getCheckCodeForReg(CheckCodeRequest vo);

	MsgResponse register(RegisterRequest vo);

	LoginResponse login(LoginRequest vo);

	MsgResponse logout(LogoutRequest vo);

	// 汇总邀请信息
	InviteResponse listInvite(SysUser user);

	// 生成邀请
	ReturnCode invite(SysUser user);

	// 菜票编号生成生成公共规则
	String generateTicketNo(String ticketType);
	
	// 我的地址查询
	List<AddressResponse> list(AddressRequest address);

	// 获取行区列表
	List<AddressResponse> listArea(AddressRequest address);

	// 获取小区列表
	List<AddressResponse> listBuilding(AddressRequest address);

	// 新增地址
	ReturnCode insert(AddressRequest address);

	// 删除地址
	ReturnCode delete(AddressRequest address);

	// 设置默认地址
	ReturnCode defaultAddress(AddressRequest address);
	
	// 我的菜票查询
	List<AccMyTicket> list(TicketRequest ticket);

}
