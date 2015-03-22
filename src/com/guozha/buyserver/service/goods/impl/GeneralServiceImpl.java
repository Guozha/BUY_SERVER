package com.guozha.buyserver.service.goods.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.PriceUtils;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BasFrontType;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.GooGoodsAmount;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.mapper.BasFrontTypeMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsAmountMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.goods.GeneralService;
import com.guozha.buyserver.service.goods.GoodsBo;
import com.guozha.buyserver.service.market.MarketService;
import com.guozha.buyserver.web.controller.goods.FrontTypeRequest;
import com.guozha.buyserver.web.controller.goods.FrontTypeResponse;
import com.guozha.buyserver.web.controller.goods.GoodsInfoResponse;
import com.guozha.buyserver.web.controller.goods.GoodsMenuResponse;
import com.guozha.buyserver.web.controller.goods.GoodsPriceResponse;
import com.guozha.buyserver.web.controller.goods.GoodsRequest;
import com.guozha.buyserver.web.controller.goods.GoodsResponse;


@Transactional(rollbackFor = Exception.class)
@Service("generalService")
public class GeneralServiceImpl extends AbstractBusinessObjectServiceMgr implements GeneralService {
    
	@Autowired
	private BasFrontTypeMapper basFrontTypeMapper;
	@Autowired
	private GooGoodsMapper gooGoodsMapper;
	@Autowired
	private GooGoodsAmountMapper gooGoodsAmountMapper;
	@Autowired
	private MnuMenuMapper mnuMenuMapper;
	
	@Autowired
	private MarMarketGoodsMapper marMarketGoodsMapper;
	
	@Autowired
	private MarketService marketService;
    
	
	@Override
	public List<FrontTypeResponse> findFrontType(FrontTypeRequest vo) {
		List<BasFrontType> pos = null==vo.getFrontTypeId()?basFrontTypeMapper.findFirst():basFrontTypeMapper.findSecond(vo.getFrontTypeId());
		List<FrontTypeResponse> bos = new ArrayList<FrontTypeResponse>();
		for(BasFrontType po:pos){
			bos.add(new FrontTypeResponse(po));
		}
		return bos;
	}
	
	@Override
	public List<FrontTypeResponse> findFrontType() {
		List<BasFrontType> firstPos = this.basFrontTypeMapper.findFirst();
		List<FrontTypeResponse>  list1 = new ArrayList<FrontTypeResponse>();
		for(BasFrontType po:firstPos){
			List<FrontTypeResponse> list2 = new ArrayList<FrontTypeResponse>();
			List<BasFrontType> secondPos = basFrontTypeMapper.findSecond(po.getFrontTypeId());
			for(BasFrontType secondPo:secondPos){
				list2.add(new FrontTypeResponse(secondPo));
			}
			FrontTypeResponse f = new FrontTypeResponse(po);
			f.setFrontTypeList(list2);
			list1.add(f);
		}
		return list1;
	}
	
	@Override
	public List<GoodsResponse> findGoods(GoodsRequest vo) {
		int marketId= this.marketService.findMaketId(vo.getAddressId());
	    List<GoodsResponse> response = new ArrayList<GoodsResponse>();
		List<BasFrontType> frontTypeList = this.basFrontTypeMapper.findFirstPager(vo.getStartIndex(), vo.getPageSize()/6);
		for(BasFrontType frontType:frontTypeList){
			GoodsResponse goodsResponse = new GoodsResponse();
			goodsResponse.getFrontType().setFrontTypeId(vo.getFrontTypeId());
			goodsResponse.getFrontType().setShortName(frontType.getShortName());
			goodsResponse.getFrontType().setTypeName(frontType.getTypeName());
			goodsResponse.setGoodsList(this.gooGoodsMapper.findLimit6ByFirstFrontTypeId(marketId, vo.getFrontTypeId()));
			response.add(goodsResponse);
		}
		return response;
	}
	
	
	public List<GoodsResponse> findGoodsByFrontTypeId(GoodsRequest vo){
		int marketId= this.marketService.findMaketId(vo.getAddressId());
		BasFrontType bft = this.basFrontTypeMapper.load(vo.getFrontTypeId());
		List<GoodsResponse> response = null;
		switch (bft.getLevel()) {
		case 1: //一级类目商品
			response = this.gooGoodsMapper.findPagerByFirstFrontTypeId(marketId, vo.getFrontTypeId(), vo.getStartIndex(), vo.getPageSize());
			break;
		case 2: //二级类目商品
			response = this.gooGoodsMapper.findPagerBySecondFrontTypeId(marketId, vo.getFrontTypeId(), vo.getStartIndex(), vo.getPageSize());
			break;
		}
		return response;
	}
	
