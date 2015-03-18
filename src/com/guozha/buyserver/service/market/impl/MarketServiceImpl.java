package com.guozha.buyserver.service.market.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.SystemResource;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.MarMarket;
import com.guozha.buyserver.persistence.mapper.MarMarketMapper;
import com.guozha.buyserver.service.market.MarketService;

@Transactional(rollbackFor = Exception.class)
@Service("marketService")
public class MarketServiceImpl extends AbstractBusinessObjectServiceMgr implements MarketService {
    
	@Autowired
	private MarMarketMapper marMarketMapper;
	@Override
	public int findMaketId(Integer addressId) {
		int defalutMarketId = Integer.valueOf(SystemResource.getConfig("default_market_id"));
		if(addressId==null){
			return defalutMarketId;
		}
		MarMarket market = this.marMarketMapper.findByAddressId(addressId);
		return market!=null?market.getMarketId():defalutMarketId;
	}

}
