package com.guozha.buyserver.web.controller.account;

public class ListFavoRequest {
	
	private String token;
	private Integer userId;
	
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

}
