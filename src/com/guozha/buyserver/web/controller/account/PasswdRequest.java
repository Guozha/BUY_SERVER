package com.guozha.buyserver.web.controller.account;

/**
 * 修改密码
 * @author sunhanbin
 * @date 2015-03-13
 *
 */
public class PasswdRequest {
	
	private String mobileNo;//手机号
	private String passwd;//新密码
	private String checkCode;//验证码
	
	
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
	
	


}
