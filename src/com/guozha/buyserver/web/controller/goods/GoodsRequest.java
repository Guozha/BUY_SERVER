package com.guozha.buyserver.web.controller.goods;

/**
 * 商品VO
 * @Package com.guozha.buyserver.web.controller.goods
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 下午12:42:42
 */
public class GoodsRequest {
	
	private Integer frontTypeId; //类目ID
	
	private Integer addressId; //用户地址id

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getFrontTypeId() {
		return frontTypeId;
	}

	public void setFrontTypeId(Integer frontTypeId) {
		this.frontTypeId = frontTypeId;
	}

}
