package com.guozha.buyserver.service.cart.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guozha.buyserver.framework.junit.BaseJunitCase;
import com.guozha.buyserver.service.cart.CartService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.cart.CartRequest;
import com.guozha.buyserver.web.controller.cart.CartResponse;

/**
 * 购物车单元测试
 * @Package com.guozha.buyserver.service.cart.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-27 下午12:59:34
 */
public class CartServiceImplTest extends BaseJunitCase{
	
	@Autowired
	private CartService cartService;
	
	/**
	 * 测试 购物车添加食材
	 */
	@Test
	public void testAddGoods(){
		CartRequest request = new CartRequest();
		Integer userId =6;
		Integer id =1;
		Integer [] amount = new Integer[]{200};
		String productType ="02";  
		Integer addressId =1;
		
		assertNotNull("userId is null", userId);
		assertNotNull("id is null", id);
		assertNotNull("amount is null", amount);
		assertNotNull("productType is null", productType);
		assertEquals("productType must be equals 02", productType, "02");
		
		request.setUserId(userId);
		request.setId(id);
		request.setAmount(amount);
		request.setProductType(productType);
		request.setAddressId(addressId);
		
		MsgResponse response = this.cartService.add(request);
		assertNotNull("Response is null", response);
		assertEquals("add cart failure", response.getReturnCode(), "1");
	}
	
	/**
	 * 测试 购物车添加食材
	 */
	@Test
	public void testAddMenu(){
		CartRequest request = new CartRequest();
		Integer userId =6;
		Integer id =1;
		Integer [] amount = new Integer[]{1};
		String productType ="01";
		Integer addressId =1;
		
		assertNotNull("userId is null", userId);
		assertNotNull("id is null", id);
		assertNotNull("amount is null", amount);
		assertNotNull("productType is null", productType);
		assertEquals("productType must be equals 01", productType, "01");
		
		request.setUserId(userId);
		request.setId(id);
		request.setAmount(amount);
		request.setProductType(productType);
		request.setAddressId(addressId);
		
		MsgResponse response = this.cartService.add(request);
		assertNotNull("Response is null", response);
		assertEquals("add cart failure", response.getReturnCode(), "1");
	}
	
	/**
	 * 删除购物车信息
	 */
	@Test
	public void testDel(){
		CartRequest request = new CartRequest();
		Integer [] cardId = new Integer[]{1};
		
		assertNotNull("cartId is null", cardId);
		
		request.setCartId(cardId);
		
		MsgResponse response = this.cartService.del(request);
		assertNotNull("Response is null", response);
		assertEquals("add cart failure", response.getReturnCode(), "1");
	}
	
	/**
	 * 清空购物车
	 */
	@Test 	
	@Ignore
	public void testClear(){
		Integer userId =6;
		CartRequest request = new CartRequest();
	
		assertNotNull("userId is null", userId);
		
		request.setUserId(userId);
		MsgResponse response = this.cartService.clear(request);
		assertNotNull("Response is null", response);
		assertEquals("add cart failure", response.getReturnCode(), "1");
		
	}
	
	
	/**
	 * 修改购物车
	 */
	@Test
	public void testUpdate(){
		
		CartRequest request = new CartRequest();
		Integer [] cardId = new Integer[]{1,2};
		Integer [] amount = new Integer[]{200,50};
		Integer userId =6;
		assertNotNull("cartIds is null", cardId);
		assertNotNull("amounts is null", amount);
		assertNotNull("userId is null",  userId);
		
		request.setCartId(cardId);
		request.setAmount(amount);
		request.setUserId(userId);
		MsgResponse response = this.cartService.update(request);
		assertNotNull("Response is null", response);
		assertEquals("add cart failure", response.getReturnCode(), "1");
	}
	
	/**
	 * 购物车查询
	 */
	@Test
	public void testList(){
		CartRequest request = new CartRequest();
		Integer userId =6;
		assertNotNull("userId is null",  userId);
		request.setUserId(userId);
		CartResponse response = this.cartService.find(request);
		assertNotNull("Response is null", response);
	}
}
