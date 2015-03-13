package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 菜谱
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 上午11:00:24
 */
public class MnuMenu extends AbstractDO {
	
	private Integer menuId;
	private String menuName;
	private byte[] menuImg;
	
	private String menuDesc;
	private Integer cookieTime;

	private String cookieWay;
	private String cookieStep;
	private String seasonings;
	private String status;
	
	public String getSeasonings() {
		return seasonings;
	}
	public void setSeasonings(String seasonings) {
		this.seasonings = seasonings;
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
	public String getCookieStep() {
		return cookieStep;
	}
	public void setCookieStep(String cookieStep) {
		this.cookieStep = cookieStep;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
