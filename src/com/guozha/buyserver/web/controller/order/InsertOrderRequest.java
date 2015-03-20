package com.guozha.buyserver.web.controller.order;


public class InsertOrderRequest {
	
	private String token;
	private String orderType;
	private Integer userId;
	private Integer addressId;
	private Integer wantUpTime;
	private Integer wantDownTime;
	private String memo;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getWantUpTime() {
		return wantUpTime;
	}
	public void setWantUpTime(Integer wantUpTime) {
		this.wantUpTime = wantUpTime;
	}
	public Integer getWantDownTime() {
		return wantDownTime;
	}
	public void setWantDownTime(Integer wantDownTime) {
		this.wantDownTime = wantDownTime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

}
