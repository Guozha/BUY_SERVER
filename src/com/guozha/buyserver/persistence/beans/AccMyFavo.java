package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class AccMyFavo extends AbstractDO {
	
	private Integer myFavoId;
	private Integer userId;
	private String favoName;
	private Integer sort;
	
	public Integer getMyFavoId() {
		return myFavoId;
	}
	public void setMyFavoId(Integer myFavoId) {
		this.myFavoId = myFavoId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFavoName() {
		return favoName;
	}
	public void setFavoName(String favoName) {
		this.favoName = favoName;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
