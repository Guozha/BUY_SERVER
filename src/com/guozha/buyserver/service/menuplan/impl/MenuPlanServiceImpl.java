package com.guozha.buyserver.service.menuplan.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.DateUtil;
import com.guozha.buyserver.framework.enums.ReturnCodeEnum;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.MnuMenuGoods;
import com.guozha.buyserver.persistence.beans.MnuMenuStep;
import com.guozha.buyserver.persistence.beans.MnuUserMenuPlan;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuPlanMapper;
import com.guozha.buyserver.service.account.ReturnCode;
import com.guozha.buyserver.service.menuplan.MenuPlanService;
import com.guozha.buyserver.web.controller.menuplan.MenuDetailRequest;
import com.guozha.buyserver.web.controller.menuplan.MenuResponse;
import com.guozha.buyserver.web.controller.menuplan.MenuUserPlanRequest;

/**
 * 菜谱计划
 * 
 * @author sunhanbin
 * @date 2015-03-15
 * 
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class MenuPlanServiceImpl implements MenuPlanService {

	@Autowired
	private MnuMenuPlanMapper menuPlanMapper;
	@Autowired
	private MnuMenuMapper mnuMenuMapper;
	

	/**
	 * 新增菜谱
	 * 
	 * @author sunhanbin
	 * @date 2015-03-15
	 */
	public ReturnCode insert(MenuUserPlanRequest request) {
		ReturnCode returncode = new ReturnCode();
		returncode.setReturnCode(ReturnCodeEnum.FAILED.status);
		if (request != null) {
			MnuUserMenuPlan menuUserPlan = new MnuUserMenuPlan();
			menuUserPlan.setFirstMenuId(request.getFirstMenuId());
			menuUserPlan.setFiveMenuId(request.getFiveMenuId());
			menuUserPlan.setFourMenuId(request.getFourMenuId());
			menuUserPlan.setPlanDate(DateUtil.string2Date(request.getPlanDate(), DateUtil.PATTERN_DATE));
			menuUserPlan.setSecondMenuId(request.getSecondMenuId());
			menuUserPlan.setSixMenuId(request.getSixMenuId());
			menuUserPlan.setThirdMenuId(request.getThirdMenuId());
			menuUserPlan.setUserId(request.getUserId());
			int menuPlanId = menuPlanMapper.insertUserMenuPlan(menuUserPlan);
			if (menuPlanId > 0)
				returncode.setReturnCode(ReturnCodeEnum.SUCCESS.status);
		}
		return returncode;
	}

	/**
	 * 推荐菜谱
	 * 
	 * @author sunhanbin
	 * @date 2015-03-15
	 */
	public List<MnuMenu> listMenu() {
		return menuPlanMapper.listRandMenu();
	}

	/**
	 * 菜谱菜品详情
	 * 
	 * @author sunhanbin
	 * @date 2015-03-15
	 */
	public MenuResponse detail(MenuDetailRequest request) {
		MenuResponse response = null;
		if (request != null) {
			int menuId = request.getMenuId();
			response = menuPlanMapper.menuDetail(menuId);
			List<MnuMenuStep> menuSteps = menuPlanMapper.listMenuCookStep(menuId);
			if (menuSteps != null)
				response.setMuenSteps(menuSteps);
			List<MnuMenuGoods> menuGoods = mnuMenuMapper.findGoodsById(menuId);
			if (menuGoods != null)
				response.setMenuGoods(menuGoods);
		}
		return response;
	}
	
	@Override
	public List<MenuResponse> findByGoodsId(int goodsId) {
		List<MnuMenu> pos = this.mnuMenuMapper.findByGoodsId(goodsId);
		List<MenuResponse> response = new ArrayList<MenuResponse>();
		for(MnuMenu po : pos){
			MenuResponse menuResponse = new MenuResponse();
			menuResponse.setMenuId(po.getMenuId());
			menuResponse.setMenuName(po.getMenuName());
			menuResponse.setCookieWay(po.getCookieWay());
			menuResponse.setHardType(po.getHardType());
			menuResponse.setCookieTime(po.getCookieTime());
			menuResponse.setMenuImg(po.getMenuImg());
			response.add(menuResponse);
		}
		return response;
	}

}
