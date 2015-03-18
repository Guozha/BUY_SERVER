package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class BuyChildOrder extends AbstractDO {
	
	private Integer childOrderId;
	private Integer orderId;
	private String sellerType;
	private Integer pushSellerId;
	private Integer pullSellerId;
	private String finishSettleFlag;
	private String status;
	
	public Integer getChildOrderId() {
		return childOrderId;
	}
	public void setChildOrderId(Integer childOrderId) {
		this.childOrderId = childOrderId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getSellerType() {
		return sellerType;
	}
	public void setSellerType(String sellerType) {
		this.sellerType = sellerType;
	}
	public Integer getPushSellerId() {
		return pushSellerId;
	}
	public void setPushSellerId(Integer pushSellerId) {
		this.pushSellerId = pushSellerId;
	}
	public Integer getPullSellerId() {
		return pullSellerId;
	}
	public void setPullSellerId(Integer pullSellerId) {
		this.pullSellerId = pullSellerId;
	}
	public String getFinishSettleFlag() {
		return finishSettleFlag;
	}
	public void setFinishSettleFlag(String finishSettleFlag) {
		this.finishSettleFlag = finishSettleFlag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
