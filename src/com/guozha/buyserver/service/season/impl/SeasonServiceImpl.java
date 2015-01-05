package com.guozha.buyserver.service.season.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.GooSeasonGoods;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.GooSeasonGoodsMapper;
import com.guozha.buyserver.service.season.SeasonService;
import com.guozha.buyserver.web.controller.goods.GoodsResponse;

@Transactional(rollbackFor = Exception.class)
@Service("seasonService")
public class SeasonServiceImpl  extends AbstractBusinessObjectServiceMgr implements SeasonService{
    
	@Autowired
	private GooSeasonGoodsMapper gooSeasonGoodsMapper;
	
	@Autowired
	private GooGoodsMapper gooGoodsMapper;
	
	@Override
	public Map<String, List<GoodsResponse>> find() {
		String [] seasons={"01","02","03"};
		List<GooSeasonGoods> pos = this.gooSeasonGoodsMapper.findBySeason(seasons);
		
		Map<String, List<GoodsResponse>> map = new TreeMap<String, List<GoodsResponse>>();
		List<GoodsResponse> bos = null;
		for(GooSeasonGoods po:pos){
			bos = new ArrayList<GoodsResponse>();
			List<GooGoods> goodsPos =gooGoodsMapper.findByIds(new int[]{po.getFirstGoodsId(),po.getSecondGoodsId(),po.getThirdGoodsId(),po.getFourGoodsId(),po.getFiveGoodsId()});
            for(GooGoods goodsPo:goodsPos){
            	bos.add(new GoodsResponse(goodsPo));
            }
			if(map.containsKey(po.getSeason())){
				map.get(po.getSeason()).addAll(bos);
			}else{
				map.put(po.getSeason(), bos);
			}
		}
		return map;
	}

}
