package com.guozha.buyserver.web.controller.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDetailResponse {
	
	private Integer orderId;
	private String orderNo;
	private Date createTime;
	private Date aboutArrivalTime;
	private Integer wantUpTime;
	private Integer wantDownTime;
	private String receiveMen;
	private String receiveMobile;
	private String receiveAddr;
	private Integer quantity;
	private Integer totalPrice;
	private String status;
	private List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
	private List<MenuInfo> menuInfoList = new ArrayList<MenuInfo>();
	
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
	public List<MenuInfo> getMenuInfoList() {
		return menuInfoList;
	}
	public void setMenuInfoList(List<MenuInfo> menuInfoList) {
		this.menuInfoList = menuInfoList;
	}
	

}
