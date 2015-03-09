package com.guozha.buyserver.web.controller.account;

public class Session {
	
	private String token;
	private Integer userId;
	private String mobileNo;
	private String headUrl;
	private String planNotiTime;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public String getPlanNotiTime() {
		return planNotiTime;
	}
	public void setPlanNotiTime(String planNotiTime) {
		this.planNotiTime = planNotiTime;
	}

}
