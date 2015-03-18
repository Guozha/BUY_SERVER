package com.guozha.buyserver.web.controller.goods;

import com.guozha.buyserver.web.controller.CommonRequest;

/**
 * 商品VO
 * @Package com.guozha.buyserver.web.controller.goods
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 下午12:42:42
 */
public class GoodsRequest extends CommonRequest{
	
	private Integer frontTypeId; //类目ID
	
	private Integer goodsId;

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getFrontTypeId() {
		return frontTypeId;
	}

	public void setFrontTypeId(Integer frontTypeId) {
		this.frontTypeId = frontTypeId;
	}

}
