package com.guozha.buyserver.service.goods.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BasFrontType;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.mapper.BasFrontTypeMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.service.goods.SpecialService;
import com.guozha.buyserver.web.controller.goods.GoodsRequest;
import com.guozha.buyserver.web.controller.goods.GoodsResponse;


@Transactional(rollbackFor = Exception.class)
@Service("specialService")
public class SpecialServiceImpl extends AbstractBusinessObjectServiceMgr implements SpecialService {
    
	@Autowired
	private BasFrontTypeMapper basFrontTypeMapper;
	@Autowired
	private GooGoodsMapper gooGoodsMapper;
	
	@Override
	public List<GoodsResponse> findGoods(GoodsRequest vo) {
		List<GooGoods> pos = null;
		Integer frontTypeId = vo.getFrontTypeId();
		if(frontTypeId==null){
			pos = this.gooGoodsMapper.findAllSpecial();
		}else{
			BasFrontType bft = this.basFrontTypeMapper.load(vo.getFrontTypeId());
			switch (bft.getLevel()) {
			case 1: //一级类目商品
				pos = this.gooGoodsMapper.findFirstSpecial(frontTypeId);
				break;
			case 2: //二级类目商品
				pos = this.gooGoodsMapper.findSecondSpecial(frontTypeId);
				break;
			}
		}
		List<GoodsResponse> bos = new ArrayList<GoodsResponse>();
		for(GooGoods po:pos){
			GoodsResponse bo = new GoodsResponse(po.getGoodsId(), po.getGoodsName(), po.getGoodsUrl(), po.getPrice(), po.getUnit());
			bos.add(bo);
		}
		return bos;
	}

}
