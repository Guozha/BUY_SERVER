package com.guozha.buyserver.persistence.beans;

import java.sql.Timestamp;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 地址
 * 
 * @author sunhanbin
 * @date 2015-03-10
 */
public class AccAddress extends AbstractDO {

	private Integer addressId;// 地址ID
	private Integer userId;// 归属用户ID
	private String receiveName;// 收货人
	private String mobileNo;// 手机号
	private Integer provinceId;// 省份ID
	private Integer cityId;// 地市ID
	private Integer countyId;// 区县ID
	private Integer buildingId;// 小区ID
	private String buildingName;// 小区名
	private String detailAddr;// 详细地址
	private String defaultFlag;// 默认标识
	private Timestamp addTime;// 插入时间

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getCountyId() {
		return countyId;
	}

	public void setCountyId(int countyId) {
		this.countyId = countyId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

}
