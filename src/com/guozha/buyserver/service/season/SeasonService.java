package com.guozha.buyserver.service.season;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.season.SeasonResponse;


/**
 * 节气食材
 * @Package com.guozha.buyserver.service.season
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-14 下午4:16:36
 */
public interface SeasonService extends BusinessObjectServiceMgr{
	/**
	 * 三节气食材
	 * @return
	 */
	List<SeasonResponse> find();
	
	/**
	 * 获得当前节气
	 * @return
	 */
	public SeasonResponse findCurr();
	
	

}
