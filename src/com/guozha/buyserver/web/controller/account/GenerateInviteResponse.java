package com.guozha.buyserver.web.controller.account;


/**
 * 生成邀请返回对象
 * 
 * @author sunhanbin
 * @date 2015-03-16
 */
public class GenerateInviteResponse {

	private Integer inviteId;// 邀请ID
	private String returnCode;
	private String msg;

	public Integer getInviteId() {
		return inviteId;
	}

	public void setInviteId(Integer inviteId) {
		this.inviteId = inviteId;
	}

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
