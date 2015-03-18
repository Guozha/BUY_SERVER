package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 农贸市场商品份量配置
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-2-17 下午12:20:24
 */
public class MarMarketGoodsPrice extends AbstractDO{
	    private Integer goodsPriceId;
		private Integer marketGoodsId; //农贸市场商品ID
		private Integer amount;
		
		public Integer getAmount() {
			return amount;
		}
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
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
}
