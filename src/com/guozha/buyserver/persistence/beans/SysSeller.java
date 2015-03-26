package com.guozha.buyserver.persistence.beans;

import java.util.Date;

import com.guozha.buyserver.dal.object.AbstractDO;

public class SysSeller extends AbstractDO {
	
	private Integer sellerId;
	private String mobileNo;
	private String passwd;
	private String sellerName;
	private byte[] logo;
	private String mainBusi;
	private Integer transCount;
	private Date lastPayDate;
	private Integer marketId;
	private Double goodRate;
	private String status;
	
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	public Integer getTransCount() {
		return transCount;
	}
	public void setTransCount(Integer transCount) {
		this.transCount = transCount;
	}
	public String getMainBusi() {
		return mainBusi;
	}
	public void setMainBusi(String mainBusi) {
		this.mainBusi = mainBusi;
	}
	public Date getLastPayDate() {
		return lastPayDate;
	}
	public void setLastPayDate(Date lastPayDate) {
		this.lastPayDate = lastPayDate;
	}
	public Integer getMarketId() {
		return marketId;
	}
	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getGoodRate() {
		return goodRate;
	}
	public void setGoodRate(Double goodRate) {
		this.goodRate = goodRate;
	}

}
