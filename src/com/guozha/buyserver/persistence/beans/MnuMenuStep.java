package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: 菜谱步骤表
 * @author sunhanbin
 * @date 2015-3-20 下午02:09:14
 */
public class MnuMenuStep extends AbstractDO{
	
	
	private Integer menuStepId;//步骤ID
	private Integer menuId;//菜谱ID
	private String stepDesc;//步骤描述
	private String stepImg;//步骤图片
	private Integer sortFlag;//排序
	
	public Integer getMenuStepId() {
		return menuStepId;
	}
	public void setMenuStepId(Integer menuStepId) {
		this.menuStepId = menuStepId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getStepImg() {
		return stepImg;
	}
	public void setStepImg(String stepImg) {
		this.stepImg = stepImg;
	}
	public Integer getSortFlag() {
		return sortFlag;
	}
	public void setSortFlag(Integer sortFlag) {
		this.sortFlag = sortFlag;
	}
	public String getStepDesc() {
		return stepDesc;
	}
	public void setStepDesc(String stepDesc) {
		this.stepDesc = stepDesc;
	}
	
}
