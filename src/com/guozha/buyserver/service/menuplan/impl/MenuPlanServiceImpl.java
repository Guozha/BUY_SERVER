package com.guozha.buyserver.service.menuplan.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.DateUtil;
import com.guozha.buyserver.framework.enums.ReturnCodeEnum;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.MnuMenuGoods;
import com.guozha.buyserver.persistence.beans.MnuMenuStep;
import com.guozha.buyserver.persistence.beans.MnuUserMenuPlan;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuPlanMapper;
import com.guozha.buyserver.service.account.ReturnCode;
import com.guozha.buyserver.service.menuplan.MenuPlanService;
import com.guozha.buyserver.web.controller.menuplan.MenuDetailRequest;
import com.guozha.buyserver.web.controller.menuplan.MenuPlanResponse;
import com.guozha.buyserver.web.controller.menuplan.MenuResponse;
import com.guozha.buyserver.web.controller.menuplan.MenuUserPlanRequest;
import com.guozha.buyserver.web.controller.menuplan.TodayInfoResponse;

/**
 * 菜谱计划
 * 
 * @author sunhanbin
 * @date 2015-03-15
 * 
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class MenuPlanServiceImpl extends AbstractBusinessObjectServiceMgr implements MenuPlanService {

	@Autowired
	private MnuMenuPlanMapper menuPlanMapper;
	@Autowired
	private MnuMenuMapper mnuMenuMapper;

	/**
	 * 首页：今日信息
	 * 
	 * @author sunhanbin
	 * @date 2015-03-15
	 */
	public TodayInfoResponse getTodayInfo() {
		TodayInfoResponse response = new TodayInfoResponse();
		response.setToday(DateUtil.getTodayInCN());// XXXX年XX月XX日
		response.setLunarToday(DateUtil.getLunarCalendarMMDD());// 农历
		response.setDayDesc(menuPlanMapper.getTodayInfo(DateUtil.getToday()));
		return response;
	}

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
	// public List<MenuPlanResponse> listMenuPlan() {
	// List<MenuPlanResponse> menuPlans = menuPlanMapper.listMenuPlan();
	// Set<Integer> menuIds = new HashSet<Integer>();
	// Map<Integer, MnuMenu> menuMap = new HashMap<Integer, MnuMenu>();
	// for (MenuPlanResponse plan : menuPlans) {
	// if (plan != null) {
	// menuIds.add(plan.getFirstMenuId());
	// menuIds.add(plan.getSecondMenuId());
	// menuIds.add(plan.getThirdMenuId());
	// menuIds.add(plan.getFourMenuId());
	// menuIds.add(plan.getFiveMenuId());
	// menuIds.add(plan.getSixMenuId());
	// }
	// }
	// // 查找菜谱信息
	// menuMap = listMenuByIds(menuIds);
	// int menuId = 0;
	// MnuMenu menu = null;
	// // 每个菜谱设置菜谱信息
	// for (MenuPlanResponse plan : menuPlans) {
	// if (plan != null) {
	// menuId = plan.getFirstMenuId();
	// if (menuMap.containsKey(menuId)) {
	// menu = menuMap.get(menuId);
	// plan.setFirstMenuImg(menu.getMenuImg());
	// plan.setFirstMenuName(menu.getMenuName());
	// }
	// menuId = plan.getSecondMenuId();
	// if (menuMap.containsKey(menuId)) {
	// menu = menuMap.get(menuId);
	// plan.setSecondMenuImg(menu.getMenuImg());
	// plan.setSecondMenuName(menu.getMenuName());
	// }
	// menuId = plan.getThirdMenuId();
	// if (menuMap.containsKey(menuId)) {
	// menu = menuMap.get(menuId);
	// plan.setThirdMenuImg(menu.getMenuImg());
	// plan.setThirdMenuName(menu.getMenuName());
	// }
	// menuId = plan.getFourMenuId();
	// if (menuMap.containsKey(menuId)) {
	// menu = menuMap.get(menuId);
	// plan.setFourMenuImg(menu.getMenuImg());
	// plan.setFourMenuName(menu.getMenuName());
	// }
	// menuId = plan.getFiveMenuId();
	// if (menuMap.containsKey(menuId)) {
	// menu = menuMap.get(menuId);
	// plan.setFiveMenuImg(menu.getMenuImg());
	// plan.setFiveMenuName(menu.getMenuName());
	// }
	// menuId = plan.getSixMenuId();
	// if (menuMap.containsKey(menuId)) {
	// menu = menuMap.get(menuId);
	// plan.setSixMenuImg(menu.getMenuImg());
	// plan.setSixMenuName(menu.getMenuName());
	// }
	// menu = null;
	// }
	// }
	// return menuPlans;
	// }

	public MenuPlanResponse listMenuPlan(String planDate) {
		MenuPlanResponse menuPlan = menuPlanMapper.listMenuPlan(planDate);
		Set<Integer> menuIds = new HashSet<Integer>();
		int firstMenuId = menuPlan.getFirstMenuId();
		int secondMenuId = menuPlan.getSecondMenuId();
		int thirdMenuId = menuPlan.getThirdMenuId();
		int fourMenuId = menuPlan.getFourMenuId();
		int fiveMenuId = menuPlan.getFiveMenuId();
		int sixMenuId = menuPlan.getSixMenuId();
		menuIds.add(firstMenuId);
		menuIds.add(secondMenuId);
		menuIds.add(thirdMenuId);
		menuIds.add(fourMenuId);
		menuIds.add(fiveMenuId);
		menuIds.add(sixMenuId);
		Map<Integer, MnuMenu> menuMap = listMenuByIds(menuIds);
		MnuMenu menu = menuMap.get(firstMenuId);
		menuPlan.setFirstMenuImg(menu.getMenuImg());
		menuPlan.setFirstMenuName(menu.getMenuName());
		menu = menuMap.get(secondMenuId);
		menuPlan.setSecondMenuImg(menu.getMenuImg());
		menuPlan.setSecondMenuName(menu.getMenuName());
		menu = menuMap.get(thirdMenuId);
		menuPlan.setThirdMenuImg(menu.getMenuImg());
		menuPlan.setThirdMenuName(menu.getMenuName());
		menu = menuMap.get(fourMenuId);
		menuPlan.setFourMenuImg(menu.getMenuImg());
		menuPlan.setFourMenuName(menu.getMenuName());
		menu = menuMap.get(fiveMenuId);
		menuPlan.setFiveMenuImg(menu.getMenuImg());
		menuPlan.setFiveMenuName(menu.getMenuName());
		menu = menuMap.get(sixMenuId);
		menuPlan.setSixMenuImg(menu.getMenuImg());
		menuPlan.setSixMenuName(menu.getMenuName());
		return menuPlan;
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
		for (MnuMenu po : pos) {
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

	/**
	 * 通过菜谱ID查找菜谱
	 * 
	 * @author sunhanbin
	 * @date 2015-03-26
	 * @param menuIds
	 * @return
	 */
	public Map<Integer, MnuMenu> listMenuByIds(Set<Integer> menuIds) {
		List<MnuMenu> menus = mnuMenuMapper.listMenuByIds(menuIds);
		Map<Integer, MnuMenu> menuMap = new HashMap<Integer, MnuMenu>();
		if (menus != null && menus.size() > 0) {
			for (MnuMenu menu : menus) {
				if (menu != null) {
					menuMap.put(menu.getMenuId(), menu);
				}
			}
		}
		return menuMap;
	}

}
