package com.guozha.buyserver.persistence.mapper;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.SysSmsSend;

/**
 * @Package com.guozha.buyserver.persistence.mapper
 * @Description: 发送短信
 * @author sunhanbin
 * @date 2015-3-25 下午05:17:55
 */
@Repository
public interface SysSmsSendMapper extends BaseMapper<SysSmsSend, Integer>{
	
	void insertSms(SysSmsSend sms);

}
