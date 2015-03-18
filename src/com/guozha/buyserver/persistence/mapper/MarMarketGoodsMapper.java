package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.MarMarketGoods;

public interface MarMarketGoodsMapper extends
		BaseMapper<MarMarketGoods, Integer> {
	
	List<Integer> getGoodIdsInMarket(@Param("marketId")int marketId, @Param("openBuyFlag")String openBuyFlag);
	
	/**
	 * 查询商品单价
	 * @param marketId 所在农贸市场ID
	 * @param goodsId 商品ID
	 * @return
	 */
	MarMarketGoods findByGoodsId(@Param("marketId")int marketId, @Param("goodsId")int goodsId);
	
	/**
	 * 查询菜谱对应的农贸商品 
	 * @param marketId 市场ID
	 * @param menuId  菜谱ID
	 * @return
	 */
	List<MarMarketGoods> findByMenuId(@Param("marketId")int marketId, @Param("menuId")int menuId);

}
