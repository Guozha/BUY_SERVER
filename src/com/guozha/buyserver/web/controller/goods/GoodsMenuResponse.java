package com.guozha.buyserver.web.controller.goods;

import com.guozha.buyserver.persistence.beans.MnuMenu;

public class GoodsMenuResponse {
	
	private Integer menuId;
	private String menuName;
	private byte[] menuImg;
	private String menuDesc;
	private Integer useTime;
	private String cookieWay;
	private String cookieStep;
	private String seasonings;
	
	
	public GoodsMenuResponse(MnuMenu po){
		this.menuId = po.getMenuId();
		this.menuName = po.getMenuName();
		this.menuImg = po.getMenuImg();
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
	public byte[] getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(byte[] menuImg) {
		this.menuImg = menuImg;
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
