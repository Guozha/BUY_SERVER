package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BuyOrderChild;

@Repository
public interface BuyOrderChildMapper extends BaseMapper<BuyOrderChild, Integer> {
	
	List<BuyOrderChild> findByOrder(int orderId);
	
}
