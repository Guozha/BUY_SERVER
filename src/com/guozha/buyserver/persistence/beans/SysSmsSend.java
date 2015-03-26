/**
 * 
 */
package com.guozha.buyserver.persistence.beans;

import java.sql.Timestamp;

import com.guozha.buyserver.dal.object.AbstractDO;

/**
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: 发送短信表
 * @author sunhanbin
 * @date 2015-3-25 下午05:14:32
 */
public class SysSmsSend extends AbstractDO {

	private Integer smsSendId;// 主键ID
	private String mobileNo;// 手机号码
	private Timestamp sendTime;// 发送时间
	private String sendType;// 发送类型
	private String sendText;// 发送内容
	private String sendStatus;// 发送状态

	public Integer getSmsSendId() {
		return smsSendId;
	}

	public void setSmsSendId(Integer smsSendId) {
		this.smsSendId = smsSendId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getSendText() {
		return sendText;
	}

	public void setSendText(String sendText) {
		this.sendText = sendText;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}

}
