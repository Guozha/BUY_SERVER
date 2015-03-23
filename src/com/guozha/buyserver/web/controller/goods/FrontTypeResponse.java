package com.guozha.buyserver.web.controller.goods;

import java.util.ArrayList;
import java.util.List;

import com.guozha.buyserver.persistence.beans.BasFrontType;

public class FrontTypeResponse {
	
	    private Integer frontTypeId; //类目ID
	    private String typeName;     //类目名称
	    private String shortName;    //类目简称
	    
	    private List<FrontTypeResponse> frontTypeList;
	    
	    private List<Goods> goodsList = new ArrayList<Goods>();
	
	  
		public FrontTypeResponse() {
			
		}
		public FrontTypeResponse(BasFrontType po) {
			super();
			this.frontTypeId = po.getFrontTypeId();
			this.typeName = po.getTypeName();
			this.shortName = po.getShortName();
			
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
		public String getTypeName() {
			return typeName;
		}
		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}
		  public List<Goods> getGoodsList() {
				return goodsList;
			}
			public void setGoodsList(List<Goods> goodsList) {
				this.goodsList = goodsList;
			}

}
