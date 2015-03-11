package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 商品价格
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 上午9:51:32
 */
public class GooGoodsPrice extends AbstractDO {

    private Integer goodsPriceId;
	private Integer goodsId;
	private Integer weight;
	private Integer price;
	
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
