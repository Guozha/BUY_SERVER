package com.guozha.buyserver.web.controller.account;

public class UpdateMySellerRequest {
	
	private String token;
	private Integer mySellerId;
	private String sellerTag;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getMySellerId() {
		return mySellerId;
	}
	public void setMySellerId(Integer mySellerId) {
		this.mySellerId = mySellerId;
	}
	public String getSellerTag() {
		return sellerTag;
	}
	public void setSellerTag(String sellerTag) {
		this.sellerTag = sellerTag;
	}

}
