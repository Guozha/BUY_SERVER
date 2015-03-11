package com.guozha.buyserver.service.cart.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.service.cart.addService;

@Transactional(rollbackFor = Exception.class)
@Service("addService")
public class AddServiceImpl extends AbstractBusinessObjectServiceMgr implements addService {


}
