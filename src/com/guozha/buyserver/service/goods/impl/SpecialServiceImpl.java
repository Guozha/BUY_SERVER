package com.guozha.buyserver.service.goods.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BasFrontType;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.mapper.BasFrontTypeMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsMapper;
import com.guozha.buyserver.service.common.CommonService;
import com.guozha.buyserver.service.goods.SpecialService;
import com.guozha.buyserver.web.controller.goods.GoodsInfoResponse;
import com.guozha.buyserver.web.controller.goods.GoodsRequest;
import com.guozha.buyserver.web.controller.goods.GoodsResponse;


@Transactional(rollbackFor = Exception.class)
@Service("specialService")
public class SpecialServiceImpl extends AbstractBusinessObjectServiceMgr implements SpecialService {
    
	@Autowired
	private BasFrontTypeMapper basFrontTypeMapper;
	@Autowired
	private GooGoodsMapper gooGoodsMapper;
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MarMarketGoodsMapper marMarketGoodsMapper;
	
	@Override
	public List<GoodsResponse> findGoods(GoodsRequest vo) {
		int marketId= this.commonService.getMaketId(vo.getAddressId());
		List<GoodsResponse> pos = null;
		Integer frontTypeId = vo.getFrontTypeId();
		if(frontTypeId==null){
			pos = this.gooGoodsMapper.findAllSpecial(marketId);
		}else{
			BasFrontType bft = this.basFrontTypeMapper.load(vo.getFrontTypeId());
			switch (bft.getLevel()) {
			case 1: //一级类目商品
				pos = this.gooGoodsMapper.findFirstSpecial(marketId, frontTypeId);
				break;
			case 2: //二级类目商品
				pos = this.gooGoodsMapper.findSecondSpecial(marketId,frontTypeId);
				break;
			}
		}
		return pos;
	}
	
	
	@Override
	public GoodsInfoResponse findGoodsById(GoodsRequest vo) {
		int marketId= this.commonService.getMaketId(vo.getAddressId());
		GooGoods po = this.gooGoodsMapper.load(vo.getGoodsId());
		GoodsInfoResponse response = new GoodsInfoResponse(po);
		response.setUnitPrice(marMarketGoodsMapper.findByGoodsId(marketId, vo.getGoodsId()).getUnitPrice());
		return response;
	}

}
