package com.guozha.buyserver.persistence.beans;

import java.util.Date;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 菜谱计划
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 下午5:27:59
 */
public class MnuMenuPlan extends AbstractDO {
	private Integer menuPlanId;
	private Date planDate;
	private String dayDesc;
	private Integer firstMenuId;
	private Integer secondMenuId;
	private Integer thirdMenuId;
	private Integer fourMenuId;
	private Integer fiveMenuId;
	public Integer getMenuPlanId() {
		return menuPlanId;
	}
	public void setMenuPlanId(Integer menuPlanId) {
		this.menuPlanId = menuPlanId;
	}
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	public String getDayDesc() {
		return dayDesc;
	}
	public void setDayDesc(String dayDesc) {
		this.dayDesc = dayDesc;
	}
	public Integer getFirstMenuId() {
		return firstMenuId;
	}
	public void setFirstMenuId(Integer firstMenuId) {
		this.firstMenuId = firstMenuId;
	}
	public Integer getSecondMenuId() {
		return secondMenuId;
	}
	public void setSecondMenuId(Integer secondMenuId) {
		this.secondMenuId = secondMenuId;
	}
	public Integer getThirdMenuId() {
		return thirdMenuId;
	}
	public void setThirdMenuId(Integer thirdMenuId) {
		this.thirdMenuId = thirdMenuId;
	}
	public Integer getFourMenuId() {
		return fourMenuId;
	}
	public void setFourMenuId(Integer fourMenuId) {
		this.fourMenuId = fourMenuId;
	}
	public Integer getFiveMenuId() {
		return fiveMenuId;
	}
	public void setFiveMenuId(Integer fiveMenuId) {
		this.fiveMenuId = fiveMenuId;
	}
	
	
	

}
