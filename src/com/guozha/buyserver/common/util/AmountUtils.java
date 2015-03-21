package com.guozha.buyserver.common.util;

/**
 * 份量计算
 * @author getjack
 *
 */
public class AmountUtils {
	
	/**
	 * 计算菜谱中食材的单价（食材单价取上值）
	 * @param unitPrice
	 * @param amount
	 * @param amounts
	 * @param unit
	 * @return
	 */
	public static int getMenuGoodsAmount(int amount,int amounts[],String unit){
		if("01".equals(unit)){
			for(int i =0;i<amounts.length;i++){
				int configAmount = amounts[i];
				if(configAmount>=amount){
					amount=configAmount;
					break;
				}
			}
		}else if("02".equals(unit)){
		}
		
		return amount;
	}

}
