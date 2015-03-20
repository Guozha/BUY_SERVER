package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.AccAddress;
import com.guozha.buyserver.persistence.beans.AccNoServiceRecord;
import com.guozha.buyserver.web.controller.account.AddressRequest;
import com.guozha.buyserver.web.controller.account.AddressResponse;

/**
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO
 * @author sunhanbin
 * @date 2015-3-17 下午03:41:03
 */
public interface AccAddressMapper extends BaseMapper<AccAddress, Integer> {

	// 我的地址查询
	List<AddressResponse> getMyAddress(int userId);

	// 获取行区列表
	List<AddressResponse> listArea(int parentAreaId);

	// 获取小区列表
	List<AddressResponse> listBuilding(int countyId);

	// 新增地址
	int insert(AddressRequest address);

	// 删除地址
	int delete(int addressId);

	// 更改地主状态（是否默认地址）
	int defaultAddress(AddressRequest address);

	// 将用户其余地址设置为非默认
	int defaultAddressNo(int userId);

	// 插入未覆盖区域记录表
	void insertNoServiceRecord(AccNoServiceRecord noServiceRecord);

}
