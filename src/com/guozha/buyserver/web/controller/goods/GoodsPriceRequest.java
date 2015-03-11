package com.guozha.buyserver.web.controller.goods;

/**
 * 商品价格查询vo
 * @Package com.guozha.buyserver.web.controller.goods
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 上午10:03:47
 */
public class GoodsPriceRequest {
	
	private Integer goodsId; //商品ID

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

}
