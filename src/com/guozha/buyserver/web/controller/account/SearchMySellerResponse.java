package com.guozha.buyserver.web.controller.account;


public class SearchMySellerResponse {
	
	private Integer mySellerId;
	private Integer sellerId;
	private String sellerName;
	private String logo;
	private String mainBusi;
	private String sellerTag;
	private Integer transCount;
	
	public Integer getMySellerId() {
		return mySellerId;
	}
	
	public void setMySellerId(Integer mySellerId) {
		this.mySellerId = mySellerId;
	}
	
	public String getSellerTag() {
		return sellerTag;
	}

	public void setSellerTag(String sellerTag) {
		this.sellerTag = sellerTag;
	}

	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMainBusi() {
		return mainBusi;
	}
	public void setMainBusi(String mainBusi) {
		this.mainBusi = mainBusi;
	}

	public Integer getTransCount() {
		return transCount;
	}

	public void setTransCount(Integer transCount) {
		this.transCount = transCount;
	}

}
