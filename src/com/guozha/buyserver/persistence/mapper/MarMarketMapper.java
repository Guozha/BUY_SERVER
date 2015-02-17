package com.guozha.buyserver.persistence.mapper;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.MarMarket;

/**
 * 农贸市场
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-2-17 下午3:05:06
 */
@Repository
public interface MarMarketMapper extends BaseMapper<MarMarket, Integer> {
	
	/**
	 * 查询用户对应的农贸市场
	 * @param userId
	 * @return
	 */
	public MarMarket findDefaultByUserId(int userId);
}
