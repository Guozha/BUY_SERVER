package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.AccMyFavo;
import com.guozha.buyserver.web.controller.account.AdjustFavoRequest;
import com.guozha.buyserver.web.controller.account.SearchFavoResponse;

@Repository
public interface AccMyFavoMapper extends BaseMapper<AccMyFavo, Integer> {
	
	List<SearchFavoResponse> findFavo(int userId);
	
	void adjustFavo(AdjustFavoRequest vo);
	
	void adjustFavoByDirDel(int parentId);
	
	List<SearchFavoResponse> findMenuByDir(int parentId);

}
