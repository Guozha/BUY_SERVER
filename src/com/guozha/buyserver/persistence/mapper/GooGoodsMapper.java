package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.service.goods.GoodsBo;
import com.guozha.buyserver.web.controller.goods.Goods;
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
	//List<GoodsBo> findByMarketId(int marketId);
    
	/**
	 * 查询一级类目商品（不区分特供等商品属性）
	 * @param firstFrontTypeId 一级类目ID
	 * @return
	 */
	//List<GoodsResponse> findFirst(@Param("marketId") int marketId,@Param("firstFrontTypeId") int firstFrontTypeId);
	
	/**
	 * 查询二级类目商品 （不区分特供等商品属性）
	 * @param secondFrontTypeId 二级类目ID
	 * @return
	 */
	//List<GoodsResponse> findSecond(@Param("marketId") int marketId,@Param("secondFrontTypeId") int secondFrontTypeId);
	
	/**
	 * 节气食材中查询指定几个ID的商品
	 * @param goodsId
	 * @return
	 */
	List<GooGoods> findByIds(@Param("goodsId")int [] goodsId);
	
    /**
     * 根据一级类目id查询6条商品信息
     * @param marketId
     * @param firstFrontTypeId
     * @param startIndex
     * @param pageSize
     * @return
     */
	List<Goods> findLimit6ByFirstFrontTypeId(@Param("marketId") int marketId,@Param("firstFrontTypeId") int firstFrontTypeId);
	
	/**
	 * 根据一级类目id查询商品分页
	 * @param marketId
	 * @param firstFrontTypeId
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Goods> findPagerByFirstFrontTypeId(@Param("marketId") int marketId,@Param("firstFrontTypeId") int firstFrontTypeId,@Param("startIndex")int startIndex, @Param("pageSize")int pageSize);
	
	/**
	 * 根据二级类目id查询商品分页
	 * @param marketId
	 * @param firstFrontTypeId
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Goods> findPagerBySecondFrontTypeId(@Param("marketId") int marketId,@Param("secondFrontTypeId") int secondFrontTypeId,@Param("startIndex")int startIndex, @Param("pageSize")int pageSize);
	
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
