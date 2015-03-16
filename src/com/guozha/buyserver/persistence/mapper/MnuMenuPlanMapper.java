package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.MnuMenuPlan;
import com.guozha.buyserver.persistence.beans.MnuMenuStep;
import com.guozha.buyserver.persistence.beans.MnuUserMenuPlan;
import com.guozha.buyserver.web.controller.menuplan.MenuPlanResponse;
import com.guozha.buyserver.web.controller.menuplan.MenuResponse;

/**
 * 菜谱计划映射
 * 
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author sunhanbin
 * @date 2015-3-11 下午5:35:17
 */
@Repository
public interface MnuMenuPlanMapper extends BaseMapper<MnuMenuPlan, Integer> {

	// 新增菜谱计划
	int insertUserMenuPlan(MnuUserMenuPlan menuUserPlan);

	// 菜谱推荐
	List<MenuPlanResponse> listMenuPlan();

	// 查询菜谱详情
	MenuResponse menuDetail(int menuId);

	// 获取菜谱制作详情
	List<MnuMenuStep> listMenuCookStep(int menuId);

}
