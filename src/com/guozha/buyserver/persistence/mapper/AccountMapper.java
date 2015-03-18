/**
 * 我的账户
 *  @author sunhanbin
 *  @date 2015-03-10
 */
package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.AccAddress;
import com.guozha.buyserver.persistence.beans.AccMyInvite;
import com.guozha.buyserver.persistence.beans.AccMyTicket;
import com.guozha.buyserver.persistence.beans.SysSeq;
import com.guozha.buyserver.web.controller.account.AccountInfoResponse;
import com.guozha.buyserver.web.controller.account.BalanceResponse;
import com.guozha.buyserver.web.controller.account.PasswdRequest;

@Repository
public interface AccountMapper extends BaseMapper<AccAddress, Integer> {

	// 我的菜票查询（所有有效菜票）
	List<AccMyTicket> listTicketValid(int userId);

	// 菜票查询（一个月内失效菜票）
	List<AccMyTicket> listTicketInvalid(int userId);

	// 获取账户余额
	BalanceResponse getMyBalance(int userId);

	// 获取我的账户信息
	AccountInfoResponse getMyAccountInfo(int userId);

	// 修改密码
	int updatePasswd(PasswdRequest request);

	// 统计领用的菜票信息
	int countDrawTicket(int userId);

	// 统计使用的菜票信息
	int countUsedTicket(int userId);

	// 当前菜票最大编号
	String getCurrentNo(String ticketType);

	// 插入流水表
	int insertSeqNo(SysSeq seq);

	// 更新流水表
	int updateSeqNo(SysSeq seq);

	// 生成邀请
	int insertInvite(AccMyInvite invite);

}
