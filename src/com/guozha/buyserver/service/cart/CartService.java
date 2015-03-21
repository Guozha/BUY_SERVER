package com.guozha.buyserver.service.cart;


import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.cart.CartRequest;
import com.guozha.buyserver.web.controller.cart.CartResponse;

/**
 * 购物车service
 * @Package com.guozha.buyserver.service.cart
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-13 上午10:59:50
 */
public interface CartService  extends BusinessObjectServiceMgr{
	
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
    CartResponse find(CartRequest vo);
	
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
