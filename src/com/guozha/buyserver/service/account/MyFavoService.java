package com.guozha.buyserver.service.account;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.AdjustFavoRequest;
import com.guozha.buyserver.web.controller.account.DeleteFavoRequest;
import com.guozha.buyserver.web.controller.account.FavoGoodsRequest;
import com.guozha.buyserver.web.controller.account.FavoMenuRequest;
import com.guozha.buyserver.web.controller.account.InsertDirRequest;
import com.guozha.buyserver.web.controller.account.SearchDirResponse;
import com.guozha.buyserver.web.controller.account.SearchFavoRequest;
import com.guozha.buyserver.web.controller.account.SearchGoodsFavoResponse;
import com.guozha.buyserver.web.controller.account.SearchMenuFavoResponse;

public interface MyFavoService extends BusinessObjectServiceMgr {
	
	MsgResponse favoGoods(FavoGoodsRequest vo);
	
	MsgResponse favoMenu(FavoMenuRequest vo);
	
	List<SearchGoodsFavoResponse> findGoodsFavo(SearchFavoRequest vo);
	
	List<SearchMenuFavoResponse> findMenuFavo(SearchFavoRequest vo);
	
	MsgResponse insertDir(InsertDirRequest vo);
	
	List<SearchDirResponse> findDir(int userId);
	
	MsgResponse adjustFavo(AdjustFavoRequest vo);
	
	MsgResponse deleteFavo(DeleteFavoRequest vo);
	
	List<SearchMenuFavoResponse> findMenuByDir(int parentId);

}
