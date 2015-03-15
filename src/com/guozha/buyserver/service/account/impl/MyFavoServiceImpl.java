package com.guozha.buyserver.service.account.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.AccMyFavo;
import com.guozha.buyserver.persistence.mapper.AccMyFavoMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.account.MyFavoService;
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

@Transactional(rollbackFor = Exception.class)
@Service("myFavoService")
public class MyFavoServiceImpl extends AbstractBusinessObjectServiceMgr
		implements MyFavoService {
	
	@Autowired
	private MnuMenuMapper mnuMenuMapper;
	@Autowired
	private AccMyFavoMapper accMyFavoMapper;
	@Autowired
	private GooGoodsMapper gooGoodsMapper;

	@Override
	public MsgResponse favoGoods(FavoGoodsRequest vo) {
		AccMyFavo accMyFavo = new AccMyFavo();
		accMyFavo.setUserId(vo.getUserId());
		accMyFavo.setFavoType("1"); //FAVO_TYPE 1-食材收藏
		accMyFavo.setDirFlag("0");
		accMyFavo.setMenuOrGoodsId(vo.getGoodsId());
		accMyFavo.setFavoName(gooGoodsMapper.load(vo.getGoodsId()).getGoodsName());
		accMyFavo.setParentId(0);
		accMyFavoMapper.insert(accMyFavo);
		return new MsgResponse(MsgResponse.SUCC, "收藏成功");
	}

	@Override
	public MsgResponse favoMenu(FavoMenuRequest vo) {
		String menuIds = vo.getMenuIds();
		for(String menuIdStr : menuIds.split(",")){
			int menuId = Integer.parseInt(menuIdStr);
			AccMyFavo accMyFavo = new AccMyFavo();
			accMyFavo.setUserId(vo.getUserId());
			accMyFavo.setFavoType("2"); // FAVO_TYPE 2-菜谱收藏
			accMyFavo.setDirFlag("0");
			accMyFavo.setMenuOrGoodsId(menuId);
			accMyFavo.setFavoName(mnuMenuMapper.load(menuId).getMenuName());
			accMyFavo.setParentId(0);
			accMyFavoMapper.insert(accMyFavo);
		}
		return new MsgResponse(MsgResponse.SUCC, "收藏成功");
	}

	@Override
	public List<SearchGoodsFavoResponse> findGoodsFavo(SearchFavoRequest vo) {
		// TODO
		return null;
	}

	@Override
	public List<SearchMenuFavoResponse> findMenuFavo(SearchFavoRequest vo) {
		// TODO
		accMyFavoMapper.findMenuFavo(vo.getUserId(), "2"); //FAVO_TYPE 2-菜谱收藏
		return null;
	}

	@Override
	public MsgResponse insertDir(InsertDirRequest vo) {
		AccMyFavo model = new AccMyFavo();
		model.setUserId(vo.getUserId());
		model.setFavoType("2"); // FAVO_TYPE 2-菜谱收藏 (文件夹也属于菜谱收藏栏目)
		model.setDirFlag("1");
		model.setMenuOrGoodsId(null);
		model.setFavoName(vo.getFavoName());
		model.setParentId(0);
		accMyFavoMapper.insert(model);
		return new MsgResponse();
	}

	@Override
	public List<SearchDirResponse> findDir(int userId) {
		return accMyFavoMapper.findDir(userId);
	}

	@Override
	public MsgResponse adjustFavo(AdjustFavoRequest vo) {
		accMyFavoMapper.adjustFavo(vo);
		return new MsgResponse();
	}

	@Override
	public MsgResponse deleteFavo(DeleteFavoRequest vo) {
		accMyFavoMapper.delete(vo.getMyFavoId());// 删除菜谱收藏或删除文件夹
		if("1".equals(vo.getDirFlag())){// 如果是删除文件夹,将其下的所有菜谱移出
			accMyFavoMapper.adjustFavoByDirDel(vo.getMyFavoId());
		}
		return new MsgResponse();
	}

	@Override
	public List<SearchMenuFavoResponse> findMenuByDir(int parentId) {
		// TODO
		accMyFavoMapper.findMenuByDir(parentId);
		return null;
	}

}
