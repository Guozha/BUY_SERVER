package com.guozha.buyserver.service.account;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.InsertMySellerRequest;
import com.guozha.buyserver.web.controller.account.SearchMySellerResponse;
import com.guozha.buyserver.web.controller.account.UpdateMySellerRequest;

public interface MySellerService extends BusinessObjectServiceMgr {
	
	List<SearchMySellerResponse> findMySeller(int userId);
	
	MsgResponse updateMySeller(UpdateMySellerRequest vo);
	
	MsgResponse insertMySeller(InsertMySellerRequest vo);

}
