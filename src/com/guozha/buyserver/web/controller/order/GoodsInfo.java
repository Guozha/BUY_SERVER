package com.guozha.buyserver.web.controller.order;

public class GoodsInfo {
	
	private Integer goodsId;
	private String goodsName;
	private byte[] goodsImg;
	private Integer unitPrice;
	private Integer amount;
	private Integer price;
	private String goodsStar;
	
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
	public String getGoodsStar() {
		return goodsStar;
	}
	public void setGoodsStar(String goodsStar) {
		this.goodsStar = goodsStar;
	}

}
