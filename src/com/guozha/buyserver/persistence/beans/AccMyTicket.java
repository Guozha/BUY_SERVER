package com.guozha.buyserver.persistence.beans;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * 我的菜票
 * 
 * @author sunhanbin
 * @date 2015-03-12
 */
public class AccMyTicket extends AbstractDO {

	private Integer myTicketId;// 我的菜票ID
	private Integer userId;// 归属用户ID
	private String ticketType;// '01-注册赠送,02-好友赠送,03-推广收益,04-售后赠送',
	private int parValue;// 面值
	private int forPrice;// 使用金额下限
	private String ticketNo;// 菜票编号
	private String gotTime;// 收获时间
	private String validDate;// 有效期
	private String useTime;// 使用时间
	private Integer orderId;// 使用订单ID
	private String orderNo;// 使用订单号
	private String status;// 状态
	public int getMyTicketId() {
		return myTicketId;
	}
	public void setMyTicketId(int myTicketId) {
		this.myTicketId = myTicketId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public int getParValue() {
		return parValue;
	}
	public void setParValue(int parValue) {
		this.parValue = parValue;
	}
	public int getForPrice() {
		return forPrice;
	}
	public void setForPrice(int forPrice) {
		this.forPrice = forPrice;
	}
	public String getGotTime() {
		return gotTime;
	}
	public void setGotTime(String gotTime) {
		this.gotTime = gotTime;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public void setMyTicketId(Integer myTicketId) {
		this.myTicketId = myTicketId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}
