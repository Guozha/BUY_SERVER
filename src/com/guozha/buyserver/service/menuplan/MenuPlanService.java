package com.guozha.buyserver.service.menuplan;

import com.guozha.buyserver.service.account.ReturnCode;
import com.guozha.buyserver.web.controller.menuplan.MenuPlanRequest;

/**
 * 菜谱计划
 * 
 * @author sunhanbin
 * @date 2015-03-15
 * 
 */
public interface MenuPlanService {

	// 新增菜谱
	ReturnCode insert(MenuPlanRequest request);

}
