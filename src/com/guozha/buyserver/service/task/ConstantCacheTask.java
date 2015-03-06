package com.guozha.buyserver.service.task;

import com.guozha.buyserver.service.common.CacheServiceMgr;
import com.guozha.buyserver.framework.sys.business.BusinessFactory;

public class ConstantCacheTask implements Runnable {

	@Override
	public void run() {
		System.out.println("Start ConstantCacheTask...");
		
		CacheServiceMgr cacheMgr = BusinessFactory.getInstance().getService("cacheServiceMgr");
		cacheMgr.cacheConstantData();
		
	}

}
