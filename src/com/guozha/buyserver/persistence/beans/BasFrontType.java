package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO(前台类目)
 * @author txf
 * @date 2015-3-10 下午1:18:41
 */
public class BasFrontType extends AbstractDO{
    private Integer frontTypeId; //类目ID
    private String typeName;     //类目名称
    private String shortName;    //类目简称
    private Integer level;       //层级
    private Integer sort;        //排序
    private Integer parentId;    //父类目ID
    private String status;       //类目状态 （参考constant.xml)
    
	public Integer getFrontTypeId() {
		return frontTypeId;
	}
	public void setFrontTypeId(Integer frontTypeId) {
		this.frontTypeId = frontTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
