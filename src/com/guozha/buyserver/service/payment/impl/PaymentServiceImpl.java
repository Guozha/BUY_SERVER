package com.guozha.buyserver.service.payment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.mapper.BasPayWayMapper;
import com.guozha.buyserver.service.payment.PaymentService;
import com.guozha.buyserver.web.controller.payment.PayWayResponse;

@Transactional(rollbackFor = Exception.class)
@Service("paymentService")
public class PaymentServiceImpl extends AbstractBusinessObjectServiceMgr
		implements PaymentService {
	
	@Autowired
	private BasPayWayMapper basPayWayMapper;

	@Override
	public List<PayWayResponse> findInUsePayWay() {
		return basPayWayMapper.findPayWayByStatus("1");
	}

}
