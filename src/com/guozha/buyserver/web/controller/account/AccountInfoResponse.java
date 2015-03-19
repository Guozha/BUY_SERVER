package com.guozha.buyserver.web.controller.account;

/**
 * 我的账户信息
 * 
 * @author sunhanbin
 *@date 2015-03-13
 */
public class AccountInfoResponse {
	
	
	private String mobileNo;//手机号
	private byte[] headImg;//我的头像
	private int balance;//余额
	private int ticketAmount;//菜票数量
	private int beanAmount;//菜豆数量
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getTicketAmount() {
		return ticketAmount;
	}
	public void setTicketAmount(int ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
	public int getBeanAmount() {
		return beanAmount;
	}
	public void setBeanAmount(int beanAmount) {
		this.beanAmount = beanAmount;
	}
	public byte[] getHeadImg() {
		return headImg;
	}
	public void setHeadImg(byte[] headImg) {
		this.headImg = headImg;
	}


}
