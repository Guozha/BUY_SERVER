package com.guozha.buyserver.web.controller.order;


public class InsertSupplyOrderRequest {
	
	private String token;
	private Integer userId;
	private Integer addressId;
	private Integer marketGoodsId;
	private Integer amount;
	private Integer wantUpTime;
	private Integer wantDownTime;
	private String memo;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	public Integer getMarketGoodsId() {
		return marketGoodsId;
	}
	public void setMarketGoodsId(Integer marketGoodsId) {
		this.marketGoodsId = marketGoodsId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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

}
