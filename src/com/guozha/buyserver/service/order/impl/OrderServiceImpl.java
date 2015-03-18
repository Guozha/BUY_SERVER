package com.guozha.buyserver.service.order.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.service.order.OrderService;

@Transactional(rollbackFor = Exception.class)
@Service("orderService")
public class OrderServiceImpl extends AbstractBusinessObjectServiceMgr
		implements OrderService {

}
