package com.guozha.buyserver.service.goods.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.service.goods.SpecialService;
import com.guozha.buyserver.web.controller.goods.GoodsInfoResponse;
import com.guozha.buyserver.web.controller.goods.GoodsRequest;
import com.guozha.buyserver.web.controller.goods.GoodsResponse;

/**
 * 特供商品单元测试
 * @Package com.guozha.buyserver.service.goods.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-27 下午12:44:45
 */
public class SpecialServiceImplTest extends BaseJunitCase{
	@Autowired
    private SpecialService specialService;
	
	/**
	 * 特供 
	 */
	@Test
	public void testFindGoods(){
		GoodsRequest request = new GoodsRequest();
		List<GoodsResponse> response = this.specialService.findGoods(request);
		assertNotNull("Response is null", response);
	}
	
	
	/**
	 * 特供明细
	 */
	@Test
	public void testFindByGoodsId(){
		GoodsRequest request = new GoodsRequest();
		request.setGoodsId(1);
		assertNotNull("goodsId is null",request.getGoodsId());
		GoodsInfoResponse response = this.specialService.findGoodsById(request);
		assertNotNull("Response is null", response);
	}
}
