package com.guozha.buyserver.service.account;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.FavoMenuRequest;
import com.guozha.buyserver.web.controller.account.SearchFavoResponse;

public interface MyFavoService extends BusinessObjectServiceMgr {
	
	MsgResponse favoMenu(FavoMenuRequest vo);
	
	List<SearchFavoResponse> findFavo(int userId);

}
