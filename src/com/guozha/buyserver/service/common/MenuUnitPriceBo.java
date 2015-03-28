package com.guozha.buyserver.service.common;

/**
 * 菜谱单价业务对象
 * @author getjack
 *
 */
public class MenuUnitPriceBo {
	/**
	 * 单价取决于菜谱的状态
	 */
	private Integer unitPrice;
	/**
	 * 当状态为1有效时,返回正确的价格，当状态为0失效时，返回0 contant.xml
	 */
	private String status;

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
