package com.guozha.buyserver.web.controller.season;


import com.guozha.buyserver.persistence.beans.GooSeasonGoods;

public class SeasonResponse {
	
	private String season;
	private String seasonPicUrl;
	
	//private List<GoodsResponse> list = new ArrayList<GoodsResponse>(); 
	
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
	


}
