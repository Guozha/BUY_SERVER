package com.guozha.buyserver.service.menuplan.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guozha.buyserver.common.util.DateUtil;
import com.guozha.buyserver.framework.enums.ReturnCodeEnum;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.MnuUserMenuPlan;
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
@Service
public class MenuPlanServiceImpl implements MenuPlanService {

	@Autowired
	private MnuMenuPlanMapper menuPlanMapper;

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
			response = menuPlanMapper.menuDetail(request.getMenuId());
		}
		return response;
	}

}
