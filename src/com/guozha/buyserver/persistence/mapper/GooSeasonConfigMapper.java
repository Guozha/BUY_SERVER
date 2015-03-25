package com.guozha.buyserver.persistence.mapper;


import java.util.Date;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.GooSeasonConfig;

@Repository
public interface GooSeasonConfigMapper extends BaseMapper<GooSeasonConfig, Integer> {
    
	/**
	 * 系统当前日期获得三节气
	 * @param date
	 * @return
	 */
	String loadBySystemDate(Date date);
}
