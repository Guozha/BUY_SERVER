package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.MnuMenuGoods;
import com.guozha.buyserver.service.order.impl.MenuGoodsInfo;

@Repository
public interface MnuMenuGoodsMapper extends BaseMapper<MnuMenuGoods, Integer> {
	
	List<MenuGoodsInfo> findMenuGoodsInfo(int menuId);

}
