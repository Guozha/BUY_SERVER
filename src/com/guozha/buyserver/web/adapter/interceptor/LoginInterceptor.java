package com.guozha.buyserver.web.adapter.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;
import com.guozha.buyserver.common.util.ParameterUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * 免检地址
	 */
	private List<String> uncheckUrls; 

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		LoginInterceptorResponse authResponse = new LoginInterceptorResponse();
		
		String requestUrl = request.getRequestURI(); 
		if(uncheckUrls.contains(requestUrl)){ 
			return true;
		}
		
		String token = request.getParameter("token");
		if(!ParameterUtil.containToken(token)){
			authResponse.setReturnCode("0000");
			authResponse.setMsg("认证失败");
			this.responseJson(authResponse, response);
			
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
	
	public void responseJson(Object obj,HttpServletResponse response){
		Gson gson = new Gson();
		String result = "";
		if(null != obj)
			result = gson.toJson(obj);

		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			
		} finally{
			out.flush();
			out.close();
		}
	}

	public void setUncheckUrls(List<String> uncheckUrls) {
		this.uncheckUrls = uncheckUrls;
	}
	
}