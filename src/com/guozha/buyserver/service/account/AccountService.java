package com.guozha.buyserver.service.account;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.AccMyTicket;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.persistence.mapper.AccountMapper;
import com.guozha.buyserver.persistence.mapper.SysUserMapper;
import com.guozha.buyserver.service.common.CommonService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.AcceptRequest;
import com.guozha.buyserver.web.controller.account.AccountInfoResponse;
import com.guozha.buyserver.web.controller.account.BalanceResponse;
import com.guozha.buyserver.web.controller.account.GenerateInviteResponse;
import com.guozha.buyserver.web.controller.account.InviteResponse;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.LoginResponse;
import com.guozha.buyserver.web.controller.account.PasswdRequest;
import com.guozha.buyserver.web.controller.account.PasswdResponse;
import com.guozha.buyserver.web.controller.account.RegisterRequest;
import com.guozha.buyserver.web.controller.account.TicketRequest;

public interface AccountService extends BusinessObjectServiceMgr {

	// 获取账户余额
	BalanceResponse balance(SysUser user);

	// 我的账户信息
	AccountInfoResponse info(SysUser user);

	// 修改密码找回验证码
	MsgResponse checkCodeForResetPasswd(String mobileNo);

	// 修改密码
	PasswdResponse updatePasswd(PasswdRequest request);

	MsgResponse getCheckCodeForReg(String mobileNo);

	MsgResponse register(RegisterRequest vo);

	LoginResponse login(LoginRequest vo);

	MsgResponse logout(String token);

	// 汇总邀请信息
	InviteResponse listInvite(SysUser user);

	// 生成邀请
	GenerateInviteResponse invite(SysUser user);

	// 菜票编号生成生成公共规则
	String generateTicketNo(String ticketType);

	// 我的菜票查询
	List<AccMyTicket> list(TicketRequest ticket);

	// 菜票领用
	MsgResponse accept(AcceptRequest accept);

	SysUser getUserByMobileNo(String mobileNo);

	public void setSysUserMapper(SysUserMapper sysUserMapper);
	
	public SysUserMapper getSysUserMapper();

	public void setAccountMapper(AccountMapper accountMapper);
	
	public AccountMapper getAccountMapper();

	public void setCommonService(CommonService commonService);
	
	public CommonService getCommonService();

	// 头像设置
	MsgResponse setHeadImg(SysUser user);
	

}
