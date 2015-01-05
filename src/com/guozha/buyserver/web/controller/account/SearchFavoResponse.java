package com.guozha.buyserver.web.controller.account;


public class SearchFavoResponse {
	
	private Integer myFavoId;
	private String dirFlag;
	private Integer menuId;
	private String favoName;
	private byte[] menuImg;
	private Integer cookieTime;
	private String cookieWay;
	
	public Integer getMyFavoId() {
		return myFavoId;
	}
	public void setMyFavoId(Integer myFavoId) {
		this.myFavoId = myFavoId;
	}
	public String getDirFlag() {
		return dirFlag;
	}
	public void setDirFlag(String dirFlag) {
		this.dirFlag = dirFlag;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getFavoName() {
		return favoName;
	}
	public void setFavoName(String favoName) {
		this.favoName = favoName;
	}
	public byte[] getMenuImg() {
		return menuImg;
	}
	public void setMenuImg(byte[] menuImg) {
		this.menuImg = menuImg;
	}
	public Integer getCookieTime() {
		return cookieTime;
	}
	public void setCookieTime(Integer cookieTime) {
		this.cookieTime = cookieTime;
	}
	public String getCookieWay() {
		return cookieWay;
	}
	public void setCookieWay(String cookieWay) {
		this.cookieWay = cookieWay;
	}

}
