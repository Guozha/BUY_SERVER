package com.guozha.buyserver.web.controller.order;

public class GoodsInfo {
	
	private Integer goodsId;
	private String goodsName;
	private String goodsImg;
	private Integer unitPrice;
	private Integer amount;
	private Integer price;
	private Integer goodsStar;
	
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
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
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
	public Integer getGoodsStar() {
		return goodsStar;
	}
	public void setGoodsStar(Integer goodsStar) {
		this.goodsStar = goodsStar;
	}

}
