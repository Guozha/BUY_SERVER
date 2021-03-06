package com.guozha.buyserver.web.controller.menuplan;

import java.util.Date;

/**
 * 菜谱计划请求参数
 * 
 * @author sunhanbin
 * @date 2015-03-15
 * 
 */
public class MenuUserPlanRequest {

	private Integer userId;// 用户ID
	private Integer firstMenuId;// 菜谱1
	private Integer secondMenuId;// 菜谱2
	private Integer thirdMenuId;// 菜谱3
	private Integer fourMenuId;// 菜谱4
	private Integer fiveMenuId;// 菜谱5
	private Integer sixMenuId;// 菜谱6
	private String planDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

}
