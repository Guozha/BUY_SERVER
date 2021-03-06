package com.guozha.buyserver.web.controller.goods;

import java.util.ArrayList;
import java.util.List;

public class GeneralResponse {
	
	private Integer pageCount;
	private Integer totalCount;
	private Integer pageSize;
	private Integer pageNum;

	private List<FrontTypeResponse> frontTypeList= new ArrayList<FrontTypeResponse>();
	private List<Goods> goodsList = new ArrayList<Goods>();
	

	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<FrontTypeResponse> getFrontTypeList() {
		return frontTypeList;
	}
	public void setFrontTypeList(List<FrontTypeResponse> frontTypeList) {
		this.frontTypeList = frontTypeList;
	}

}
