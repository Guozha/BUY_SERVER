package com.guozha.buyserver.web.controller.season;

import com.guozha.buyserver.persistence.beans.GooGoods;

public class SeasonGoods {

	private Integer goodsId;   //商品ID
	private String goodsName;  //商品名
	private String goodsImg;//商品图片URL
	private String memo;
	
	public SeasonGoods(GooGoods po) {
		super();
		this.goodsId = po.getGoodsId();
		this.goodsName = po.getGoodsName();
	    this.goodsImg = po.getGoodsImg();
		this.memo = po.getMemo();
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
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public SeasonGoods() {
		
	}

}
