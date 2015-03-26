package com.guozha.buyserver.service.payment.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.service.payment.PaymentService;

public class PaymentServiceImplTest extends BaseJunitCase {
	
	@Autowired
	private PaymentService paymentService;
	
	@Test
	public void testFindInUsePayWay(){
		fail("Not implements yet");
	}

}
