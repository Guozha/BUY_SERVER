package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BuyOrderMenu;

@Repository
public interface BuyOrderMenuMapper extends BaseMapper<BuyOrderMenu, Integer> {
	
	List<BuyOrderMenu> findByOrder(int orderId);

}
