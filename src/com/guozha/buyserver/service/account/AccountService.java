package com.guozha.buyserver.service.account;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.RegisterRequest;

public interface AccountService extends BusinessObjectServiceMgr {
	
	User getLoginUser(LoginRequest vo);
	
	User getRegUser(String mobileNo);
	
	void register(RegisterRequest vo);
	
}
