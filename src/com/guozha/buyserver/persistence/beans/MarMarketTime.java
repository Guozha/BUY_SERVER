package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

public class MarMarketTime extends AbstractDO{
	
	private Integer marketTimeId;
	private Integer marketId;
	private Integer fromTime;
	private Integer toTime;
	
	public Integer getMarketTimeId() {
		return marketTimeId;
	}
	public void setMarketTimeId(Integer marketTimeId) {
		this.marketTimeId = marketTimeId;
	}
	public Integer getMarketId() {
		return marketId;
	}
	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}
	public Integer getFromTime() {
		return fromTime;
	}
	public void setFromTime(Integer fromTime) {
		this.fromTime = fromTime;
	}
	public Integer getToTime() {
		return toTime;
	}
	public void setToTime(Integer toTime) {
		this.toTime = toTime;
	}
	

}
