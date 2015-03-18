package com.guozha.buyserver.common.util;

/**
 * 价格计算
 * @Package com.guozha.buyserver.common.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-2-18 上午9:10:35
 */
public class PriceUtils {
	
	
	/**
	 * 商品价格计算
	 * @param unitPrice 单价
	 * @param amount   分量
	 * @param unit     计量单位
	 * @return
	 */
	public static int getGoodsPrice(int unitPrice,int amount,String unit){
		int price =0;
		if("01".equals(unit)){
			double d = ((double)amount/500)*unitPrice;
			price= (int)d;
		}else if("02".equals(unit)){
			price = unitPrice*amount;
		}else if("03".equals(unit)){
			price = unitPrice*amount;
		}else if("04".equals(unit)){
			price = unitPrice*amount;
		}else if("05".equals(unit)){
			price = unitPrice*amount;
		}else if("06".equals(unit)){
			price = unitPrice*amount;
		}else if("07".equals(unit)){
			price = unitPrice*amount;
		}else if("08".equals(unit)){
			price = unitPrice*amount;
		}
		return price;
	}
	
	
	public static int getMenuPrice(int unitPrice,int amount,String unit){
		return 0;
	}
}
