package com.guozha.buyserver.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.guozha.buyserver.dal.object.AbstractDO;

public class SysUser extends AbstractDO{
	
	private Integer userId;
	private String mobileNo;
	private byte[] headUrl;
	private String passwd;
	private int balance;
	private int ticketAmount;
	private int beanAmount;
	private String aftersaleTicketFlag;
	private String planNotiFlag;
	private String planNotifTime;
	private Date regTime;
	private Date loginTime;
	private String status;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	public String getAftersaleTicketFlag() {
		return aftersaleTicketFlag;
	}
	public void setAftersaleTicketFlag(String aftersaleTicketFlag) {
		this.aftersaleTicketFlag = aftersaleTicketFlag;
	}
	public String getPlanNotiFlag() {
		return planNotiFlag;
	}
	public void setPlanNotiFlag(String planNotiFlag) {
		this.planNotiFlag = planNotiFlag;
	}
	public String getPlanNotifTime() {
		return planNotifTime;
	}
	public void setPlanNotifTime(String planNotifTime) {
		this.planNotifTime = planNotifTime;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("UserId", getUserId())
				.append("MobileNo",getMobileNo())
				.append("HeadUrl",getHeadUrl())
				.append("Passwd", getPasswd())
				.append("Balance", getBalance())
				.append("TicketAmount",getTicketAmount())
				.append("BeanAmount", getBeanAmount())
				.append("AftersaleTicketFlag", getAftersaleTicketFlag())
				.append("PlanNotiFlag", getPlanNotiFlag())
				.append("RegTime", getRegTime())
				.append("LoginTime",getLoginTime())
				.append("Status", getStatus()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysUser == false) return false;
		if(this == obj) return true;
		SysUser other = (SysUser)obj;
		return new EqualsBuilder()
			.append(getUserId(),other.getUserId())
			.isEquals();
	}
	public byte[] getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(byte[] headUrl) {
		this.headUrl = headUrl;
	}

}
