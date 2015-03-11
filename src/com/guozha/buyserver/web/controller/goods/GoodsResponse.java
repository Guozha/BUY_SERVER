package com.guozha.buyserver.web.controller.goods;


public class GoodsResponse {
	
	private Integer goodsId;   //商品ID
	private String goodsName;  //商品名
	private String goodsUrl;//商品图片URL
	private Integer price;//单价
	private String unit;//计量单位
	
	
	
	public GoodsResponse(Integer goodsId, String goodsName, String goodsUrl,Integer price, String unit) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsUrl = goodsUrl;
		this.price = price;
		this.unit = unit;
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
}
