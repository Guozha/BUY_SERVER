package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.MarMarketGoodsPrice;

/**
 * 农贸市场商品价格
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-2-17 下午12:22:34
 */
public interface MarMarketGoodsPriceMapper extends BaseMapper<MarMarketGoodsPrice, Integer> {
	/**
	 * 单商品价格配置查询
	 * @param goodsId
	 * @return
	 */
	List<MarMarketGoodsPrice> findByGoodsId(@Param("marketId")int marketId, @Param("goodsId")int goodsId);
}
