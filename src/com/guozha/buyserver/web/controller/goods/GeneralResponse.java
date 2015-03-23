package com.guozha.buyserver.web.controller.goods;

import java.util.ArrayList;
import java.util.List;

public class GeneralResponse {
	
	private Integer pageCount;
	private List<FrontTypeResponse> frontTypeList= new ArrayList<FrontTypeResponse>();
	private List<Goods> goodsList = new ArrayList<Goods>();
	public List<Goods> getGoodsList() {
		return goodsList;
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
