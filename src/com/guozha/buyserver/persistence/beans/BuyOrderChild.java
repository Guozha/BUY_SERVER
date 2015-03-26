package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class BuyOrderChild extends AbstractDO {
	
	private Integer orderChildId;
	private Integer orderId;
	private Integer marketId;
	private Integer goodsId;
	private Integer backTypeId;
	private String goodsName;
	private byte[] goodsImg;
	private String unit;
	private Integer unitPrice;
	private Integer amount;
	private Integer price;
	private Integer realAmount;
	private String goodsFromType;
	private Integer goodsFromId;
	private Integer pushSellerId;
	private Integer pullSellerId;
	private String finishSettleFlag;
	private String status;
	
	public Integer getOrderChildId() {
		return orderChildId;
	}
	public void setOrderChildId(Integer orderChildId) {
		this.orderChildId = orderChildId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getMarketId() {
		return marketId;
	}
	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getBackTypeId() {
		return backTypeId;
	}
	public void setBackTypeId(Integer backTypeId) {
		this.backTypeId = backTypeId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public byte[] getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(byte[] goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(Integer realAmount) {
		this.realAmount = realAmount;
	}
	public String getGoodsFromType() {
		return goodsFromType;
	}
	public void setGoodsFromType(String goodsFromType) {
		this.goodsFromType = goodsFromType;
	}
	public Integer getGoodsFromId() {
		return goodsFromId;
	}
	public void setGoodsFromId(Integer goodsFromId) {
		this.goodsFromId = goodsFromId;
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
