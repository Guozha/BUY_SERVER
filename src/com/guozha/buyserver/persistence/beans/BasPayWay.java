package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class BasPayWay extends AbstractDO{
	
	private Integer payWayId;
	private String payWay;
	private String payWayName;
	private byte[] icon;
	private String status;
	
	public Integer getPayWayId() {
		return payWayId;
	}
	public void setPayWayId(Integer payWayId) {
		this.payWayId = payWayId;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
