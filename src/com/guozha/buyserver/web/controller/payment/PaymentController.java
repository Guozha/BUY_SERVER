package com.guozha.buyserver.web.controller.payment;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.payment.PaymentService;
import com.guozha.buyserver.web.controller.BaseController;
import com.guozha.buyserver.web.controller.order.CancelOrderRequest;

@Controller
@RequestMapping(value="/payment")
public class PaymentController extends BaseController {
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value = "/cancel")
	public void cancel(HttpServletResponse response) {
		responseJson(paymentService.findPayWay(), response);
	}

}
