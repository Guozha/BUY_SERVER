package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: 小区
 * @author sunhanbin
 * @date 2015-3-18 上午10:59:03
 */
public class BasBuilding extends AbstractDO {

	private Integer buildingId;// 小区ID
	private String buildingName;// 小区名
	private Integer provinceId;// 省份ID
	private Integer cityId;// 地市ID
	private Integer countyId;// 区县ID
	private Integer marketId;// 农贸市场ID
	private String status;// 状态

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

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
