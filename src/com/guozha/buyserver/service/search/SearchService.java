package com.guozha.buyserver.service.search;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.search.SearchRequest;
import com.guozha.buyserver.web.controller.search.SearchResponse;

/**
 * 搜索service
 * @Package com.guozha.buyserver.service.search
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-24 下午3:00:13
 */
public interface SearchService extends BusinessObjectServiceMgr{
	
	/**
	 * 关键字查询商品和菜谱信息
	 * @param word
	 * @return
	 */
	SearchResponse findGoodsAndMenu(SearchRequest vo);

}
