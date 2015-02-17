package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 农贸市场商品价格
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-2-17 下午12:20:24
 */
public class MarMarketGoodsPrice extends AbstractDO{
	    private Integer goodsPriceId;
		private Integer marketGoodsId; //农贸市场商品ID
		private Integer weight;
		private Integer price;
		
		public Integer getMarketGoodsId() {
			return marketGoodsId;
		}
		public void setMarketGoodsId(Integer marketGoodsId) {
			this.marketGoodsId = marketGoodsId;
		}
		public Integer getGoodsPriceId() {
			return goodsPriceId;
		}
		public void setGoodsPriceId(Integer goodsPriceId) {
			this.goodsPriceId = goodsPriceId;
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
