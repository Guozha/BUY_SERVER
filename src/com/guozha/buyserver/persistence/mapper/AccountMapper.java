/**
 * 我的账户
 *  @author sunhanbin
 *  @date 2015-03-10
 */
package com.guozha.buyserver.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.AccAddress;
import com.guozha.buyserver.persistence.beans.AccMyInvite;
import com.guozha.buyserver.persistence.beans.AccMyTicket;
import com.guozha.buyserver.persistence.beans.AccMyTicketCount;
import com.guozha.buyserver.persistence.beans.SysSeq;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.web.controller.account.AcceptRequest;
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

	// 检查是否已领用过该用户的菜票
	Integer checkAccept(AcceptRequest accept);

	// 一周内是否已领取
	Integer checkWeekAccept(AcceptRequest accept);

	// 插入菜票表
	void insertTicket(AccMyTicket ticket);

	// 更新邀请表
	int updateInvite(AccMyInvite invite);

	// 查询邀请信息
	AccMyInvite listMyInvite(int myInviteId);

	// 插入发放人菜票统计表
	int insertTicketCount(AccMyTicketCount ticketCount);

	// 获取发放人菜票表
	int getTicketDrawCount(int userId);

	// 菜票返赠处理
	void resetTicketCount(Map paraMap);

	// 设置头像
	int setHeadImg(SysUser user);

}
