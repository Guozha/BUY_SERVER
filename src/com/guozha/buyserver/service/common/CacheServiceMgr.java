package com.guozha.buyserver.service.common;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;

public interface CacheServiceMgr extends BusinessObjectServiceMgr {
	
	void cacheConstantData();
	
	/**
	 * 商品价格缓存
	 */
	void cacheGoodsPriceData();
	
}
