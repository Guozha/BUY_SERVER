package com.guozha.buyserver.service.account;

import java.util.List;

import com.guozha.buyserver.web.controller.account.AddressRequest;
import com.guozha.buyserver.web.controller.account.AddressResponse;

/**
 * @Package com.guozha.buyserver.service
 * @Description: TODO
 * @author sunhanbin
 * @date 2015-3-17 下午03:46:09
 */
public interface AccAddressService {

	// 我的地址查询
	List<AddressResponse> list(AddressRequest address);

	// 获取行区列表
	List<AddressResponse> listArea(AddressRequest address);

	// 获取小区列表
	List<AddressResponse> listBuilding(AddressRequest address);

	// 新增地址
	ReturnCode insert(AddressRequest address);

	// 删除地址
	ReturnCode delete(AddressRequest address);

	// 设置默认地址
	ReturnCode defaultAddress(AddressRequest address);

}
