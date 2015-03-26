package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: 发放人菜票统计表
 * @author sunhanbin
 * @date 2015-3-25 上午11:03:36
 */
public class AccMyTicketCount extends AbstractDO {
	
	private Integer userId;
	private Integer ticketDrawCount;//已领用的菜票数量
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTicketDrawCount() {
		return ticketDrawCount;
	}
	public void setTicketDrawCount(Integer ticketDrawCount) {
		this.ticketDrawCount = ticketDrawCount;
	}
	
	

}
