package com.guozha.buyserver.service.account;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.account.LoginRequest;

public interface LoginService extends BusinessObjectServiceMgr {
	
	User getLoginUser(LoginRequest vo);

}
