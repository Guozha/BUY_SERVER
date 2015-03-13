package com.guozha.buyserver.service.account.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.AccMySeller;
import com.guozha.buyserver.persistence.beans.SysSeller;
import com.guozha.buyserver.persistence.mapper.AccMySellerMapper;
import com.guozha.buyserver.persistence.mapper.SysSellerMapper;
import com.guozha.buyserver.service.account.MySellerService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.InsertMySellerRequest;
import com.guozha.buyserver.web.controller.account.ListMySellerRequest;
import com.guozha.buyserver.web.controller.account.ListMySellerResponse;
import com.guozha.buyserver.web.controller.account.UpdateMySellerRequest;

@Transactional(rollbackFor = Exception.class)
@Service("mySellerService")
public class MySellerServiceImpl extends AbstractBusinessObjectServiceMgr
		implements MySellerService {
	
	@Autowired
	private SysSellerMapper sysSellerMapper;
	@Autowired
	private AccMySellerMapper accMySellerMapper;

	@Override
	public List<ListMySellerResponse> findMySeller(ListMySellerRequest vo) {
		
		List<ListMySellerResponse> bos = new ArrayList<ListMySellerResponse>();
		
		List<SysSeller> pos = sysSellerMapper.findByUserId(vo.getUserId());
		for(SysSeller po : pos){
			bos.add(new ListMySellerResponse(po));
		}
		
		return bos;
	}

	@Override
	public MsgResponse updateMySeller(UpdateMySellerRequest vo) {
		accMySellerMapper.update(vo);
		return new MsgResponse();
	}

	@Override
	public MsgResponse insertMySeller(InsertMySellerRequest vo) {
		AccMySeller accMySeller = new AccMySeller();
		accMySeller.setSellerId(vo.getSellerId());
		accMySeller.setUserId(vo.getUserId());
		accMySeller.setSellerTag("3"); // SELLER_TAG 3-正常
		accMySellerMapper.insert(accMySeller);
		
		return new MsgResponse();
	}

}
