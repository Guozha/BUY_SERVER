package com.guozha.buyserver.web.controller.goods;

import java.util.Date;

public class GoodsInfoResponse {
	
	private Integer goodsId;   //商品ID
	private String goodsName;  //商品名
	private String goodsProp;   //商品性质
	private String goodsUrl;//商品图片URL
	private Integer price;//单价
	private String unit;//计量单位
	private String memo;//商品备注
	private Date prepareEndDate;//预售截止日期
	private Integer arrivalDays;//送达天数
	private String picDesc;//图文介绍
	private String otherNames;//别名
	private String status;//状态（参考constant.xml)
	
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
	public String getGoodsProp() {
		return goodsProp;
	}
	public void setGoodsProp(String goodsProp) {
		this.goodsProp = goodsProp;
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getPrepareEndDate() {
		return prepareEndDate;
	}
	public void setPrepareEndDate(Date prepareEndDate) {
		this.prepareEndDate = prepareEndDate;
	}
	public Integer getArrivalDays() {
		return arrivalDays;
	}
	public void setArrivalDays(Integer arrivalDays) {
		this.arrivalDays = arrivalDays;
	}
	public String getPicDesc() {
		return picDesc;
	}
	public void setPicDesc(String picDesc) {
		this.picDesc = picDesc;
	}
	public String getOtherNames() {
		return otherNames;
	}
	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
