package com.guozha.buyserver.web.controller.goods;

public class FrontTypeResponse {
	
	    private Integer frontTypeId; //类目ID
	    private String shortName;    //类目简称
	    private Integer level;       //层级
	    
	    
	    
		public FrontTypeResponse(Integer frontTypeId, String shortName,Integer level) {
			super();
			this.frontTypeId = frontTypeId;
			this.shortName = shortName;
			this.level = level;
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

}
