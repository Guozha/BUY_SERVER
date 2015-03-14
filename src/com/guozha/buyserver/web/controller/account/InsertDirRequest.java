package com.guozha.buyserver.web.controller.account;

public class InsertDirRequest {
	
	private String token;
	private Integer userId;
	private String favoName;
	
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
	public String getFavoName() {
		return favoName;
	}
	public void setFavoName(String favoName) {
		this.favoName = favoName;
	}

}
