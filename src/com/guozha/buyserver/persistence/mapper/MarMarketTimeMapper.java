package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.MarMarketTime;
import com.guozha.buyserver.web.controller.order.MarketTimeResponse;

@Repository
public interface MarMarketTimeMapper extends BaseMapper<MarMarketTime, Integer> {
	
	List<MarketTimeResponse> findTimeByMarketId(int marketId);

}
