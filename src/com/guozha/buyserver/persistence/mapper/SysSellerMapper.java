package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.SysSeller;
import com.guozha.buyserver.web.controller.account.SearchMySellerResponse;

@Repository
public interface SysSellerMapper extends BaseMapper<SysSeller, Integer> {
	
	List<SearchMySellerResponse> findByUserId(Integer userId);
	
	List<SysSeller> findForOrderSend(@Param("marketId")int marketId, @Param("backTypeId")int backTypeId);
	
}
