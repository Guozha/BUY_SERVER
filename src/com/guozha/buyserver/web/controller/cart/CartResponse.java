package com.guozha.buyserver.web.controller.cart;

import java.util.ArrayList;
import java.util.List;


public class CartResponse {
	
	private Integer quantity;    //总个数
	private Integer totalPrice;  //总金额
	private Integer serviceFee; //服务费
	private Integer currServiceFee; //本次服务费
	
	private Integer serviceFeePrice; //免服务费最少金额
	
	private List<Menu> menuList = new ArrayList<Menu>();
	private List<Goods> goodsList = new ArrayList<Goods>();
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
	
	public Integer getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Integer serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Integer getServiceFeePrice() {
		return serviceFeePrice;
	}
	public void setServiceFeePrice(Integer serviceFeePrice) {
		this.serviceFeePrice = serviceFeePrice;
	}
	
	public Integer getCurrServiceFee() {
		return currServiceFee;
	}
	public void setCurrServiceFee(Integer currServiceFee) {
		this.currServiceFee = currServiceFee;
	}

}
