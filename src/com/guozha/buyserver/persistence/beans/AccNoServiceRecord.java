/**
 * 
 */
package com.guozha.buyserver.persistence.beans;

import java.sql.Timestamp;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: 未覆盖区域记录表
 * @author sunhanbin
 * @date 2015-3-18 上午11:31:36
 */
public class AccNoServiceRecord extends AbstractDO {

	private Integer noServiceRecordId;
	private String mobileNo;
	private Integer provinceId;
	private Integer cityId;
	private Integer countyId;
	private String detailAddr;
	private Timestamp recordTime;
	public Integer getNoServiceRecordId() {
		return noServiceRecordId;
	}
	public void setNoServiceRecordId(Integer noServiceRecordId) {
		this.noServiceRecordId = noServiceRecordId;
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
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public Timestamp getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}
	
	
	

}
