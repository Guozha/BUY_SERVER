/**
 * 获取地址信息requestVO
 * @author sunhanbin
 * @date 2015-03-12
 */
package com.guozha.buyserver.web.controller.account;

public class AddressRequest {

	private Integer userId;// 用户ID
	private Integer parentAreaId;// 上级行区ID
	private String receiveName; // 收货人
	private String mobileNo; // 收货人手机号
	private Integer provinceId; // 省id
	private Integer cityId; // 地市id
	private Integer countyId; // 区县id
	private Integer buildingId; // 小区id
	private String buildingName; // 小区名
	private String detailAddr; // 详细地址
	private String defaultFlag;// 是否默认地址

	private Integer addressId;// 地址ID
	private String status;// 地址状态
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getParentAreaId() {
		return parentAreaId;
	}
	public void setParentAreaId(Integer parentAreaId) {
		this.parentAreaId = parentAreaId;
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
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCountyId() {
		return countyId;
	}
	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}
	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
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
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
