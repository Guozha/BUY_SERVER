package com.guozha.buyserver.persistence.mapper;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.AccMySeller;
import com.guozha.buyserver.web.controller.account.UpdateMySellerRequest;

@Repository
public interface AccMySellerMapper extends BaseMapper<AccMySeller, Integer> {
	
	void update(UpdateMySellerRequest vo);
	
}
