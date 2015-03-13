package com.guozha.buyserver.framework.enums;

/**
 * 菜票奖励
 * 
 * @author sunhanbin
 * 
 */
public enum TicketRewardEnum {

	drawReward(1), usedReward(5);

	private int reward;// 奖励

	TicketRewardEnum(int reward) {
		this.reward = reward;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}
}
