package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.GooSeasonGoods;

/**
 * 节气食材
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-13 下午4:41:05
 */
@Repository
public interface GooSeasonGoodsMapper extends BaseMapper<GooSeasonGoods, Integer> {
	
	/**
	 * 节气食材查询
	 * @param seasons 三节气 ( 前一节气、当前节气、下一节气)
	 * @return
	 */
	List<GooSeasonGoods> findBySeason(@Param("season")String[] seasons);

}
