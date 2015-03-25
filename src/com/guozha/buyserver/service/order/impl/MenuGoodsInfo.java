package com.guozha.buyserver.service.order.impl;

public class MenuGoodsInfo {
	
	private Integer amount;
	private Integer goodsId;
	private String goodsName;
	private byte[] goodsImg;
	private Integer backTypeId;
	private String unit;
	
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

}
