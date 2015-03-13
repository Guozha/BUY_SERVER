package com.guozha.buyserver.web.controller.cart;

import com.guozha.buyserver.web.controller.CommonRequest;

public class CartRequest extends CommonRequest{
	
	private Integer id;  //菜谱、菜品ID
	private String productType; //菜谱、菜品标记类型 constans.xml
	private Integer amount;  //份量
	private Integer[] cartId;  //购物车ID
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Integer[] getCartId() {
		return cartId;
	}
	public void setCartId(Integer[] cartId) {
		this.cartId = cartId;
	}

}
