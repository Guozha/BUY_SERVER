package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class AccMySeller extends AbstractDO {
	
	private Integer mySellerId;
	private Integer userId;
	private Integer sellerId;
	private String sellerTag;
	
	public Integer getMySellerId() {
		return mySellerId;
	}
	public void setMySellerId(Integer mySellerId) {
		this.mySellerId = mySellerId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerTag() {
		return sellerTag;
	}
	public void setSellerTag(String sellerTag) {
		this.sellerTag = sellerTag;
	}

}
