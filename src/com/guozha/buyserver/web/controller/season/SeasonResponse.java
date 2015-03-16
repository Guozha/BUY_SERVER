package com.guozha.buyserver.web.controller.season;


import java.util.List;

import com.guozha.buyserver.persistence.beans.GooSeasonGoods;
import com.guozha.buyserver.web.controller.goods.GoodsResponse;

public class SeasonResponse {
	
	private String season;
	private String seasonPicUrl;
	private List<SeasonGoodsResponse> goodsList; 
	

	public SeasonResponse(GooSeasonGoods po) {
		super();
		this.season = po.getSeason();
		this.seasonPicUrl = po.getSeasonPicUrl();
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getSeasonPicUrl() {
		return seasonPicUrl;
	}
	public void setSeasonPicUrl(String seasonPicUrl) {
		this.seasonPicUrl = seasonPicUrl;
	}
	
	public List<SeasonGoodsResponse> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<SeasonGoodsResponse> goodsList) {
		this.goodsList = goodsList;
	}

}