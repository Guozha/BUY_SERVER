package com.guozha.buyserver.web.controller.account;

/**
 * 我的邀请
 * 
 * @author sunhanbin
 * @date 2015-03-13
 */
public class InviteResponse {
	
	private int drawAmount;	//领用数
	private int usedAmount;	//使用数
	private int awardPrice;//	奖励菜票金额
	
	public int getDrawAmount() {
		return drawAmount;
	}
	public void setDrawAmount(int drawAmount) {
		this.drawAmount = drawAmount;
	}
	public int getUsedAmount() {
		return usedAmount;
	}
	public void setUsedAmount(int usedAmount) {
		this.usedAmount = usedAmount;
	}
	public int getAwardPrice() {
		return awardPrice;
	}
	public void setAwardPrice(int awardPrice) {
		this.awardPrice = awardPrice;
	}
	
	


}
