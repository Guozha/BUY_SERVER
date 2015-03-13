package com.guozha.buyserver.web.controller;

/**
 * 标识型返回对象
 * @Package com.guozha.buyserver.web.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-13 上午11:06:16
 */
public class MsgResponse {
	
	private String returnCode; //应答码 constants.xml
	private String msg;        //提示消息 自定义业务需要
	
	public MsgResponse(String returnCode,String msg){
		this.returnCode = returnCode;
		this.msg = msg;
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
