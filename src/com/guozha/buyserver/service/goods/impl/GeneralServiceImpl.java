package com.guozha.buyserver.service.goods.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.PriceUtils;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BasFrontType;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.GooGoodsAmount;
import com.guozha.buyserver.persistence.mapper.BasFrontTypeMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsAmountMapper;
import com.guozha.buyserver.service.goods.GeneralService;
import com.guozha.buyserver.service.market.MarketService;
import com.guozha.buyserver.web.controller.goods.FrontTypeRequest;
import com.guozha.buyserver.web.controller.goods.FrontTypeResponse;
import com.guozha.buyserver.web.controller.goods.GeneralResponse;
import com.guozha.buyserver.web.controller.goods.Goods;
import com.guozha.buyserver.web.controller.goods.GoodsInfoResponse;
import com.guozha.buyserver.web.controller.goods.GoodsPriceResponse;
import com.guozha.buyserver.web.controller.goods.GoodsRequest;


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
	public GeneralResponse findGoods(GoodsRequest vo) {
		int marketId= this.marketService.findMaketId(vo.getAddressId());
		GeneralResponse response = new GeneralResponse();
		List<BasFrontType> frontTypeList = this.basFrontTypeMapper.findFirstPager(vo.getStartIndex(), vo.getPageSize()/6);
		for(int i=0;i< frontTypeList.size();i++){
			BasFrontType frontType = frontTypeList.get(i);
			FrontTypeResponse ft = new FrontTypeResponse(frontType);
			response.getFrontTypeList().add(ft);
			response.getFrontTypeList().get(i).setGoodsList(this.gooGoodsMapper.findLimit6ByFirstFrontTypeId(marketId, frontType.getFrontTypeId()));
		}
		response.setPageCount(10);
		return response;
	}
	
	
	public GeneralResponse findGoodsByFrontTypeId(GoodsRequest vo){
		int marketId= this.marketService.findMaketId(vo.getAddressId());
		BasFrontType bft = this.basFrontTypeMapper.load(vo.getFrontTypeId());
		GeneralResponse response = new GeneralResponse();
		response.setFrontTypeList(null);
		response.setPageCount(0);
		List<Goods> goodsList = null;
		switch (bft.getLevel()) {
		case 1: //一级类目商品
			goodsList = this.gooGoodsMapper.findPagerByFirstFrontTypeId(marketId, vo.getFrontTypeId(), vo.getStartIndex(), vo.getPageSize());
			break;
		case 2: //二级类目商品
			goodsList = this.gooGoodsMapper.findPagerBySecondFrontTypeId(marketId, vo.getFrontTypeId(), vo.getStartIndex(), vo.getPageSize());
			break;
		}
		response.setGoodsList(goodsList);
		return response;
	}
	
	@Override
	public GoodsInfoResponse findGoodsById(GoodsRequest vo) {
		int marketId= this.marketService.findMaketId(vo.getAddressId());
		GooGoods po = this.gooGoodsMapper.load(vo.getGoodsId());
		GoodsInfoResponse response = new GoodsInfoResponse(po);
		response.setUnitPrice(marMarketGoodsMapper.findByGoodsId(marketId, vo.getGoodsId()).getUnitPrice());
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

}
