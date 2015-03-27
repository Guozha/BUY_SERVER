/**
 * 
 */
package com.guozha.buyserver.web.controller.menuplan;

/**
 * @Package com.guozha.buyserver.web.controller.menuplan
 * @Description: 首页当天信息，返回报文
 * @author sunhanbin
 * @date 2015-3-27 下午01:29:43
 */
public class TodayInfoResponse {

	private String today;// 今天
	private String lunarToday;// 今天的农历
	private String dayDesc;// 菜谱描述
	
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getLunarToday() {
		return lunarToday;
	}
	public void setLunarToday(String lunarToday) {
		this.lunarToday = lunarToday;
	}
	public String getDayDesc() {
		return dayDesc;
	}
	public void setDayDesc(String dayDesc) {
		this.dayDesc = dayDesc;
	}

}
