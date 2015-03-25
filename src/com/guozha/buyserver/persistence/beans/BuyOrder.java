package com.guozha.buyserver.persistence.beans;

import java.util.Date;

import com.guozha.buyserver.dal.object.AbstractDO;

public class BuyOrder extends AbstractDO {
	
	private Integer orderId;
	private String orderNo;
	private String orderType;
	private Integer userId;
	private Integer quantity;
	private String receiveMen;
	private String receiveMobile;
	private String receiveAddr;
	private Date aboutArrivalTime;
	private Integer wantUpTime;
	private Integer wantDownTime;
	private String memo;
	private Date createTime;
	private Integer totalPrice;
	private Integer balanceDecPrice;
	private Integer ticketDecPrice;
	private Integer beanDecPrice;
	private Integer serviceFee;
	private Integer payPrice;
	private String payWay;
	private String arrivalPayFlag;
	private Double inteFeeRate;
	private Double inteFee;
	private Date payTime;
	private Integer senderId;
	private Date finishTime;
	private String commentFlag;
	private String serviceStar;
	private String commentDesc;
	private String finishSettleFlag;
	private String status;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getReceiveMen() {
		return receiveMen;
	}
	public void setReceiveMen(String receiveMen) {
		this.receiveMen = receiveMen;
	}
	public String getReceiveMobile() {
		return receiveMobile;
	}
	public void setReceiveMobile(String receiveMobile) {
		this.receiveMobile = receiveMobile;
	}
	public String getReceiveAddr() {
		return receiveAddr;
	}
	public void setReceiveAddr(String receiveAddr) {
		this.receiveAddr = receiveAddr;
	}
	public Date getAboutArrivalTime() {
		return aboutArrivalTime;
	}
	public void setAboutArrivalTime(Date aboutArrivalTime) {
		this.aboutArrivalTime = aboutArrivalTime;
	}
	public Integer getWantUpTime() {
		return wantUpTime;
	}
	public void setWantUpTime(Integer wantUpTime) {
		this.wantUpTime = wantUpTime;
	}
	public Integer getWantDownTime() {
		return wantDownTime;
	}
	public void setWantDownTime(Integer wantDownTime) {
		this.wantDownTime = wantDownTime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getBalanceDecPrice() {
		return balanceDecPrice;
	}
	public void setBalanceDecPrice(Integer balanceDecPrice) {
		this.balanceDecPrice = balanceDecPrice;
	}
	public Integer getTicketDecPrice() {
		return ticketDecPrice;
	}
	public void setTicketDecPrice(Integer ticketDecPrice) {
		this.ticketDecPrice = ticketDecPrice;
	}
	public Integer getBeanDecPrice() {
		return beanDecPrice;
	}
	public void setBeanDecPrice(Integer beanDecPrice) {
		this.beanDecPrice = beanDecPrice;
	}
	public Integer getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Integer serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Integer getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(Integer payPrice) {
		this.payPrice = payPrice;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getArrivalPayFlag() {
		return arrivalPayFlag;
	}
	public void setArrivalPayFlag(String arrivalPayFlag) {
		this.arrivalPayFlag = arrivalPayFlag;
	}
	public Double getInteFeeRate() {
		return inteFeeRate;
	}
	public void setInteFeeRate(Double inteFeeRate) {
		this.inteFeeRate = inteFeeRate;
	}
	public Double getInteFee() {
		return inteFee;
	}
	public void setInteFee(Double inteFee) {
		this.inteFee = inteFee;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public String getCommentFlag() {
		return commentFlag;
	}
	public void setCommentFlag(String commentFlag) {
		this.commentFlag = commentFlag;
	}
	public String getServiceStar() {
		return serviceStar;
	}
	public void setServiceStar(String serviceStar) {
		this.serviceStar = serviceStar;
	}
	public String getCommentDesc() {
		return commentDesc;
	}
	public void setCommentDesc(String commentDesc) {
		this.commentDesc = commentDesc;
	}
	public String getFinishSettleFlag() {
		return finishSettleFlag;
	}
	public void setFinishSettleFlag(String finishSettleFlag) {
		this.finishSettleFlag = finishSettleFlag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
