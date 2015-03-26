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
	private byte[] firstMenuImg;
	private Integer secondMenuId;// 菜谱2
	private String secondMenuName;
	private byte[] secondMenuImg;
	private Integer thirdMenuId;// 菜谱3
	private String thirdMenuName;
	private byte[] thirdMenuImg;
	private Integer fourMenuId;// 菜谱4
	private String fourMenuName;
	private byte[] fourMenuImg;
	private Integer fiveMenuId;// 菜谱5
	private String fiveMenuName;
	private byte[] fiveMenuImg;
	private Integer sixMenuId;// 菜谱6
	private String sixMenuName;
	private byte[] sixMenuImg;
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
	public byte[] getFirstMenuImg() {
		return firstMenuImg;
	}
	public void setFirstMenuImg(byte[] firstMenuImg) {
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
	public byte[] getSecondMenuImg() {
		return secondMenuImg;
	}
	public void setSecondMenuImg(byte[] secondMenuImg) {
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
	public byte[] getThirdMenuImg() {
		return thirdMenuImg;
	}
	public void setThirdMenuImg(byte[] thirdMenuImg) {
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
	public byte[] getFourMenuImg() {
		return fourMenuImg;
	}
	public void setFourMenuImg(byte[] fourMenuImg) {
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
	public byte[] getFiveMenuImg() {
		return fiveMenuImg;
	}
	public void setFiveMenuImg(byte[] fiveMenuImg) {
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
	public byte[] getSixMenuImg() {
		return sixMenuImg;
	}
	public void setSixMenuImg(byte[] sixMenuImg) {
		this.sixMenuImg = sixMenuImg;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

}
