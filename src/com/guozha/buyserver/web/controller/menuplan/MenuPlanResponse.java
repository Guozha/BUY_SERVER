package com.guozha.buyserver.web.controller.menuplan;

/**
 * @Package com.guozha.buyserver.web.controller.menuplan
 * @Description: 菜谱计划推荐返回报文
 * @author sunhanbin
 * @date 2015-3-16 下午04:42:29
 */
public class MenuPlanResponse implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Integer firstMenuId;// 菜谱1
	private String firstMenuName;
	private String firstMenuImg;
	private Integer secondMenuId;// 菜谱2
	private String secondMenuName;
	private String secondMenuImg;
	private Integer thirdMenuId;// 菜谱3
	private String thirdMenuName;
	private String thirdMenuImg;
	private Integer fourMenuId;// 菜谱4
	private String fourMenuName;
	private String fourMenuImg;
	private Integer fiveMenuId;// 菜谱5
	private String fiveMenuName;
	private String fiveMenuImg;
	private Integer sixMenuId;// 菜谱6
	private String sixMenuName;
	private String sixMenuImg;
	private String planDate;
	
	public Integer getFirstMenuId() {
		return firstMenuId;
	}
	public void setFirstMenuId(Integer firstMenuId) {
		this.firstMenuId = firstMenuId;
	}
	public String getFirstMenuName() {
		return firstMenuName;
	}
	public void setFirstMenuName(String firstMenuName) {
		this.firstMenuName = firstMenuName;
	}
	public String getFirstMenuImg() {
		return firstMenuImg;
	}
	public void setFirstMenuImg(String firstMenuImg) {
		this.firstMenuImg = firstMenuImg;
	}
	public Integer getSecondMenuId() {
		return secondMenuId;
	}
	public void setSecondMenuId(Integer secondMenuId) {
		this.secondMenuId = secondMenuId;
	}
	public String getSecondMenuName() {
		return secondMenuName;
	}
	public void setSecondMenuName(String secondMenuName) {
		this.secondMenuName = secondMenuName;
	}
	public String getSecondMenuImg() {
		return secondMenuImg;
	}
	public void setSecondMenuImg(String secondMenuImg) {
		this.secondMenuImg = secondMenuImg;
	}
	public Integer getThirdMenuId() {
		return thirdMenuId;
	}
	public void setThirdMenuId(Integer thirdMenuId) {
		this.thirdMenuId = thirdMenuId;
	}
	public String getThirdMenuName() {
		return thirdMenuName;
	}
	public void setThirdMenuName(String thirdMenuName) {
		this.thirdMenuName = thirdMenuName;
	}
	public String getThirdMenuImg() {
		return thirdMenuImg;
	}
	public void setThirdMenuImg(String thirdMenuImg) {
		this.thirdMenuImg = thirdMenuImg;
	}
	public Integer getFourMenuId() {
		return fourMenuId;
	}
	public void setFourMenuId(Integer fourMenuId) {
		this.fourMenuId = fourMenuId;
	}
	public String getFourMenuName() {
		return fourMenuName;
	}
	public void setFourMenuName(String fourMenuName) {
		this.fourMenuName = fourMenuName;
	}
	public String getFourMenuImg() {
		return fourMenuImg;
	}
	public void setFourMenuImg(String fourMenuImg) {
		this.fourMenuImg = fourMenuImg;
	}
	public Integer getFiveMenuId() {
		return fiveMenuId;
	}
	public void setFiveMenuId(Integer fiveMenuId) {
		this.fiveMenuId = fiveMenuId;
	}
	public String getFiveMenuName() {
		return fiveMenuName;
	}
	public void setFiveMenuName(String fiveMenuName) {
		this.fiveMenuName = fiveMenuName;
	}
	public String getFiveMenuImg() {
		return fiveMenuImg;
	}
	public void setFiveMenuImg(String fiveMenuImg) {
		this.fiveMenuImg = fiveMenuImg;
	}
	public Integer getSixMenuId() {
		return sixMenuId;
	}
	public void setSixMenuId(Integer sixMenuId) {
		this.sixMenuId = sixMenuId;
	}
	public String getSixMenuName() {
		return sixMenuName;
	}
	public void setSixMenuName(String sixMenuName) {
		this.sixMenuName = sixMenuName;
	}
	public String getSixMenuImg() {
		return sixMenuImg;
	}
	public void setSixMenuImg(String sixMenuImg) {
		this.sixMenuImg = sixMenuImg;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

}
