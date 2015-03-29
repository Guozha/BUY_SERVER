package com.guozha.buyserver.service.search.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.common.CommonService;
import com.guozha.buyserver.service.search.SearchService;
import com.guozha.buyserver.web.controller.goods.Goods;
import com.guozha.buyserver.web.controller.menuplan.MenuResponse;
import com.guozha.buyserver.web.controller.search.SearchRequest;
import com.guozha.buyserver.web.controller.search.SearchResponse;

@Transactional(rollbackFor = Exception.class)
@Service("searchService")
public class SearchServiceImpl  extends AbstractBusinessObjectServiceMgr implements SearchService {
   
	@Autowired
	private GooGoodsMapper gooGoodsMapper;
	@Autowired
	private MnuMenuMapper mnuMenuMapper;
	
	@Autowired
	private CommonService commonService;
	
	@Override
	public SearchResponse findGoodsAndMenu(SearchRequest vo) {
		SearchResponse response = new SearchResponse();
		System.out.println(vo.getWord());
		if(StringUtils.isEmpty(vo.getWord())){
			return response;
		}
		int marketId= this.commonService.getMaketId(vo.getAddressId());
		List<Goods> goodsList =this.gooGoodsMapper.findByOtherName(marketId, vo.getWord().trim());
		if(goodsList.isEmpty()){
			return response;
		}
		response.setGoodsList(goodsList);
		
		int [] goodsIds =new int[goodsList.size()];
		for(int i=0;i<goodsList.size();i++){
			goodsIds[i] = goodsList.get(i).getGoodsId();
		}
	    List<MnuMenu> menuList = this.mnuMenuMapper.findByGoodsIds(goodsIds);
	    for(MnuMenu po:menuList){
	    	MenuResponse menuResponse = new MenuResponse();
	    	menuResponse.setMenuId(po.getMenuId());
			menuResponse.setMenuName(po.getMenuName());
			menuResponse.setCookieWay(po.getCookieWay());
			menuResponse.setHardType(po.getHardType());
			menuResponse.setCookieTime(po.getCookieTime());
			menuResponse.setMenuImg(po.getMenuImg());
	    	response.getMenuList().add(menuResponse);
	    }
		return response;
	}
	
	public static void main(String[] args) {
		List<Goods> list = new ArrayList<Goods>();
		Goods g1 = new Goods();
		g1.setGoodsId(1);
		g1.setGoodsName("123");
		
		Goods g2 = new Goods();
		g2.setGoodsId(1);
		g2.setGoodsName("123");
		list.add(g1);
		list.add(g2);
		List<Integer> goodsIds = Arrays.asList(2);
		for(Integer s:goodsIds){
			System.out.println(s);
		}
		
	}

}
