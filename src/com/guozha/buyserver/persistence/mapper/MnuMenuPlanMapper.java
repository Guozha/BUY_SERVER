package com.guozha.buyserver.persistence.mapper;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.MnuMenuPlan;
import com.guozha.buyserver.web.controller.menuplan.MenuPlanRequest;

/**
 * 菜谱计划映射
 * 
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 下午5:35:17
 */
@Repository
public interface MnuMenuPlanMapper extends BaseMapper<MnuMenuPlan, Integer> {

	// 新增菜谱计划
	int insertMenuPlan(MenuPlanRequest request);

}
