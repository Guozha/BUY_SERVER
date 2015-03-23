package com.guozha.buyserver.service.menuplan;

import java.util.List;

import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.service.account.ReturnCode;
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
public interface MenuPlanService {

	// 新增菜谱
	ReturnCode insert(MenuUserPlanRequest request);

	// 推荐菜谱
	List<MnuMenu> listMenu();

	// 菜谱菜品详情
	MenuResponse detail(MenuDetailRequest request);
	
	
	/**
	 * 商品菜谱查询
	 * @author txf
	 * @date 2015-03-23
	 * @param goodsId
	 * @return
	 */
	List<MenuResponse> findByGoodsId(int goodsId);

}
