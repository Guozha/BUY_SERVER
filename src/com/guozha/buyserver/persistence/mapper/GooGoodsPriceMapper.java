package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.GooGoodsPrice;

/**
 * 价格配置映射
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 上午9:58:43
 */
@Repository
public interface GooGoodsPriceMapper extends BaseMapper<GooGoodsPrice, Integer> {
	
	/**
	 * 单商品价格配置查询
	 * @param goodsId
	 * @return
	 */
	List<GooGoodsPrice> findByGoodsId(int goodsId);

}
