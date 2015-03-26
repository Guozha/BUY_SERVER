package com.guozha.buyserver.web.controller.season;


import java.util.ArrayList;
import java.util.List;

import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.GooSeasonGoods;

public class SeasonResponse {
	
	private String season;
	private String seasonPicUrl;
	private List<SeasonGoods> goodsList = new ArrayList<SeasonGoods>(); 
	

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
	
	public List<SeasonGoods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GooGoods> goodsList) {
		for(GooGoods goodsPo:goodsList){
			this.goodsList.add(new SeasonGoods(goodsPo));
        }
	}

}
