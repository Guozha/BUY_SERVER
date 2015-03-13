package com.guozha.buyserver.service.account;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.CheckCodeRequest;
import com.guozha.buyserver.web.controller.account.CheckCodeResponse;
import com.guozha.buyserver.web.controller.account.LoginRequest;
import com.guozha.buyserver.web.controller.account.LoginResponse;
import com.guozha.buyserver.web.controller.account.LogoutRequest;
import com.guozha.buyserver.web.controller.account.RegisterRequest;

public interface AccountService extends BusinessObjectServiceMgr {
	
	CheckCodeResponse getCheckCodeForReg(CheckCodeRequest vo);
	
	MsgResponse register(RegisterRequest vo);
	
	LoginResponse login(LoginRequest vo);
	
	MsgResponse logout(LogoutRequest vo);
	
}
