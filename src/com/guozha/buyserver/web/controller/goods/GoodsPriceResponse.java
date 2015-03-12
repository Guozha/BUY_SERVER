package com.guozha.buyserver.web.controller.goods;

import com.guozha.buyserver.persistence.beans.GooGoodsPrice;

/**
 * 商品價格BO
 * @Package com.guozha.buyserver.web.controller.goods
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 上午10:07:55
 */
public class GoodsPriceResponse {
	private Integer goodsPriceId;
	private Integer goodsId;
	private Integer weight;
	private Integer price;
    
	
	
	public GoodsPriceResponse(GooGoodsPrice po) {
		super();
		this.goodsPriceId = po.getGoodsPriceId();
		this.goodsId = po.getGoodsId();
		this.weight = po.getWeight();
		this.price = po.getPrice();
	}

	public Integer getGoodsPriceId() {
		return goodsPriceId;
	}

	public void setGoodsPriceId(Integer goodsPriceId) {
		this.goodsPriceId = goodsPriceId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
