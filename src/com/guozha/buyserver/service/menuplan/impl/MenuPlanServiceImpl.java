package com.guozha.buyserver.service.menuplan.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guozha.buyserver.persistence.mapper.MnuMenuPlanMapper;
import com.guozha.buyserver.service.account.ReturnCode;
import com.guozha.buyserver.service.menuplan.MenuPlanService;
import com.guozha.buyserver.web.controller.menuplan.MenuPlanRequest;

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
	public ReturnCode insert(MenuPlanRequest request) {
		ReturnCode returncode=null;
		int count=0;
		if(request!=null){
			
		}
//		return menuPlanMapper.insertMenuPlan(request);
		return returncode;
	}

}
