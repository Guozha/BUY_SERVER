package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class AccMyFavoDetail extends AbstractDO {
	
	private Integer myFavoDetailId;
	private Integer myFavoId;
	private Integer menuId;
	private Integer sort;
	
	public Integer getMyFavoDetailId() {
		return myFavoDetailId;
	}
	public void setMyFavoDetailId(Integer myFavoDetailId) {
		this.myFavoDetailId = myFavoDetailId;
	}
	public Integer getMyFavoId() {
		return myFavoId;
	}
	public void setMyFavoId(Integer myFavoId) {
		this.myFavoId = myFavoId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
