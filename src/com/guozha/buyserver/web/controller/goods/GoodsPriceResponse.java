package com.guozha.buyserver.web.controller.goods;

import com.guozha.buyserver.persistence.beans.GooGoodsAmount;

/**
 * 商品價格BO
 * @Package com.guozha.buyserver.web.controller.goods
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 上午10:07:55
 */
public class GoodsPriceResponse {
	//private Integer goodsPriceId;
	private Integer goodsId;
	private Integer amount;
	private Integer price;
    private String unit;
	

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
