package com.guozha.buyserver.web.controller.order;

import java.util.ArrayList;
import java.util.List;

public class MenuInfo {
	
	private Integer menuId;
	private String menuName;
	private String menuImg;
	private Integer unitPrice;
	private Integer amount;
	private Integer price;
	private List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();

	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuImg() {
		return menuImg;
	}
	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
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
	public List<GoodsInfo> getGoodsInfoList() {
		return goodsInfoList;
	}
	public void setGoodsInfoList(List<GoodsInfo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

}
