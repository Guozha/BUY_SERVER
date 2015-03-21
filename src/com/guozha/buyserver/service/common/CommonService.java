package com.guozha.buyserver.service.common;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;

public interface CommonService extends BusinessObjectServiceMgr {
	
	String getPaperNo(String areaCode, String paperType);

}
