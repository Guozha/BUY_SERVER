package com.guozha.buyserver.web.controller;

import com.guozha.buyserver.persistence.BaseConditionVO;

/**
 * 公用的接参
 * @Package com.guozha.buyserver.web.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-13 上午11:44:12
 */
public class CommonRequest extends BaseConditionVO{
	
	private Integer userId;
	
	private Integer addressId;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
