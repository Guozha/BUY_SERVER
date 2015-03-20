package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class MnuMenuGoods extends AbstractDO {
	
	private Integer menuGoodsId;
	private Integer menuId;
	private Integer goodsId;
	private String goodsName;
	private String otherNames;
	private Integer amount;
	
	public Integer getMenuGoodsId() {
		return menuGoodsId;
	}
	public void setMenuGoodsId(Integer menuGoodsId) {
		this.menuGoodsId = menuGoodsId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
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
	public String getOtherNames() {
		return otherNames;
	}
	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