	/*
	@Override
	public List<GoodsResponse> findGoods(GoodsRequest vo) {
		int marketId= this.marketService.findMaketId(vo.getAddressId());
		
		
		List<GoodsResponse> response = null;
		Integer frontTypeId = vo.getFrontTypeId();
		List<GoodsBo> list = null;
		if(frontTypeId==null){
			List<GoodsBo> goodsBoList = this.gooGoodsMapper.findByMarketId(marketId);
			Map<Integer,List<GoodsBo>> map = new LinkedHashMap<Integer, List<GoodsBo>>();
			for(GoodsBo bo: goodsBoList){
				if(map.containsKey(bo.getFrontTypeId())){
					map.get(bo.getFrontTypeId()).add(bo);
				}else{
					list = new ArrayList<GoodsBo>();
					list.add(bo);
					map.put(bo.getFrontTypeId(), list);
				}
			}
			goodsBoList = null;
			
			response = new ArrayList<GoodsResponse>();
			
			for(int key:map.keySet()){
				GoodsResponse goods = new GoodsResponse();
				BasFrontType frontType = this.basFrontTypeMapper.load(key);
				goods.getFrontType().setFrontTypeId(key);
				goods.getFrontType().setTypeName(frontType.getTypeName());
				goods.getFrontType().setShortName(frontType.getShortName());
				
				
				for(GoodsBo bo:map.get(key)){
					GoodsResponse kid = new GoodsResponse();
					kid.setGoodsId(bo.getGoodsId());
					kid.setGoodsName(bo.getGoodsName());
					kid.setGoodsImg(bo.getGoodsImg());
					kid.setGoodsProp(bo.getGoodsProp());
					kid.setUnit(bo.getUnit());
					kid.setUnitPrice(bo.getUnitPrice());
					kid.setFrontType(null);
					kid.setGoodsList(null);
					goods.getGoodsList().add(kid);
				}
				response.add(goods);
			}
			
		}else{
			BasFrontType bft = this.basFrontTypeMapper.load(vo.getFrontTypeId());
			switch (bft.getLevel()) {
			case 1: //一级类目商品
				response = this.gooGoodsMapper.findFirst(marketId,frontTypeId);
				break;
			case 2: //二级类目商品
				response = this.gooGoodsMapper.findSecond(marketId,frontTypeId);
				break;
			}
		}
		return response;
	}
	*/
	
	@Override
	public GoodsInfoResponse findGoodsById(GoodsRequest vo) {
		int marketId= this.marketService.findMaketId(vo.getAddressId());
		GooGoods po = this.gooGoodsMapper.load(vo.getGoodsId());
		GoodsInfoResponse response = new GoodsInfoResponse(po);
		response.setPrice(marMarketGoodsMapper.findByGoodsId(marketId, vo.getGoodsId()).getUnitPrice());
		return response;
	}

	@Override
	public List<GoodsPriceResponse> findGoodsPriceByGoodsId(GoodsRequest vo) {
		int marketId= this.marketService.findMaketId(vo.getAddressId());
		GooGoods goodPo =this.gooGoodsMapper.load(vo.getGoodsId());
		//商品单价
		int unitPrice = this.marMarketGoodsMapper.findByGoodsId(marketId, vo.getGoodsId()).getUnitPrice();
		//商品重量配置
		List<GooGoodsAmount> pos = this.gooGoodsAmountMapper.findByGoodsId(vo.getGoodsId());
		List<GoodsPriceResponse> bos = new ArrayList<GoodsPriceResponse>();
	    for(GooGoodsAmount po:pos){
	    	GoodsPriceResponse res = new GoodsPriceResponse();
	    	res.setUnit(goodPo.getUnit());
	    	res.setGoodsId(vo.getGoodsId());
	    	res.setAmount(po.getAmount());
	    	res.setPrice(PriceUtils.getGoodsPrice(unitPrice, po.getAmount(), goodPo.getUnit()));
	    	res.setUnitPrice(unitPrice);
	    	bos.add(res);
	    }
		return bos;
	}

	@Override
	public List<GoodsMenuResponse> findMenuByGoodsId(GoodsRequest vo) {
		List<MnuMenu> pos = this.mnuMenuMapper.findByGoodsId(vo.getGoodsId());
		List<GoodsMenuResponse> bos = new ArrayList<GoodsMenuResponse>();
		for(MnuMenu po : pos){
			bos.add(new GoodsMenuResponse(po));
		}
		return bos;
	}

}
