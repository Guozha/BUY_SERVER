package com.guozha.buyserver.service.common;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;

public interface CacheServiceMgr extends BusinessObjectServiceMgr {
	
	void cacheConstantData();
	
}
