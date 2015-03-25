package com.guozha.buyserver.persistence.beans;


import java.util.Date;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 节气配置表
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-25 下午2:15:31
 */
public class GooSeasonConfig extends AbstractDO {
	
	private Integer seasonConfigId;
	private String season;
	private Date beginDate;
	private Date endDate;
	private String seasons;
	
	public Integer getSeasonConfigId() {
		return seasonConfigId;
	}
	public void setSeasonConfigId(Integer seasonConfigId) {
		this.seasonConfigId = seasonConfigId;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getSeasons() {
		return seasons;
	}
	public void setSeasons(String seasons) {
		this.seasons = seasons;
	}

}
