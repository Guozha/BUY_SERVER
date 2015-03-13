package com.guozha.buyserver.service.account;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.account.InsertMySellerRequest;
import com.guozha.buyserver.web.controller.account.InsertMySellerResponse;
import com.guozha.buyserver.web.controller.account.ListMySellerRequest;
import com.guozha.buyserver.web.controller.account.ListMySellerResponse;
import com.guozha.buyserver.web.controller.account.UpdateMySellerRequest;
import com.guozha.buyserver.web.controller.account.UpdateMySellerResponse;

public interface MySellerService extends BusinessObjectServiceMgr {
	
	List<ListMySellerResponse> findMySeller(ListMySellerRequest vo);
	
	UpdateMySellerResponse updateMySeller(UpdateMySellerRequest vo);
	
	InsertMySellerResponse insertMySeller(InsertMySellerRequest vo);

}
