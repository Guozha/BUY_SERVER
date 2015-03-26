package com.guozha.buyserver.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.guozha.buyserver.service.account.impl.AccountTestSuite;
import com.guozha.buyserver.service.order.impl.OrderTestSuite;
import com.guozha.buyserver.service.payment.impl.PaymentTestSuite;

@RunWith(value=Suite.class)
@SuiteClasses(value={AccountTestSuite.class, OrderTestSuite.class, PaymentTestSuite.class})
public class MasterTestSuite {

}
