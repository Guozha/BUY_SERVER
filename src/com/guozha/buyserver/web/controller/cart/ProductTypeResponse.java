package com.guozha.buyserver.web.controller.cart;

import java.util.List;

/**
 * 产品类别
 * @Package com.guozha.buyserver.web.controller.cart
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-2-11 上午9:47:31
 */
public class ProductTypeResponse {

	private String productType;
	private List<CartResponse> cartList;
	

	public List<CartResponse> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartResponse> cartList) {
		this.cartList = cartList;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	

}
