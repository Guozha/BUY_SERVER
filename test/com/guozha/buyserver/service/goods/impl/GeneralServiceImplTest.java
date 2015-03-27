package com.guozha.buyserver.service.goods.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.service.goods.GeneralService;
import com.guozha.buyserver.web.controller.goods.FrontTypeResponse;
import com.guozha.buyserver.web.controller.goods.GeneralResponse;
import com.guozha.buyserver.web.controller.goods.GoodsInfoResponse;
import com.guozha.buyserver.web.controller.goods.GoodsPriceResponse;
import com.guozha.buyserver.web.controller.goods.GoodsRequest;

/**
 * 商品查询单元测试
 * @Package com.guozha.buyserver.service.goods.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-27 上午11:53:32
 */
public class GeneralServiceImplTest extends BaseJunitCase{
	
	@Autowired
	private GeneralService generalService;
	
	@Test
	public void testFindFrontType(){
		 List<FrontTypeResponse> response = this.generalService.findFrontType();
		 assertNotNull("Response is null", response);
	}
	
	/**
	 * 类目商品 测试地址为空的情况
	 */
	@Test
	public void testFindGoodsAndAddressIdIsNull(){
		GoodsRequest request = new GoodsRequest();
		request.setAddressId(null);
		request.setFrontTypeId(1);
		assertNotNull("frontTypeId is null",request.getFrontTypeId());
		GeneralResponse response = this.generalService.findGoodsByFrontTypeId(request);
		assertNotNull("Response is null", response);
	}
    
	/**
	 * 类目商品  测试地址不为空的情况
	 */
	@Test
	public void testFindGoodsByFrontTypeIdAndAddressIdIsNotNull(){
		GoodsRequest request = new GoodsRequest();
		request.setAddressId(1);
		request.setFrontTypeId(1);
		assertNotNull("frontTypeId is null",request.getFrontTypeId());
		GeneralResponse response = this.generalService.findGoodsByFrontTypeId(request);
		assertNotNull("Response is null", response);
	}
	
	
	/**
	 * 逛菜场 测试地址为空的情况
	 */
	@Test
	public void testFindGoodsByFrontTypeIdAndAddressIdIsNull(){
		GoodsRequest request = new GoodsRequest();
		request.setAddressId(null);
		GeneralResponse response = this.generalService.findGoods(request);
		assertNotNull("Response is null", response);
	}
    
	/**
	 * 逛菜场  测试地址不为空的情况
	 */
	@Test
	public void testFindGoodsAndAddressIdIsNotNull(){
		GoodsRequest request = new GoodsRequest();
		request.setAddressId(1);
		GeneralResponse response = this.generalService.findGoods(request);
		assertNotNull("Response is null", response);
	}
	
	/**
	 * 商品明细查询 测试地址为空的情况
	 */
	@Test
	public void testFindByGoodsIdAndAddressIdIsNull(){
		GoodsRequest request = new GoodsRequest();
		request.setAddressId(null);
		request.setGoodsId(1);
		assertNotNull("goodsId is null",request.getGoodsId());
		GoodsInfoResponse response = this.generalService.findGoodsById(request);
		assertNotNull("Response is null", response);
	}
	
	/**
	 * 商品明细查询 测试地址不为空的情况
	 */
	@Test
	public void testFindByGoodsIdAndAddressIdIsNotNull(){
		GoodsRequest request = new GoodsRequest();
		request.setAddressId(1);
		request.setGoodsId(1);
		assertNotNull("goodsId is null",request.getGoodsId());
		GoodsInfoResponse response = this.generalService.findGoodsById(request);
		assertNotNull("Response is null", response);
	}
	
	/**
	 * 商品价格  测试地址为空的情况
	 */
	@Test
	public void testFindGoodsPriceByGoodsIdAndAddressIdIsNull(){
		GoodsRequest request = new GoodsRequest();
		request.setAddressId(null);
		request.setGoodsId(1);
		assertNotNull("goodsId is null",request.getGoodsId());
		List<GoodsPriceResponse> response = this.generalService.findGoodsPriceByGoodsId(request);
		assertNotNull("Response is null", response);
	}
	
	/**
	 * 商品价格  测试地址不为空的情况
	 */
	@Test
	public void testFindGoodsPriceByGoodsIdAndAddressIdIsNotNull(){
		GoodsRequest request = new GoodsRequest();
		request.setAddressId(1);
		request.setGoodsId(1);
		assertNotNull("goodsId is null",request.getGoodsId());
		List<GoodsPriceResponse> response = this.generalService.findGoodsPriceByGoodsId(request);
		assertNotNull("Response is null", response);
	}
	
	
}
