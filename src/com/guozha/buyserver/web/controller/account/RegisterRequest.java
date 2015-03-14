package com.guozha.buyserver.web.controller.account;

public class RegisterRequest {
	
	private String mobileNo;
	private String passwd;
	private String checkCode;
	private Integer myInviteId;
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public Integer getMyInviteId() {
		return myInviteId;
	}
	public void setMyInviteId(Integer myInviteId) {
		this.myInviteId = myInviteId;
	}

}
