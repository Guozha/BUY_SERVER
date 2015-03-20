package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BuyOrderMenuGoods;

@Repository
public interface BuyOrderMenuGoodsMapper extends
		BaseMapper<BuyOrderMenuGoods, Integer> {
	
	List<BuyOrderMenuGoods> findByOrderMenu(int orderMenuId);

}
