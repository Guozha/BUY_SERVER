package com.guozha.buyserver.service.account;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.AdjustFavoRequest;
import com.guozha.buyserver.web.controller.account.DeleteFavoRequest;
import com.guozha.buyserver.web.controller.account.FavoMenuRequest;
import com.guozha.buyserver.web.controller.account.InsertDirRequest;
import com.guozha.buyserver.web.controller.account.SearchFavoResponse;

public interface MyFavoService extends BusinessObjectServiceMgr {
	
	MsgResponse favoMenu(FavoMenuRequest vo);
	
	List<SearchFavoResponse> findFavo(int userId);
	
	MsgResponse insertDir(InsertDirRequest vo);
	
	MsgResponse adjustFavo(AdjustFavoRequest vo);
	
	MsgResponse deleteFavo(DeleteFavoRequest vo);
	
	List<SearchFavoResponse> findMenuByDir(int parentId);

}
