package com.guozha.buyserver.persistence.mapper;

import org.springframework.stereotype.Repository;

import com.guozha.buyserver.dal.BaseMapper;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.web.controller.account.LoginRequest;

@Repository
public interface UserMapper extends BaseMapper<SysUser, Integer>{
	
	SysUser getUserByMobileNo(String mobileNo);
	
	SysUser getLoginUser(LoginRequest vo);
	
}
