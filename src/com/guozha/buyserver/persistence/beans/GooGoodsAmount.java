package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 *份量配置
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-2-17 下午12:20:24
 */
public class GooGoodsAmount extends AbstractDO{
	    private Integer goodsAmountId;
		private Integer goodsId; //商品ID
		
		private Integer amount;
		
		public Integer getAmount() {
			return amount;
		}
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
		public Integer getGoodsAmountId() {
			return goodsAmountId;
		}
		public void setGoodsAmountId(Integer goodsAmountId) {
			this.goodsAmountId = goodsAmountId;
		}
		public Integer getGoodsId() {
			return goodsId;
		}
		public void setGoodsId(Integer goodsId) {
			this.goodsId = goodsId;
		}
}
