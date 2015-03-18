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
import com.guozha.buyserver.persistence.beans.MarMarketGoodsPrice;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.mapper.BasFrontTypeMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsPriceMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.goods.GeneralService;
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
	private MarMarketGoodsPriceMapper marMarketGoodsPriceMapper;
	@Autowired
	private MnuMenuMapper mnuMenuMapper;
	
	@Autowired
	private MarMarketGoodsMapper marMarketGoodsMapper;
	
	//农贸市场ID 临时参数需调整
	private int marketId=1;
	
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
		
		//根据商户地址获得农贸市场？？？？？？
		
		List<GoodsResponse> list = null;
		Integer frontTypeId = vo.getFrontTypeId();
		if(frontTypeId==null){
			list = this.gooGoodsMapper.findByMarketId(marketId);
		}else{
			BasFrontType bft = this.basFrontTypeMapper.load(vo.getFrontTypeId());
			switch (bft.getLevel()) {
			case 1: //一级类目商品
				list = this.gooGoodsMapper.findFirst(marketId,frontTypeId);
				break;
			case 2: //二级类目商品
				list = this.gooGoodsMapper.findSecond(marketId,frontTypeId);
				break;
			}
		}
		return list;
	}
	
	@Override
	public GoodsInfoResponse findGoodsById(int goodsId) {
		GooGoods po = this.gooGoodsMapper.load(goodsId);
		GoodsInfoResponse response = new GoodsInfoResponse(po);
		response.setPrice(marMarketGoodsMapper.findByGoodsId(marketId, goodsId).getPrice());
		return response;
	}

	@Override
	public List<GoodsPriceResponse> findGoodsPriceByGoodsId(int goodsId) {
		GooGoods goodPo =this.gooGoodsMapper.load(goodsId);
		//商品单价
		int unitPrice = this.marMarketGoodsMapper.findByGoodsId(marketId, goodsId).getPrice();
		//商品重量配置
		List<MarMarketGoodsPrice> pos = this.marMarketGoodsPriceMapper.findByGoodsId(marketId, goodsId);
		List<GoodsPriceResponse> bos = new ArrayList<GoodsPriceResponse>();
	    for(MarMarketGoodsPrice po:pos){
	    	GoodsPriceResponse res = new GoodsPriceResponse();
	    	res.setUnit(goodPo.getUnit());
	    	res.setGoodsId(goodsId);
	    	res.setAmount(po.getAmount());
	    	res.setGoodsPriceId(po.getGoodsPriceId());
	    	res.setPrice(PriceUtils.getGoodsPrice(unitPrice, po.getAmount(), goodPo.getUnit()));
	    	bos.add(res);
	    }
		return bos;
	}

	@Override
	public List<GoodsMenuResponse> findMenuByGoodsId(int goodsId) {
		List<MnuMenu> pos = this.mnuMenuMapper.findByGoodsId(goodsId);
		List<GoodsMenuResponse> bos = new ArrayList<GoodsMenuResponse>();
		for(MnuMenu po : pos){
			bos.add(new GoodsMenuResponse(po));
		}
		return bos;
	}

}
