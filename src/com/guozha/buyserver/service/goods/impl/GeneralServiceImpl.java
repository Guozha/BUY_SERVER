package com.guozha.buyserver.service.goods.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BasFrontType;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.GooGoodsPrice;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.mapper.BasFrontTypeMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsPriceMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.account.User;
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
	private GooGoodsPriceMapper gooGoodsPriceMapper;
	@Autowired
	private MnuMenuMapper mnuMenuMapper;
	
	@Override
	public List<FrontTypeResponse> findFrontType(FrontTypeRequest vo) {
		List<BasFrontType> pos = null==vo.getParentId()?basFrontTypeMapper.findFirst():basFrontTypeMapper.findSecond(vo.getParentId());
		List<FrontTypeResponse> bos = new ArrayList<FrontTypeResponse>();
		for(BasFrontType po:pos){
			bos.add(new FrontTypeResponse(po.getFrontTypeId(), po.getShortName(), po.getLevel()));
		}
		return bos;
	}
	
	@Override
	public List<GoodsResponse> findGoods(GoodsRequest vo) {
		List<GooGoods> pos = null;
		Integer frontTypeId = vo.getFrontTypeId();
		if(frontTypeId==null){
			pos = this.gooGoodsMapper.findAll();
		}else{
			BasFrontType bft = this.basFrontTypeMapper.load(vo.getFrontTypeId());
			switch (bft.getLevel()) {
			case 1: //一级类目商品
				pos = this.gooGoodsMapper.findFirst(frontTypeId);
				break;
			case 2: //二级类目商品
				pos = this.gooGoodsMapper.findSecond(frontTypeId);
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
	
	@Override
	public GoodsInfoResponse findGoodsById(int goodsId) {
		GooGoods po = this.gooGoodsMapper.load(goodsId);
		GoodsInfoResponse bo = new GoodsInfoResponse();
		BeanUtils.copyProperties(po, bo);
		return bo;
	}

	@Override
	public List<GoodsPriceResponse> findGoodsPriceByGoodsId(int goodsId) {
		List<GooGoodsPrice> pos = this.gooGoodsPriceMapper.findByGoodsId(goodsId);
		List<GoodsPriceResponse> bos = new ArrayList<GoodsPriceResponse>();
	    for(GooGoodsPrice po:pos){
	    	bos.add(new GoodsPriceResponse(po.getGoodsPriceId(), po.getGoodsId(), po.getWeight(), po.getPrice()));
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
