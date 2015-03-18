package com.guozha.buyserver.web.controller.payment;

public class PayWayResponse {
	
	private String payWay;
	private String payWayName;
	private byte[] icon;
	
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getPayWayName() {
		return payWayName;
	}
	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName;
	}
	public byte[] getIcon() {
		return icon;
	}
	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

}
