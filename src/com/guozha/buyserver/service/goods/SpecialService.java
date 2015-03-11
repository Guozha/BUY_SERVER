package com.guozha.buyserver.service.goods;

import java.util.List;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;
import com.guozha.buyserver.web.controller.goods.GoodsRequest;
import com.guozha.buyserver.web.controller.goods.GoodsResponse;

/**
 * 特供商品
 * @Package com.guozha.buyserver.service.goods
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-10 下午2:48:36
 */
public interface SpecialService extends BusinessObjectServiceMgr{
	
	/**
	 * 商品查询（特供)
	 * @param vo
	 * @return
	 */
	List<GoodsResponse> findGoods(GoodsRequest vo);

}
