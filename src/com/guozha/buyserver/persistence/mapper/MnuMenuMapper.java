package com.guozha.buyserver.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.MnuMenuGoods;

/**
 * 菜谱映射
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 上午11:08:00
 */
@Repository
public interface MnuMenuMapper extends BaseMapper<MnuMenu, Integer> {
	
     List<MnuMenu> findByGoodsId(int goodsId);
     
     /**
      * 查询菜谱配置
      * @param menuId
      * @return
      */
     List<MnuMenuGoods> findGoodsById(int menuId);
}
