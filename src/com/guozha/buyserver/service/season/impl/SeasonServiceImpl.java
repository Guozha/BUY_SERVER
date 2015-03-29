package com.guozha.buyserver.service.season.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.GooSeasonGoods;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.GooSeasonConfigMapper;
import com.guozha.buyserver.persistence.mapper.GooSeasonGoodsMapper;
import com.guozha.buyserver.service.season.SeasonService;
import com.guozha.buyserver.web.controller.season.SeasonResponse;

@Transactional(rollbackFor = Exception.class)
@Service("seasonService")
public class SeasonServiceImpl  extends AbstractBusinessObjectServiceMgr implements SeasonService{
    
	@Autowired
	private GooSeasonGoodsMapper gooSeasonGoodsMapper;
	
	@Autowired
	private GooGoodsMapper gooGoodsMapper;
	
	@Autowired
	private GooSeasonConfigMapper gooSeasonConfigMapper;
	
	public List<SeasonResponse> find() {
		String [] seasons=this.gooSeasonConfigMapper.loadBySystemDate(new Date()).split(",");
		
		GooSeasonGoods before=null;
		GooSeasonGoods curr=null;
		GooSeasonGoods after=null;
		
		List<GooSeasonGoods> pos = this.gooSeasonGoodsMapper.findBySeason(seasons);
		
		for(int i=0;i<pos.size();i++){
			GooSeasonGoods po = pos.get(i);
			if(po.getSeason().equals(seasons[0])){
				before = po;
			}else if(po.getSeason().equals(seasons[1])){
				curr = po;
			}else if(po.getSeason().equals(seasons[2])){
				after = po;
			}
		}
		
		List<SeasonResponse> response = new ArrayList<SeasonResponse>();
		
		//上一节气
		SeasonResponse  beforeResponse  = new SeasonResponse(before);
		beforeResponse.setGoodsList(gooGoodsMapper.findByIds(getGoodsIds(before)));
		response.add(beforeResponse);
		
		//当前节气
		SeasonResponse  currResponse  = new SeasonResponse(before);
		currResponse.setGoodsList(gooGoodsMapper.findByIds(getGoodsIds(curr)));
		response.add(currResponse);
		
		//下一节气
		SeasonResponse afterResponse  = new SeasonResponse(before);
		afterResponse.setGoodsList(gooGoodsMapper.findByIds(getGoodsIds(after)));
		response.add(afterResponse);
		
		
		/*
		List<SeasonResponse> list = new ArrayList<SeasonResponse>();
		for(int i=0;i<pos.size();i++){
			GooSeasonGoods po = pos.get(i);
			SeasonResponse  sp  = new SeasonResponse(po);
			List<SeasonGoodsResponse> bos = new ArrayList<SeasonGoodsResponse>();
			List<GooGoods> goodsPos =gooGoodsMapper.findByIds(new int[]{po.getFirstGoodsId(),po.getSecondGoodsId(),po.getThirdGoodsId(),po.getFourGoodsId(),po.getFiveGoodsId()});
			for(GooGoods goodsPo:goodsPos){
            	bos.add(new SeasonGoodsResponse(goodsPo));
            }
			sp.setGoodsList(bos);
			list.add(sp);
		
		}*/
		return response;
	}
	

	@Override
	public SeasonResponse findCurr() {
		String [] seasons=this.gooSeasonConfigMapper.loadBySystemDate(new Date()).split(",");
		GooSeasonGoods pos = this.gooSeasonGoodsMapper.findBySeason(new String[]{seasons[1]}).get(0);
		SeasonResponse response  = new SeasonResponse(pos);
		response.setGoodsList(null);
		return response;
	}
	
	/**
	 * 获取食材id数组
	 * @param po
	 * @return
	 */
	private int [] getGoodsIds(GooSeasonGoods po){
		return new int[]{po.getFirstGoodsId(),po.getSecondGoodsId(),po.getThirdGoodsId(),po.getFourGoodsId(),po.getFiveGoodsId()};
	}

   
}
