package com.guozha.buyserver.service.account;

import java.io.Serializable;
import java.util.Date;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObject;
import com.guozha.buyserver.persistence.beans.SysUser;

public class User extends AbstractBusinessObject {
	
	private SysUser sysUser;
	
	public User(){
		this.sysUser = new SysUser();
	}
	
	public User(SysUser sysUser){
		this.sysUser = sysUser;
	}

	@Override
	public Serializable getId() {
		return this.sysUser.getUserId();
	}
	
	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Integer getUserId() {
		return this.sysUser.getUserId();
	}
	public void setUserId(Integer userId) {
		this.sysUser.setUserId(userId);
	}
	public String getMobileNo() {
		return this.sysUser.getMobileNo();
	}
	public void setMobileNo(String mobileNo) {
		this.sysUser.setMobileNo(mobileNo);
	}
	public String getHeadUrl() {
		return this.sysUser.getHeadUrl();
	}
	public void setHeadUrl(String headUrl) {
		this.sysUser.setHeadUrl(headUrl);
	}
	public String getPasswd() {
		return this.sysUser.getPasswd();
	}
	public void setPasswd(String passwd) {
		this.sysUser.setPasswd(passwd);
	}
	public int getBalance() {
		return this.sysUser.getBalance();
	}
	public void setBalance(int balance) {
		this.sysUser.setBalance(balance);
	}
	public int getTicketAmount() {
		return this.sysUser.getTicketAmount();
	}
	public void setTicketAmount(int ticketAmount) {
		this.sysUser.setTicketAmount(ticketAmount);
	}
	public int getBeanAmount() {
		return this.sysUser.getBeanAmount();
	}
	public void setBeanAmount(int beanAmount) {
		this.sysUser.setBeanAmount(beanAmount);
	}
	public String getAftersaleTicketFlag() {
		return this.sysUser.getAftersaleTicketFlag();
	}
	public void setAftersaleTicketFlag(String aftersaleTicketFlag) {
		this.sysUser.setAftersaleTicketFlag(aftersaleTicketFlag);
	}
	public String getPlanNotiFlag() {
		return this.sysUser.getPlanNotiFlag();
	}
	public void setPlanNotiFlag(String planNotiFlag) {
		this.sysUser.setPlanNotiFlag(planNotiFlag);
	}
	public String getPlanNotifTime() {
		return this.sysUser.getPlanNotifTime();
	}
	public void setPlanNotifTime(String planNotifTime) {
		this.sysUser.setPlanNotifTime(planNotifTime);
	}
	public Date getRegTime() {
		return this.sysUser.getRegTime();
	}
	public void setRegTime(Date regTime) {
		this.sysUser.setRegTime(regTime);
	}
	public Date getLoginTime() {
		return this.sysUser.getLoginTime();
	}
	public void setLoginTime(Date loginTime) {
		this.sysUser.setLoginTime(loginTime);
	}
	public String getStatus() {
		return this.sysUser.getStatus();
	}
	public void setStatus(String status) {
		this.sysUser.setStatus(status);
	}

}
