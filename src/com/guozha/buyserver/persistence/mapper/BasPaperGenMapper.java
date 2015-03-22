package com.guozha.buyserver.persistence.mapper;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BasPaperGen;

public interface BasPaperGenMapper extends BaseMapper<BasPaperGen, Integer> {
	
	BasPaperGen getOne(BasPaperGen basPaperGen);

}
