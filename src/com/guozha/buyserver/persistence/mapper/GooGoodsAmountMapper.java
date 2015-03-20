package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.GooGoodsAmount;

/**
 * 农贸市场商品价格
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-2-17 下午12:22:34
 */
public interface GooGoodsAmountMapper extends BaseMapper<GooGoodsAmount, Integer> {
	/**
	 * 单商品价格配置查询
	 * @param goodsId
	 * @return
	 */
	List<GooGoodsAmount> findByGoodsId(int goodsId);
}
