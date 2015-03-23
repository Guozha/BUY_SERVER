package com.guozha.buyserver.service.goods;



public class GoodsBo {
	
	private Integer goodsId;   //商品ID
	private String goodsName;  //商品名
	private byte[] goodsImg;//商品图片URL
	private Integer unitPrice;//单价
	private String unit;//计量单位
	private String goodsProp;   //商品性质
	private Integer frontTypeId;
    public Integer getFrontTypeId() {
		return frontTypeId;
	}
	public void setFrontTypeId(Integer frontTypeId) {
		this.frontTypeId = frontTypeId;
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
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
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