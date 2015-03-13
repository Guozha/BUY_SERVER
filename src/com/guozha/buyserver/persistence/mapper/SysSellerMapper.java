package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.SysSeller;

@Repository
public interface SysSellerMapper extends BaseMapper<SysSeller, Integer> {
	
	List<SysSeller> findByUserId(Integer userId);
	
}
