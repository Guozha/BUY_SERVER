package com.guozha.buyserver.web.controller.order;

import java.util.List;

import com.guozha.buyserver.persistence.beans.BuyOrder;

public class SearchOrderResponse {
	
	private Integer totalCount;
	private Integer pageCount;
	private List<BuyOrder> buyOrderList;
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<BuyOrder> getBuyOrderList() {
		return buyOrderList;
	}
	public void setBuyOrderList(List<BuyOrder> buyOrderList) {
		this.buyOrderList = buyOrderList;
	}
	

}
