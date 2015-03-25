package com.guozha.buyserver.web.controller.search;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.search.SearchService;
import com.guozha.buyserver.web.controller.BaseController;

/**
 * 搜索
 * @Package com.guozha.buyserver.web.controller.search
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-24 下午2:59:58
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController extends BaseController {
	
	@Autowired
	private SearchService searchService;
	
	/**
	 * 关键字查询商品和菜谱
	 * @param vo
	 * @param response
	 */
	@RequestMapping(value="")
	public void search(SearchRequest vo,HttpServletResponse response){
		responseJson(searchService.findGoodsAndMenu(vo), response);
	}

}
