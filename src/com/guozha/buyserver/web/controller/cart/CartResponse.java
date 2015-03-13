package com.guozha.buyserver.web.controller.cart;

import com.guozha.buyserver.persistence.beans.BuyCart;

public class CartResponse {
   

	private Integer cartId;
	private Integer userId;
	private String  productType;
	private Integer id;
	private String  displayName;
	private Integer price;
	private Integer amount;
	private String unit; //计量单位
	

	
	public CartResponse(BuyCart po) {
		super();
		this.cartId = po.getCartId();
		this.productType = po.getSplitType();
		this.id = po.getGoodsOrMenuId();
		this.displayName = po.getDisplayName();
		this.price = po.getPrice();
		this.amount = po.getAmount();
		this.unit  = po.getUnit();
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}