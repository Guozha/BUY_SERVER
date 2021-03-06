package com.guozha.buyserver.web.controller.menuplan;

import java.util.List;

import com.guozha.buyserver.persistence.beans.MnuMenuGoods;
import com.guozha.buyserver.persistence.beans.MnuMenuStep;

/**
 * @Package com.guozha.buyserver.web.controller.menuplan
 * @Description: 菜票推荐返回报文
 * @author sunhanbin
 * @date 2015-3-19 下午03:01:34
 */
public class MenuResponse {

	private Integer menuId;// 菜谱ID
	private String menuName;// 菜谱名称
	private String menuImg;// 菜谱图片
	private String menuDesc;// 菜谱描述
	private Integer cookieTime;// 烹饪时间
	private String cookieWay;// 制作方式
	private String seasonings="";// 调料
	private String hardType;// 难易程度：1-简单;2-中等;3-困难
	private List<MnuMenuStep> muenSteps;// 做菜步骤
	private List<MnuMenuGoods> menuGoods;//食材

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

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
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

	public String getSeasonings() {
		return seasonings;
	}

	public void setSeasonings(String seasonings) {
		this.seasonings = seasonings;
	}

	public String getHardType() {
		return hardType;
	}

	public void setHardType(String hardType) {
		this.hardType = hardType;
	}

	public List<MnuMenuStep> getMuenSteps() {
		return muenSteps;
	}

	public void setMuenSteps(List<MnuMenuStep> muenSteps) {
		this.muenSteps = muenSteps;
	}

	public List<MnuMenuGoods> getMenuGoods() {
		return menuGoods;
	}

	public void setMenuGoods(List<MnuMenuGoods> menuGoods) {
		this.menuGoods = menuGoods;
	}

}
