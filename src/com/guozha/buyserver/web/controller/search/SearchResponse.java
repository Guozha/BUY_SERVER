package com.guozha.buyserver.web.controller.search;

import java.util.ArrayList;
import java.util.List;

import com.guozha.buyserver.web.controller.goods.Goods;
import com.guozha.buyserver.web.controller.menuplan.MenuResponse;

/**
 * 搜索查询返回参数
 * @Package com.guozha.buyserver.web.controller.search
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-24 下午3:02:26
 */
public class SearchResponse {
	private List<Goods> goodsList = new ArrayList<Goods>();
	private List<MenuResponse> menuList = new ArrayList<MenuResponse>();
	public List<MenuResponse> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<MenuResponse> menuList) {
		this.menuList = menuList;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
}
