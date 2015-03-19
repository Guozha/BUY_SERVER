package com.guozha.buyserver.web.controller.order;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.service.order.OrderService;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/order")
public class OrderController extends BaseController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/times")
	public void times(int marketId, HttpServletResponse response) {
		responseJson(orderService.findMarketTime(marketId), response);
	}
	
	@RequestMapping(value = "/cancel")
	public void cancel(CancelOrderRequest vo, HttpServletResponse response) {
		responseJson(orderService.cancelOrder(vo), response);
	}

}