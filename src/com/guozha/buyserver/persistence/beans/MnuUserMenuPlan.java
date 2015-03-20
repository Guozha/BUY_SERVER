/**
 * 
 */
package com.guozha.buyserver.persistence.beans;

import java.util.Date;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO
 * @author sunhanbin
 * @date 2015-3-19 下午12:53:08
 */
public class MnuUserMenuPlan extends AbstractDO {

	private Integer userMenuPlanId;
	private Integer userId;
	private Date planDate;
	private Integer firstMenuId;
	private Integer secondMenuId;
	private Integer thirdMenuId;
	private Integer fourMenuId;
	private Integer fiveMenuId;
	private Integer sixMenuId;
	
	public Integer getUserMenuPlanId() {
		return userMenuPlanId;
	}
	public void setUserMenuPlanId(Integer userMenuPlanId) {
		this.userMenuPlanId = userMenuPlanId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
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
	public Integer getSixMenuId() {
		return sixMenuId;
	}
	public void setSixMenuId(Integer sixMenuId) {
		this.sixMenuId = sixMenuId;
	}

}
