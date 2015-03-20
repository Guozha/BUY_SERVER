package com.guozha.buyserver.service.account.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.DateUtil;
import com.guozha.buyserver.framework.enums.ReturnCodeEnum;
import com.guozha.buyserver.framework.enums.YesNo;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.AccAddress;
import com.guozha.buyserver.persistence.beans.AccNoServiceRecord;
import com.guozha.buyserver.persistence.mapper.AccAddressMapper;
import com.guozha.buyserver.service.account.AccAddressService;
import com.guozha.buyserver.service.account.ReturnCode;
import com.guozha.buyserver.web.controller.account.AddressRequest;
import com.guozha.buyserver.web.controller.account.AddressResponse;

/**
 * @Package com.guozha.buyserver.service.account.impl
 * @Description: TODO
 * @author sunhanbin
 * @date 2015-3-17 下午03:49:30
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class AccAddressServiceImpl extends AbstractBusinessObjectServiceMgr implements AccAddressService {

	@Autowired
	private AccAddressMapper accAddressMapper;

	/**
	 * 我的地址查询
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 */
	public List<AddressResponse> list(AddressRequest request) {
		List<AddressResponse> reponse = null;
		if (request != null) {
			int userId = request.getUserId();
			if (userId > 0)
				reponse = accAddressMapper.getMyAddress(userId);
		}
		return reponse;
	}

	/**
	 * 获取行区列表
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 */
	public List<AddressResponse> listArea(AddressRequest request) {
		List<AddressResponse> reponse = null;
		if (request != null) {
			int parentAreaId = request.getParentAreaId();
			if (parentAreaId > 0)
				reponse = accAddressMapper.listArea(parentAreaId);
		}
		return reponse;
	}

	/**
	 * 获取小区列表
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 */
	public List<AddressResponse> listBuilding(AddressRequest request) {
		List<AddressResponse> reponse = null;
		if (request != null) {
			int countyId = request.getCountyId();
			if (countyId > 0)
				reponse = accAddressMapper.listBuilding(countyId);
		}
		return reponse;
	}

	/**
	 * 新增地址
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 */
	public ReturnCode insert(AddressRequest request) {
		ReturnCode result = new ReturnCode();
		if (request != null) {
			String defaultFlag = request.getDefaultFlag();
			// 小区是否已存在
//			Integer buildingId = request.getBuildingId();
//			AccAddress address = new AccAddress();
//			address.setAddTime(Timestamp.valueOf(DateUtil.date2String(new Date(), DateUtil.PATTERN_STANDARD)));
//			address.setBuildingId(buildingId);
//			address.setBuildingName(request.getBuildingName());
//			address.setCityId(request.getCityId());
//			address.setCountyId(request.getCountyId());
//			address.setDefaultFlag(request.getDefaultFlag());
//			address.setDetailAddr(request.getDetailAddr());
//			address.setMobileNo(request.getMobileNo());
//			address.setProvinceId(request.getProvinceId());
//			address.setReceiveName(request.getReceiveName());
//			address.setUserId(request.getUserId());
			request.setAddTime(Timestamp.valueOf(DateUtil.date2String(new Date(), DateUtil.PATTERN_STANDARD)));
			accAddressMapper.insert(request);
			if (YesNo.Yes.getCode().toString().equals(defaultFlag))// 如果设为默认地址
				result = defaultAddress(request);
			else if (request.getAddressId() > 0) {
				result.setReturnCode(ReturnCodeEnum.SUCCESS.status);
			}
		}
		return result;
	}

	/**
	 * 删除地址
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 */
	public ReturnCode delete(AddressRequest address) {
		String returncode = "";
		ReturnCode result = new ReturnCode();
		int count = 0;
		if (address != null) {
			int addressId = address.getAddressId();
			if (addressId > 0)
				count = accAddressMapper.delete(addressId);
			returncode = count == 1 ? ReturnCodeEnum.SUCCESS.status : ReturnCodeEnum.FAILED.status;
			result.setReturnCode(returncode);
		}
		return result;
	}

	/**
	 * 设置默认地址
	 * 
	 * @author sunhanbin
	 * @date 2015-03-10
	 */
	public ReturnCode defaultAddress(AddressRequest address) {
		String returncode = "";
		ReturnCode result = new ReturnCode();
		int count = 0;
		if (address != null) {
			int addressId = address.getAddressId();
			if (addressId > 0) {
				// 先将其余地址设置为非默认
				address.setDefaultFlag(YesNo.No.getCode().toString());
				count = accAddressMapper.defaultAddress(address);
				// 设置默认地址
				address.setDefaultFlag(YesNo.Yes.getCode().toString());
				count = accAddressMapper.defaultAddress(address);
			}
			returncode = count == 1 ? ReturnCodeEnum.SUCCESS.status : ReturnCodeEnum.FAILED.status;
			result.setReturnCode(returncode);
		}
		return result;
	}

}
