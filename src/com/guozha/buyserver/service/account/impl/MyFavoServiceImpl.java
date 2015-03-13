package com.guozha.buyserver.service.account.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.service.account.MyFavoService;

@Transactional(rollbackFor = Exception.class)
@Service("myFavoService")
public class MyFavoServiceImpl extends AbstractBusinessObjectServiceMgr
		implements MyFavoService {

}
