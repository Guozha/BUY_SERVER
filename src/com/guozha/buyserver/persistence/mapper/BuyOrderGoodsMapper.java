package com.guozha.buyserver.persistence.mapper;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BuyOrderGoods;

@Repository
public interface BuyOrderGoodsMapper extends BaseMapper<BuyOrderGoods, Integer> {

}
