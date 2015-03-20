package com.guozha.buyserver.web.controller.cart;

import java.util.ArrayList;
import java.util.List;


public class CartResponses {
	
	private Integer quantity;    //总个数
	private Integer totalPrice;  //总金额
	private List<Goods> goodsList = new ArrayList<Goods>();
	private List<Menu> menuList = new ArrayList<Menu>();
	
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

}
