package com.guozha.buyserver.persistence.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.MnuMenuGoods;

/**
 * 菜谱映射
 * 
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 上午11:08:00
 */
@Repository
public interface MnuMenuMapper extends BaseMapper<MnuMenu, Integer> {

	/**
	 * 商品id查询菜谱
	 * 
	 * @param goodsId
	 * @return
	 */
	List<MnuMenu> findByGoodsId(int goodsId);

	/**
	 * 查询菜谱配置
	 * 
	 * @param menuId
	 * @return
	 */
	List<MnuMenuGoods> findGoodsById(int menuId);

	/**
	 * 商品id查询菜谱
	 * 
	 * @param goodsIds 数组 一个或多个
	 * @return
	 */
	List<MnuMenu> findByGoodsIds(@Param("goodsIds") int[] goodsIds);

	/**
	 * 根据菜谱id查找菜谱
	 * 
	 * @param goodsIds 数组 一个或多个
	 * @return
	 */
	List<MnuMenu> listMenuByIds(@Param("menuIds") Set<Integer> menuIds);

}
