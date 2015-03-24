package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BuyOrder;

@Repository
public interface BuyOrderMapper extends BaseMapper<BuyOrder, Integer> {
	
	void updateStatus(@Param("orderId")int orderId, @Param("oldStatus")String oldStatus, @Param("newStatus")String newStatus);
	
	int findOrderCount(@Param("userId")int userId, @Param("statusList")List<String> statusList);
	
	List<BuyOrder> findOrder(@Param("userId")int userId, @Param("statusList")List<String> statusList, @Param("startIndex")int startIndex, @Param("pageSize")int pageSize);
	
	void updateCount(@Param("orderId")int orderId, @Param("totalPrice")int totalPrice, @Param("serviceFee")int serviceFee);

}
