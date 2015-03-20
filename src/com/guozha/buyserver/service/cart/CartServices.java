package com.guozha.buyserver.service.cart;


import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.cart.CartRequest;
import com.guozha.buyserver.web.controller.cart.CartResponses;

public interface CartServices {
	/**
	 * 修改购物车
	 * @param vo
	 * @return
	 */
	MsgResponse update(CartRequest vo);
	
	/**
	 * 删除购物车
	 * @param vo
	 * @return
	 */
	MsgResponse del(CartRequest vo);
	
	/**
	 * 购物车清空
	 * @param vo
	 * @return
	 */
	MsgResponse clear(CartRequest vo);
	
	/**
	 * 购物车查询
	 * @param vo
	 * @return
	 */
	CartResponses find(CartRequest vo);
	
	/**
	 * 添加购物车
	 * @param vo
	 * @return
	 */
	MsgResponse add(CartRequest vo);
	
	/**
	 * 获得菜谱单价
	 * @param marketId
	 * @param menuId
	 * @return
	 */
	int getMenuUnitPrice(int marketId,int menuId);
}
