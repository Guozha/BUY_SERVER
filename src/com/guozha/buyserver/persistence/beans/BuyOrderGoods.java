package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class BuyOrderGoods extends AbstractDO {
	
	private Integer orderGoodsId;
	private Integer orderId;
	private Integer goodsId;
	private String goodsName;
	private byte[] goodsImg;
	private Integer backTypeId;
	private Integer unitPrice;
	private Integer amount;
	private Integer price;
	private String goodStar;
	
	public Integer getOrderGoodsId() {
		return orderGoodsId;
	}
	public void setOrderGoodsId(Integer orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
	public byte[] getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(byte[] goodsImg) {
		this.goodsImg = goodsImg;
	}
	public Integer getBackTypeId() {
		return backTypeId;
	}
	public void setBackTypeId(Integer backTypeId) {
		this.backTypeId = backTypeId;
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
	public String getGoodStar() {
		return goodStar;
	}
	public void setGoodStar(String goodStar) {
		this.goodStar = goodStar;
	}

}
