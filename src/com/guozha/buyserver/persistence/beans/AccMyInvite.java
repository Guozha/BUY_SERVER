package com.guozha.buyserver.persistence.beans;

import java.sql.Timestamp;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 我的邀请
 * 
 * @author sunhanbin
 * @date 2015-03-13
 */
public class AccMyInvite extends AbstractDO {

	private int myInviteId;// 我的邀请ID
	private int userId;// 用户ID
	private String toMobileNo;// 受邀手机号
	private Timestamp inviteTime;// 邀请时间
	private String ticketNo;// 菜票编号
	private int parValue;// 菜票面值
	private String drawFlag;// 领取标识
	private String useFlag;// 使用标识

	public int getMyInviteId() {
		return myInviteId;
	}

	public void setMyInviteId(int myInviteId) {
		this.myInviteId = myInviteId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getToMobileNo() {
		return toMobileNo;
	}

	public void setToMobileNo(String toMobileNo) {
		this.toMobileNo = toMobileNo;
	}

	public Timestamp getInviteTime() {
		return inviteTime;
	}

	public void setInviteTime(Timestamp inviteTime) {
		this.inviteTime = inviteTime;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public int getParValue() {
		return parValue;
	}

	public void setParValue(int parValue) {
		this.parValue = parValue;
	}

	public String getDrawFlag() {
		return drawFlag;
	}

	public void setDrawFlag(String drawFlag) {
		this.drawFlag = drawFlag;
	}

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

}
