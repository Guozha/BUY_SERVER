package com.guozha.buyserver.service.menuplan;

import java.util.List;

import com.guozha.buyserver.service.account.ReturnCode;
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
public interface MenuPlanService {

	// 新增菜谱
	ReturnCode insert(MenuUserPlanRequest request);

	// 推荐菜谱计划
	List<MenuPlanResponse> listMenuPlan();

	// 菜谱菜品详情
	MenuResponse detail(MenuDetailRequest request);

	/**
	 * 商品菜谱查询
	 * 
	 * @author txf
	 * @date 2015-03-23
	 * @param goodsId
	 * @return
	 */
	List<MenuResponse> findByGoodsId(int goodsId);

	// 首页：今日信息
	TodayInfoResponse getTodayInfo();

}
