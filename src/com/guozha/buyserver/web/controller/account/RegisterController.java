package com.guozha.buyserver.web.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guozha.buyserver.service.account.RegisterService;
import com.guozha.buyserver.service.account.User;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/account")
public class RegisterController extends BaseController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value="/doReg")
	public ModelAndView doReg(RegisterRequest vo, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		RegisterResponse bo = new RegisterResponse();
		bo.setMobileNo(vo.getMobileNo());
		
		User user = registerService.getRegUser(vo.getMobileNo());
		if(user.getSysUser()==null){
			registerService.register(vo);
			bo.setResult("success");
			bo.setMsg("注册成功");
			this.responseJson(bo, response);
		}else{
			registerService.register(vo);
			bo.setResult("failure");
			bo.setMsg("该手机已经注册过了");
			this.responseJson(bo, response);
		}
		
		return null;

	}

}
