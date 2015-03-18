package com.guozha.buyserver.service.market;


import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;

/**
 * 市场
 * @Package com.guozha.buyserver.service.market
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-18 下午9:01:59
 */
public interface MarketService extends BusinessObjectServiceMgr {
	
	/**
	 * 根据地址id查询对应的农贸市场
	 * 如果未找到 则返回一个默认的农贸市场
	 * 默认的农贸市场配置在system.properties中
	 * @param addressId 地址id(来自app选择地址传入)
	 * @return
	 */
	int findMaketId(Integer addressId);

}
