package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class AccMyFavo extends AbstractDO {
	
	private Integer myFavoId;
	private Integer userId;
	private String dirFlag;
	private Integer menuId;
	private String favoName;
	private Integer parentId;
	
	public Integer getMyFavoId() {
		return myFavoId;
	}
	public void setMyFavoId(Integer myFavoId) {
		this.myFavoId = myFavoId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getDirFlag() {
		return dirFlag;
	}
	public void setDirFlag(String dirFlag) {
		this.dirFlag = dirFlag;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
