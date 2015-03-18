package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class BuyChildOrderGoods extends AbstractDO {
	
	private Integer childOrderGoodsId;
	private Integer childOrderId;
	private Integer goodsId;
	private String goodsName;
	private String goodsUrl;
	private Integer unitPrice;
	private Integer amount;
	private Integer price;
	private Integer realAmount;
	private String fromType;
	private Integer fromId;
	
	public Integer getChildOrderGoodsId() {
		return childOrderGoodsId;
	}
	public void setChildOrderGoodsId(Integer childOrderGoodsId) {
		this.childOrderGoodsId = childOrderGoodsId;
	}
	public Integer getChildOrderId() {
		return childOrderId;
	}
	public void setChildOrderId(Integer childOrderId) {
		this.childOrderId = childOrderId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsUrl() {
		return goodsUrl;
	}
	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
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
	public String getFromType() {
		return fromType;
	}
	public void setFromType(String fromType) {
		this.fromType = fromType;
	}
	public Integer getFromId() {
		return fromId;
	}
	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

}
