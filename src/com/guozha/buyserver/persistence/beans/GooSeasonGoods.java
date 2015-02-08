package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 节气食材
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO(用一句话描述该文件做什么)
 * @author txf
 * @date 2015-3-11 上午10:53:35
 */
public class GooSeasonGoods extends AbstractDO {
	private Integer seasonGoodsId;
	private String season;
	private String seasonPicUrl;
	private Integer firstGoodsId;
	private Integer secondGoodsId;
	private Integer thirdGoodsId;
	private Integer fourGoodsId;
	private Integer fiveGoodsId;
	
	
	public Integer getSeasonGoodsId() {
		return seasonGoodsId;
	}
	public void setSeasonGoodsId(Integer seasonGoodsId) {
		this.seasonGoodsId = seasonGoodsId;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getSeasonPicUrl() {
		return seasonPicUrl;
	}
	public void setSeasonPicUrl(String seasonPicUrl) {
		this.seasonPicUrl = seasonPicUrl;
	}
	public Integer getFirstGoodsId() {
		return firstGoodsId;
	}
	public void setFirstGoodsId(Integer firstGoodsId) {
		this.firstGoodsId = firstGoodsId;
	}
	public Integer getSecondGoodsId() {
		return secondGoodsId;
	}
	public void setSecondGoodsId(Integer secondGoodsId) {
		this.secondGoodsId = secondGoodsId;
	}
	public Integer getThirdGoodsId() {
		return thirdGoodsId;
	}
	public void setThirdGoodsId(Integer thirdGoodsId) {
		this.thirdGoodsId = thirdGoodsId;
	}
	public Integer getFourGoodsId() {
		return fourGoodsId;
	}
	public void setFourGoodsId(Integer fourGoodsId) {
		this.fourGoodsId = fourGoodsId;
	}
	public Integer getFiveGoodsId() {
		return fiveGoodsId;
	}
	public void setFiveGoodsId(Integer fiveGoodsId) {
		this.fiveGoodsId = fiveGoodsId;
	}

}
