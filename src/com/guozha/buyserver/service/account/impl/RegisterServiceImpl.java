package com.guozha.buyserver.service.account.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.SysUser;
import com.guozha.buyserver.persistence.mapper.UserMapper;
import com.guozha.buyserver.service.account.RegisterService;
import com.guozha.buyserver.service.account.User;
import com.guozha.buyserver.web.controller.account.RegisterRequest;

@Transactional(rollbackFor = Exception.class)
@Service("registerService")
public class RegisterServiceImpl extends AbstractBusinessObjectServiceMgr
		implements RegisterService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getRegUser(String mobileNo) {
		SysUser po = userMapper.getUserByMobileNo(mobileNo);
		return new User(po);
	}

	@Override
	public void register(RegisterRequest vo) {
		
		SysUser po = new SysUser();
		po.setMobileNo(vo.getMobileNo());
		po.setPasswd(vo.getPasswd());
		po.setRegTime(new Date());
		po.setStatus("1");// USER_STATUS 1-可用
		userMapper.insert(po);
		
	}

}
