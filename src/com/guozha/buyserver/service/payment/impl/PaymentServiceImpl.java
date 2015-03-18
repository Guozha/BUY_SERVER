package com.guozha.buyserver.service.payment.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.service.payment.PaymentService;
import com.guozha.buyserver.web.controller.payment.PayWayResponse;

@Transactional(rollbackFor = Exception.class)
@Service("paymentService")
public class PaymentServiceImpl extends AbstractBusinessObjectServiceMgr
		implements PaymentService {

	@Override
	public List<PayWayResponse> findPayWay() {
		return null;
	}

}
