package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class MarMarketGoods extends AbstractDO {
	
	private Integer marketGoodsId;
	private Integer marketId;
	private Integer goodsId;
	private String openBuyFlag;
	
	public Integer getMarketGoodsId() {
		return marketGoodsId;
	}
	public void setMarketGoodsId(Integer marketGoodsId) {
		this.marketGoodsId = marketGoodsId;
	}
	public Integer getMarketId() {
		return marketId;
	}
	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getOpenBuyFlag() {
		return openBuyFlag;
	}
	public void setOpenBuyFlag(String openBuyFlag) {
		this.openBuyFlag = openBuyFlag;
	}

}
