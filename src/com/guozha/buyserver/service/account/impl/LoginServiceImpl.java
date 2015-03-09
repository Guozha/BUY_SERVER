package com.guozha.buyserver.service.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.persistence.mapper.UserMapper;
import com.guozha.buyserver.service.account.LoginService;
import com.guozha.buyserver.service.account.User;
import com.guozha.buyserver.web.controller.account.LoginRequest;

@Transactional(rollbackFor = Exception.class)
@Service("loginService")
public class LoginServiceImpl extends AbstractBusinessObjectServiceMgr implements LoginService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getLoginUser(LoginRequest vo) {
		SysUser po = userMapper.getLoginUser(vo);
		return new User(po);
	}

}
