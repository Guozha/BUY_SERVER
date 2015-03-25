package com.guozha.buyserver.service.common;

import com.guozha.buyserver.framework.sys.business.BusinessObjectServiceMgr;

public interface CommonService extends BusinessObjectServiceMgr {
	
	String getPaperNo(String areaCode, String paperType);
	
	/**
	 * 根据地址id查询对应的农贸市场
	 * 如果未找到 则返回一个默认的农贸市场
	 * 默认的农贸市场配置在system.properties中
	 * @param addressId 地址id(来自app选择地址传入)
	 * @return
	 */
	int getMaketId(Integer addressId);
	
	/**
	 * 计算菜谱单价（食材取上值）
	 * @param marketId
	 * @param menuId
	 * @return
	 */
	int getMenuUnitPrice(int marketId, int menuId);
	
	/**
	 * 计算菜谱中食材的上值份量
	 * @param marketId
	 * @param goodsId
	 * @return
	 */
	int getMenuGoodsAmount(int goodsId,int amount);

}
