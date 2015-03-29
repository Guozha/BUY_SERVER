package com.guozha.buyserver.web.controller.goods;



public class GoodsResponse {
	
	private Integer goodsId;   //商品ID
	private String goodsName;  //商品名
	private String goodsImg;//商品图片URL
	private Integer unitPrice;//单价
	private String unit;//计量单位
	private String goodsProp;   //商品性质
	/*private FrontTypeResponse frontType = new FrontTypeResponse();
	private List<GoodsResponse> goodsList = new ArrayList<GoodsResponse>();
	public FrontTypeResponse getFrontType() {
		return frontType;
	}
	public void setFrontType(FrontTypeResponse frontType) {
		this.frontType = frontType;
	}
	public List<GoodsResponse> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsResponse> goodsList) {
		this.goodsList = goodsList;
	}*/
	
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
