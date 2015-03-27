package com.guozha.buyserver.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.guozha.buyserver.service.account.impl.AccountTestSuite;
import com.guozha.buyserver.service.cart.impl.CartTestSuite;
import com.guozha.buyserver.service.goods.impl.GeneralTestSuite;
import com.guozha.buyserver.service.order.impl.OrderTestSuite;
import com.guozha.buyserver.service.payment.impl.PaymentTestSuite;
import com.guozha.buyserver.service.search.impl.SearchTestSuite;
import com.guozha.buyserver.service.season.impl.SeasonTestSuite;

@RunWith(value=Suite.class)
@SuiteClasses(value={
		 			AccountTestSuite.class, OrderTestSuite.class, PaymentTestSuite.class,
					GeneralTestSuite.class,CartTestSuite.class,SeasonTestSuite.class,SearchTestSuite.class,
			 })
public class MasterTestSuite {

}
