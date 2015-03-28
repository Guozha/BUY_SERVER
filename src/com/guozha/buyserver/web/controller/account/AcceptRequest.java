package com.guozha.buyserver.web.controller.account;

/**
 * @Package com.guozha.buyserver.web.controller.account
 * @Description: 菜票领用接口
 * @author sunhanbin
 * @date 2015-3-24 上午10:01:06
 */
public class AcceptRequest {

	private Integer inviteId;
	private String mobileNo;// 手机号
	private String ticketNo;
	private Integer userId;//发放人userID
	private Integer getUserId;//领用人userId

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getGetUserId() {
		return getUserId;
	}

	public void setGetUserId(Integer getUserId) {
		this.getUserId = getUserId;
	}

	public Integer getInviteId() {
		return inviteId;
	}

	public void setInviteId(Integer inviteId) {
		this.inviteId = inviteId;
	}

}
