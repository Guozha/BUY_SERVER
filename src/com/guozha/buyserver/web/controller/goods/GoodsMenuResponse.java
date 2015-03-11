package com.guozha.buyserver.web.controller.goods;

import com.guozha.buyserver.persistence.beans.MnuMenu;

public class GoodsMenuResponse {
	
	private Integer menuId;
	private String menuName;
	private String menuUrl;
	private String menuDesc;
	private Integer useTime;
	private String cookieWay;
	private String cookieStep;
	private String seasonings;
	
	
	public GoodsMenuResponse(MnuMenu po){
		this.menuId = po.getMenuId();
		this.menuName = po.getMenuName();
		this.menuUrl = po.getMenuUrl();
		this.menuDesc = po.getMenuDesc();
		this.useTime = po.getUseTime();
		this.cookieWay = po.getCookieWay();
		this.cookieStep = po.getCookieStep();
		this.seasonings = po.getSeasonings();
	}
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuDesc() {
		return menuDesc;
	}
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}
	public Integer getUseTime() {
		return useTime;
	}
	public void setUseTime(Integer useTime) {
		this.useTime = useTime;
	}
	public String getCookieWay() {
		return cookieWay;
	}
	public void setCookieWay(String cookieWay) {
		this.cookieWay = cookieWay;
	}
	public String getCookieStep() {
		return cookieStep;
	}
	public void setCookieStep(String cookieStep) {
		this.cookieStep = cookieStep;
	}

	public String getSeasonings() {
		return seasonings;
	}
	public void setSeasonings(String seasonings) {
		this.seasonings = seasonings;
	}
}
