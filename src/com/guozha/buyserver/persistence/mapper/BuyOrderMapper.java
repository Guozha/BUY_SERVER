package com.guozha.buyserver.persistence.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BuyOrder;

@Repository
public interface BuyOrderMapper extends BaseMapper<BuyOrder, Integer> {
	
	void updateStatus(@Param("orderId")int orderId, @Param("oldStatus")String oldStatus, @Param("newStatus")String newStatus);

}
