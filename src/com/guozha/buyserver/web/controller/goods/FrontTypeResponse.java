package com.guozha.buyserver.web.controller.goods;

import com.guozha.buyserver.persistence.beans.BasFrontType;

public class FrontTypeResponse {
	
	    private String frontTypeId; //类目ID
	    private String shortName;    //类目简称
	    private String level;       //层级
	    
	    
	    
		public FrontTypeResponse(BasFrontType po) {
			super();
			this.frontTypeId = po.getFrontTypeId().toString();
			this.shortName = po.getShortName();
			this.level = po.getLevel().toString();
		}
		public String getFrontTypeId() {
			return frontTypeId;
		}
		public void setFrontTypeId(String frontTypeId) {
			this.frontTypeId = frontTypeId;
		}
		public String getShortName() {
			return shortName;
		}
		public void setShortName(String shortName) {
			this.shortName = shortName;
		}
		public String getLevel() {
			return level;
		}
		public void setLevel(String level) {
			this.level = level;
		}

}
