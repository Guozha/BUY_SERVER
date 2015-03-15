package com.guozha.buyserver.web.controller.goods;

import java.util.ArrayList;
import java.util.List;

import com.guozha.buyserver.persistence.beans.BasFrontType;

public class FrontTypeResponse {
	
	    private Integer frontTypeId; //类目ID
	    private String typeName;     //类目名称
	    private String shortName;    //类目简称
	    private Integer level;       //层级
	    
	    private List<FrontTypeResponse> frontTypeList;
	
		
		public FrontTypeResponse(BasFrontType po) {
			super();
			this.frontTypeId = po.getFrontTypeId();
			this.typeName = po.getTypeName();
			this.shortName = po.getShortName();
			this.level = po.getLevel();
			
		}
		

		public List<FrontTypeResponse> getFrontTypeList() {
			return frontTypeList;
		}
		public void setFrontTypeList(List<FrontTypeResponse> frontTypeList) {
			this.frontTypeList = frontTypeList;
		}
		public Integer getFrontTypeId() {
			return frontTypeId;
		}
		public void setFrontTypeId(Integer frontTypeId) {
			this.frontTypeId = frontTypeId;
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
		public String getTypeName() {
			return typeName;
		}
		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}

}
