package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 购物车
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-13 上午9:57:10
 */
public class BuyCart extends AbstractDO {

	private Integer cartId;
	private Integer userId;   
	private String splitType;  //contrants.xml
	private Integer goodsOrMenuId; //ID
	private String displayName; //名称
	private Integer price;  //价格
	private Integer amount; //份量
	private String unit; //计量单位
	
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
	public String getSplitType() {
		return splitType;
	}
	public void setSplitType(String splitType) {
		this.splitType = splitType;
	}
	public Integer getGoodsOrMenuId() {
		return goodsOrMenuId;
	}
	public void setGoodsOrMenuId(Integer goodsOrMenuId) {
		this.goodsOrMenuId = goodsOrMenuId;
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

}
