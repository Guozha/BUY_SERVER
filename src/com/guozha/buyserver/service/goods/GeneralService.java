package com.guozha.buyserver.service.goods;

import java.util.List;
import java.util.Map;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.goods.FrontTypeRequest;
import com.guozha.buyserver.web.controller.goods.FrontTypeResponse;
import com.guozha.buyserver.web.controller.goods.GoodsInfoResponse;
import com.guozha.buyserver.web.controller.goods.GoodsMenuResponse;
import com.guozha.buyserver.web.controller.goods.GoodsPriceResponse;
import com.guozha.buyserver.web.controller.goods.GoodsRequest;
import com.guozha.buyserver.web.controller.goods.GoodsResponse;

/**
 * 单品
 * @Package com.guozha.buyserver.service.goods
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-10 下午2:47:59
 */
public interface GeneralService extends BusinessObjectServiceMgr{
	
	/**
	 * 类目查询 按级别
	 * @return
	 */
	List<FrontTypeResponse> findFrontType(FrontTypeRequest vo);
	
	/**
	 * 类目查询 所有
	 * @return
	 */
	List<FrontTypeResponse> findFrontType();
	
	
	/**
	 * 商品查询
	 * 所有的商品均来自某个农贸市场。
	 * @param vo
	 * @return
	 */
	List<GoodsResponse> findGoods(GoodsRequest vo);
	
	/**
	 * 商品详情
	 * @param goodsId 商品id
	 * @return
	 */
	GoodsInfoResponse findGoodsById(int goodsId);
	
	/**
	 * 商品价格配置详情
	 * @param goodsId 商品id
	 * @return
	 */
	List<GoodsPriceResponse> findGoodsPriceByGoodsId(int goodsId);
    
	/**
	 * 商品菜谱查询
	 * @param goodsId
	 * @return
	 */
	List<GoodsMenuResponse> findMenuByGoodsId(int goodsId);
	
	/**
	 * 二级类目
	 * @param parentId
	 * @return
	
	List<FrontTypeBo> findFrontTypeSecond(int parentId);
	
	
	
	
	 * 一级类目商品
	 * @param firstFrontTypeId
	 * @return
	
	List<GoodsBo> findGoodsFirst(int firstFrontTypeId);
	
	
	 * 二级类目商品
	 * @param secondFrontTypeId
	 * @return
	
	List<GoodsBo> findGoodsSecond(int secondFrontTypeId);
	
	
	 * 所有商品
	 * @return
	
	List<GoodsBo> findGoodsAll();
	 */
	
}
