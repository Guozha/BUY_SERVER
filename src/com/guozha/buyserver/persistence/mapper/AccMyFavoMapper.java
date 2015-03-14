package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.AccMyFavo;
import com.guozha.buyserver.web.controller.account.ListFavoResponse;

@Repository
public interface AccMyFavoMapper extends BaseMapper<AccMyFavo, Integer> {
	
	List<ListFavoResponse> findFavo(int userId);

}
