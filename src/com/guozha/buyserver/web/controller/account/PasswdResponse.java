package com.guozha.buyserver.web.controller.account;

/**
 * 修改密码
 * 
 * @author sunhanbin
 *@date 2015-03-13
 */
public class PasswdResponse {

	private String returnCode;// 返回编码
	private String msg;// 消息

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
