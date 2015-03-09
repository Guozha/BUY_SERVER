package com.guozha.buyserver.web.controller.account;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guozha.buyserver.common.util.ParameterUtil;
import com.guozha.buyserver.service.account.RegisterService;
import com.guozha.buyserver.service.account.User;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/account")
public class RegisterController extends BaseController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value="/regCheckCode")
	public void getRegCheckCode(GetCheckCodeRequest vo, HttpServletResponse response) {
		
		GetCheckCodeResponse bo = new GetCheckCodeResponse();
		
		String checkCode = RandomStringUtils.randomNumeric(6);
		ParameterUtil.cacheCheckCode(vo.getMobileNo(), checkCode);
		
		bo.setMobileNo(vo.getMobileNo());
		bo.setCheckCode(checkCode);
		this.responseJson(bo, response);
	}
	
	@RequestMapping(value="/reg")
	public void doReg(RegisterRequest vo, HttpServletResponse response) {
		
		RegisterResponse bo = new RegisterResponse();
		
		String checkCode = ParameterUtil.getCheckCode(vo.getMobileNo());//获取服务端缓存的验证码
		if(!(vo.getCheckCode().equals(checkCode))){
			bo.setMobileNo(vo.getMobileNo());
			bo.setReturnCode("0");
			bo.setMsg("验证码错误");
			this.responseJson(bo, response);
		}
		
		User user = registerService.getRegUser(vo.getMobileNo());
		if(user.getSysUser()==null){
			registerService.register(vo);
			
			ParameterUtil.removeCheckCode(vo.getMobileNo());
			
			bo.setMobileNo(vo.getMobileNo());
			bo.setReturnCode("1");
			bo.setMsg("注册成功");
			this.responseJson(bo, response);
		}else{
			bo.setMobileNo(vo.getMobileNo());
			bo.setReturnCode("0");
			bo.setMsg("该手机已经注册过了");
			this.responseJson(bo, response);
		}
		
	}

}
