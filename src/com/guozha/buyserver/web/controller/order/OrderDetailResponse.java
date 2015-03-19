package com.guozha.buyserver.web.controller.order;

import java.util.Date;
import java.util.List;

public class OrderDetailResponse {
	
	private Integer orderId;
	private String orderNo;
	private Date createTime;
	private Date arrivalTime;
	private String receiveMen;
	private String receiveMobile;
	private String receiveAddr;
	private Integer quantity;
	private Integer totalPrice;
	private String status;
	private List<GoodsInfo> goodsInfoList;
	
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<GoodsInfo> getGoodsInfoList() {
		return goodsInfoList;
	}
	public void setGoodsInfoList(List<GoodsInfo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}
	

}
