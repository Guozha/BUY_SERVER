package com.guozha.buyserver.service.search.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.service.search.SearchService;
import com.guozha.buyserver.web.controller.search.SearchRequest;
import com.guozha.buyserver.web.controller.search.SearchResponse;

/**
 * 搜索单元测试
 * @Package com.guozha.buyserver.service.search.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-27 下午2:37:17
 */
public class SearchServiceImplTest extends BaseJunitCase{
	
	@Autowired
    private SearchService searchService;  
	
	@Test
	public void testFind(){
		SearchRequest request = new SearchRequest();
		String word ="我们";
		assertNotNull("word is null", word);
		request.setWord(word);
		SearchResponse response = this.searchService.findGoodsAndMenu(request);
		assertNotNull("Response is null", response);
	}
}
