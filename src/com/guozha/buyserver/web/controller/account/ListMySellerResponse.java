package com.guozha.buyserver.web.controller.account;

import com.guozha.buyserver.persistence.beans.SysSeller;

public class ListMySellerResponse {
	
	private Integer mySellerId;
	private Integer sellerId;
	private String sellerName;
	private byte[] logo;
	private String mainBusi;
	
	public ListMySellerResponse(){
		
	}
	
	public ListMySellerResponse(SysSeller po){
		super();
		this.mySellerId = po.getMySellerId();
		this.sellerId = po.getSellerId();
		this.sellerName = po.getSellerName();
		this.logo = po.getLogo();
		this.mainBusi = po.getMainBusi();
	}
	
	public Integer getMySellerId() {
		return mySellerId;
	}
	public void setMySellerId(Integer mySellerId) {
		this.mySellerId = mySellerId;
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
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public String getMainBusi() {
		return mainBusi;
	}
	public void setMainBusi(String mainBusi) {
		this.mainBusi = mainBusi;
	}

}
