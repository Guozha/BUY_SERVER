package com.guozha.buyserver.web.controller.payment;

public class PayWayResponse {
	
	private String payWayId;
	private String payWayName;
	private String icon;
	
	public String getPayWayId() {
		return payWayId;
	}
	public void setPayWayId(String payWayId) {
		this.payWayId = payWayId;
	}
	public String getPayWayName() {
		return payWayName;
	}
	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

}
