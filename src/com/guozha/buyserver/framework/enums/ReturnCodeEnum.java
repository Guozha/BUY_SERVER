package com.guozha.buyserver.framework.enums;

import com.guozha.buyserver.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>Gender</strong><br>
 * <strong>Create on : 2012-3-11<br>
 * </strong>
 * <p>
 * <strong>Copyright (C) Ecointel Software Co.,Ltd.<br>
 * </strong>
 * </p>
 * 
 * @author peng.shi peng.shi@ecointel.com.cn<br>
 * @version <strong>ecointel-roomyi v1.0.0</strong><br>
 */
public enum ReturnCodeEnum {

	SUCCESS("1"), FAILED("0");

	public final String status;

	ReturnCodeEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public static void main(String args[]){
		System.out.println(ReturnCodeEnum.SUCCESS.status);
	}

}
