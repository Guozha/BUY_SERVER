package com.guozha.buyserver.service.account.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.AccMyFavo;
import com.guozha.buyserver.persistence.mapper.AccMyFavoMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.account.MyFavoService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.account.FavoMenuRequest;
import com.guozha.buyserver.web.controller.account.SearchFavoResponse;

@Transactional(rollbackFor = Exception.class)
@Service("myFavoService")
public class MyFavoServiceImpl extends AbstractBusinessObjectServiceMgr
		implements MyFavoService {
	
	@Autowired
	private MnuMenuMapper mnuMenuMapper;
	@Autowired
	private AccMyFavoMapper accMyFavoMapper;

	@Override
	public MsgResponse favoMenu(FavoMenuRequest vo) {
		String menuIds = vo.getMenuIds();
		for(String menuIdStr : menuIds.split(",")){
			int menuId = Integer.parseInt(menuIdStr);
			AccMyFavo accMyFavo = new AccMyFavo();
			accMyFavo.setUserId(vo.getUserId());
			accMyFavo.setDirFlag("0");
			accMyFavo.setMenuId(menuId);
			accMyFavo.setFavoName(mnuMenuMapper.load(menuId).getMenuName());
			accMyFavo.setParentId(0);
			accMyFavoMapper.insert(accMyFavo);
		}
		return new MsgResponse(MsgResponse.SUCC, "收藏成功");
	}

	@Override
	public List<SearchFavoResponse> findFavo(int userId) {
		return accMyFavoMapper.findFavo(userId);
	}

}
