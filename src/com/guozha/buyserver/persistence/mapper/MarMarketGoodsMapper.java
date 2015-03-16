package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.MarMarketGoods;

public interface MarMarketGoodsMapper extends
		BaseMapper<MarMarketGoods, Integer> {
	
	List<Integer> getGoodIdsInMarket(@Param("marketId")int marketId, @Param("openBuyFlag")String openBuyFlag);

}
