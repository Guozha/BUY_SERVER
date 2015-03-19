package com.guozha.buyserver.service.payment;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.payment.PayWayResponse;

public interface PaymentService extends BusinessObjectServiceMgr {
	
	List<PayWayResponse> findInUsePayWay();

}
