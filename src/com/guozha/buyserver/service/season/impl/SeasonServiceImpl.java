package com.guozha.buyserver.service.season.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.GooSeasonGoods;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.GooSeasonGoodsMapper;
import com.guozha.buyserver.service.season.SeasonService;
import com.guozha.buyserver.web.controller.season.SeasonGoodsResponse;
import com.guozha.buyserver.web.controller.season.SeasonResponse;

@Transactional(rollbackFor = Exception.class)
@Service("seasonService")
public class SeasonServiceImpl  extends AbstractBusinessObjectServiceMgr implements SeasonService{
    
	@Autowired
	private GooSeasonGoodsMapper gooSeasonGoodsMapper;
	
	@Autowired
	private GooGoodsMapper gooGoodsMapper;
	
	@Override
	public Map<SeasonResponse, List<SeasonGoodsResponse>> find() {
		String [] seasons={"01","02","03"};
		List<GooSeasonGoods> pos = this.gooSeasonGoodsMapper.findBySeason(seasons);
		
		Map<SeasonResponse, List<SeasonGoodsResponse>> map = new LinkedHashMap<SeasonResponse, List<SeasonGoodsResponse>>();
		List<SeasonGoodsResponse> bos = null;
		for(GooSeasonGoods po:pos){
			bos = new ArrayList<SeasonGoodsResponse>();
			List<GooGoods> goodsPos =gooGoodsMapper.findByIds(new int[]{po.getFirstGoodsId(),po.getSecondGoodsId(),po.getThirdGoodsId(),po.getFourGoodsId(),po.getFiveGoodsId()});
            for(GooGoods goodsPo:goodsPos){
            	bos.add(new SeasonGoodsResponse(goodsPo));
            }
			map.put(new SeasonResponse(po), bos);
		}
		return map;
	}
	
	/*
	public List<SeasonResponse> finds() {
		String [] seasons={"01","02","03"};
		List<GooSeasonGoods> pos = this.gooSeasonGoodsMapper.findBySeason(seasons);
		
		List<SeasonResponse> list = new ArrayList<SeasonResponse>();
		for(GooSeasonGoods po:pos){
			SeasonResponse  sp  = new SeasonResponse(po);
			List<GoodsResponse> bos = new ArrayList<GoodsResponse>();
			List<GooGoods> goodsPos =gooGoodsMapper.findByIds(new int[]{po.getFirstGoodsId(),po.getSecondGoodsId(),po.getThirdGoodsId(),po.getFourGoodsId(),po.getFiveGoodsId()});
			for(GooGoods goodsPo:goodsPos){
            	bos.add(new GoodsResponse(goodsPo));
            }
			
			sp.setList(bos);
			list.add(sp);
		
		}
		return list;
	}
    */
}
