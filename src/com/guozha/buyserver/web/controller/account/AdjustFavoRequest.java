package com.guozha.buyserver.web.controller.account;

public class AdjustFavoRequest {
	
	private String token;
	private Integer myFavoId;
	private Integer parentId;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getMyFavoId() {
		return myFavoId;
	}
	public void setMyFavoId(Integer myFavoId) {
		this.myFavoId = myFavoId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
