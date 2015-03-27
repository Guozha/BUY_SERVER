package com.guozha.buyserver.service.season.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.service.season.SeasonService;
import com.guozha.buyserver.web.controller.season.SeasonResponse;

/**
 * 节气食材单元测试
 * @Package com.guozha.buyserver.service.season.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-27 下午2:29:36
 */
public class SeasonServiceImplTest extends BaseJunitCase {
	
	@Autowired
	private SeasonService seasonService;
	
	@Test
	public void testFind(){
		List<SeasonResponse> response = this.seasonService.find();
		assertNotNull("Response is null", response);
	}

}
