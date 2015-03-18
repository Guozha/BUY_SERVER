package com.guozha.buyserver.service.payment.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.service.payment.PaymentService;

@Transactional(rollbackFor = Exception.class)
@Service("paymentService")
public class PaymentServiceImpl extends AbstractBusinessObjectServiceMgr
		implements PaymentService {

}
