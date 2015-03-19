package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BasPayWay;
import com.guozha.buyserver.web.controller.payment.PayWayResponse;

@Repository
public interface BasPayWayMapper extends BaseMapper<BasPayWay, Integer> {
	
	List<PayWayResponse> findPayWayByStatus(String status);

}
