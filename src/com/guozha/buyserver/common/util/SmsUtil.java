package com.guozha.buyserver.common.util;

import java.util.HashMap;
import java.util.Map;

public class SmsUtil {
	
	private static Map<String, String> checkCodeCache = new HashMap<String, String>();
	
	public static void sendSms(String smsType, String mobile, Object[] arr){
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("account", SystemResource.getConfig("sms.account"));
        map.put("password", SystemResource.getConfig("sms.password"));
        map.put("mobile", mobile);
        if("01".equals(smsType)){ //注册获取验证码
        	map.put("content", String.format(SystemResource.getConfig("sms.content.register"), arr));
        	cacheCheckCode(mobile, String.valueOf(arr[0]));
        }else if("02".equals(smsType)){// 密码重置获取验证码
        	map.put("content", String.format(SystemResource.getConfig("sms.content.resetPasswd"), arr));
        	cacheCheckCode(mobile, String.valueOf(arr[0]));
        }
        HttpUtil.doPost(SystemResource.getConfig("sms.url"), map, null);
		
	}
	
	public static void cacheCheckCode(String mobileNo, String checkCode){
		checkCodeCache.put(mobileNo, checkCode);
	}
	
	public static String getCheckCode(String mobileNo){
		if(checkCodeCache.containsKey(mobileNo)){
			return checkCodeCache.get(mobileNo);
		}
		return null;
	}
	
	public static void removeCheckCode(String mobileNo){
		if(checkCodeCache.containsKey(mobileNo)){
			checkCodeCache.remove(mobileNo);
		}
	}

}
