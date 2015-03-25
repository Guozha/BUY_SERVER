package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BuyOrderChild;

@Repository
public interface BuyOrderChildMapper extends BaseMapper<BuyOrderChild, Integer> {
	
	List<BuyOrderChild> findByOrder(int orderId);
	
	void updateBySend(@Param("orderChildId")int orderChildId, @Param("pushSellerId")int pushSellerId, @Param("pullSellerId")int pullSellerId, @Param("status")String status);
	
}
