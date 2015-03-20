package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BuyOrderGoods;

@Repository
public interface BuyOrderGoodsMapper extends BaseMapper<BuyOrderGoods, Integer> {
	
    List<BuyOrderGoods> findByOrder(int orderId);

}
