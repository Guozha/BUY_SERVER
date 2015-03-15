package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.AccMyFavo;
import com.guozha.buyserver.web.controller.account.AdjustFavoRequest;
import com.guozha.buyserver.web.controller.account.SearchDirResponse;
import com.guozha.buyserver.web.controller.account.SearchMenuFavoResponse;

@Repository
public interface AccMyFavoMapper extends BaseMapper<AccMyFavo, Integer> {
	
	List<SearchMenuFavoResponse> findMenuFavo(@Param("userId")int userId, @Param("favoType")String favoType);
	
	void adjustFavo(AdjustFavoRequest vo);
	
	void adjustFavoByDirDel(int parentId);
	
	List<SearchMenuFavoResponse> findMenuByDir(int parentId);
	
	List<SearchDirResponse> findDir(int userId);

}
