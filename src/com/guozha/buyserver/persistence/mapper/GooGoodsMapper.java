package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.web.controller.goods.GoodsResponse;

/**
 * 产品
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-10 下午2:42:49
 */
@Repository
public interface GooGoodsMapper extends BaseMapper<GooGoods, Integer> {
	
	/**
	 * 查询农贸市场的商品
	 * @param marketId
	 * @return
	 */
	List<GoodsResponse> findByMarketId(int marketId);
    
	/**
	 * 查询一级类目商品（不区分特供等商品属性）
	 * @param firstFrontTypeId 一级类目ID
	 * @return
	 */
	List<GoodsResponse> findFirst(@Param("marketId") int marketId,@Param("firstFrontTypeId") int firstFrontTypeId);
	
	/**
	 * 查询二级类目商品 （不区分特供等商品属性）
	 * @param secondFrontTypeId 二级类目ID
	 * @return
	 */
	List<GoodsResponse> findSecond(@Param("marketId") int marketId,@Param("secondFrontTypeId") int secondFrontTypeId);
	
	/**
	 * 查询指定几个ID的商品
	 * @param goodsId
	 * @return
	 */
	List<GooGoods> findByIds(@Param("goodsId")int [] goodsId);
	
	
	/*--------------------------------------------------------------------------------
	 *********************************特供*****************************************
	 *--------------------------------------------------------------------------------*/
	
	/**
	 * 所有商品（仅特供）
	 * @return
	 */
	List<GoodsResponse> findAllSpecial(int marketId);
	
	/**
	 * 查询一级类目商品（仅特供）
	 * @param firstFrontTypeId 一级类目ID
	 * @return
	 */
	List<GoodsResponse> findFirstSpecial(@Param("marketId") int marketId,@Param("firstFrontTypeId") int firstFrontTypeId);
	
	/**
	 * 查询二级类目商品 （仅特供）
	 * @param secondFrontTypeId 二级类目ID
	 * @return
	 */
	List<GoodsResponse> findSecondSpecial(@Param("marketId") int marketId,@Param("secondFrontTypeId") int secondFrontTypeId);
	
	/**
	 * 按菜单查询出商品
	 * @param menuId
	 * @return
	 */
	List<GooGoods> findByMenu(int menuId);
}
