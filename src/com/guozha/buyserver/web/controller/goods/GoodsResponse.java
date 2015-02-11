package com.guozha.buyserver.web.controller.goods;

import com.guozha.buyserver.persistence.beans.GooGoods;

public class GoodsResponse {
	
	private Integer goodsId;   //商品ID
	private String goodsName;  //商品名
	private byte[] goodsImg;//商品图片URL
	private Integer price;//单价
	private String unit;//计量单位
	private String goodsProp;   //商品性质
	
	
	public GoodsResponse() {
		
	}
	public GoodsResponse(GooGoods po) {
		super();
		this.goodsId = po.getGoodsId();
		this.goodsName = po.getGoodsName();
		this.goodsImg = po.getGoodsImg();
		this.price = po.getPrice();
		this.unit = po.getUnit();
		this.goodsProp = po.getGoodsProp();
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getGoodsProp() {
		return goodsProp;
	}
	public void setGoodsProp(String goodsProp) {
		this.goodsProp = goodsProp;
	}
}
