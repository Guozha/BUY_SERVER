package com.guozha.buyserver.web.controller.goods;


import com.guozha.buyserver.common.util.DateUtil;
import com.guozha.buyserver.persistence.beans.GooGoods;

public class GoodsInfoResponse {
	
	private Integer goodsId;   //商品ID
	private String goodsName;  //商品名
	private String goodsProp;   //商品性质
	private String goodsImg;//商品图片
	
	private Integer unitPrice;//单价
	
	private String unit;//计量单位
	private String memo;//商品备注
	private String prepareEndDate;//预售截止日期
	private Integer arrivalDays;//送达天数
	private String picDesc;//图文介绍
	private String otherNames;//别名
	
	public GoodsInfoResponse(GooGoods po){
		this.goodsId = po.getGoodsId();
		this.goodsName = po.getGoodsName();
		this.goodsProp = po.getGoodsProp();
		this.goodsImg = po.getGoodsImg();
		this.unit = po.getUnit();
		this.memo = po.getMemo();
		this.prepareEndDate = DateUtil.date2String(po.getPrepareEndDate(), DateUtil.PATTERN_DATE);
		this.arrivalDays = po.getArrivalDays();
		this.picDesc = po.getPicDesc();
		//this.otherNames = po.getOtherNames();
	}
	
	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
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
	public String getGoodsProp() {
		return goodsProp;
	}
	public void setGoodsProp(String goodsProp) {
		this.goodsProp = goodsProp;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
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
	public String getPrepareEndDate() {
		return prepareEndDate;
	}
	public void setPrepareEndDate(String prepareEndDate) {
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

}
