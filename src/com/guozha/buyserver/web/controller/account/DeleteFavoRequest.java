package com.guozha.buyserver.web.controller.account;

public class DeleteFavoRequest {
	
	private String token;
	private Integer myFavoId;
	private String dirFlag;
	
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
	public String getDirFlag() {
		return dirFlag;
	}
	public void setDirFlag(String dirFlag) {
		this.dirFlag = dirFlag;
	}
	
}
