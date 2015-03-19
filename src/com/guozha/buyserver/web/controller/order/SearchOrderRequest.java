package com.guozha.buyserver.web.controller.order;

import com.guozha.buyserver.persistence.BaseConditionVO;

public class SearchOrderRequest extends BaseConditionVO{
	
	private Integer userId;
	private String searchType;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

}
