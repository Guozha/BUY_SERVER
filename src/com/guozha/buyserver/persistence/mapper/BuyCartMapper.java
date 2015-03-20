package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.BuyCart;
import com.guozha.buyserver.service.cart.CartBo;

/**
 * 购物车映射
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-13 上午10:58:45
 */
@Repository
public interface BuyCartMapper extends BaseMapper<BuyCart, Integer> {
    
	/**
	 * 查询用户购物车信息
	 * @param userId
	 * @return
	 */
	List<BuyCart> findByUserId(int userId);
	
	/**
	 * 查询购物车菜谱信息
	 * @param userId
	 * @return
	 */
	List<CartBo> findMenuByUserId(int userId);
	
	/**
	 * 查询购物车食材信息
	 * @param userId
	 * @return
	 */
	List<CartBo> findGoodsByUserId(int userId);
	
	/**
	 * 删除用户所有购物车信息
	 * @param userId
	 */
	void deleteByUserId(int userId);
	
	/**
	 * 删除已被用户移除的购物信息
	 * @param userId
	 */
	void deletesNotIn(@Param("userId") int userId,@Param("cartId") Integer [] cardId);
	
	/**
	 * 多购物车信息删除
	 * @param cardId
	 */
	void deletes(@Param("cartId") Integer [] cardId);
	
	/**
	 * 查询验证购物车中是否已存在该产品
	 * @param userId
	 * @param goodsOrMenuId
	 * @return
	 */
	BuyCart selectByGoodsOrMenuId(@Param("userId") Integer userId,@Param("goodsOrMenuId") Integer goodsOrMenuId,@Param("splitType") String splitType);
	
}
