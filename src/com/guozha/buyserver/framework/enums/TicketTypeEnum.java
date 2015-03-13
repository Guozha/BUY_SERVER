package com.guozha.buyserver.framework.enums;

/**
 * @author sunhanbin
 * @date 2015-03-13
 */
public enum TicketTypeEnum {

	register("ticket.reward.register", "1"), friend("ticket.reward.friend", "2"), share("ticket.reward.share", "3"), aftersale("ticket.reward.aftersale", "4");

	private String type;
	private String code;

	TicketTypeEnum(String type, String code) {
		this.type = type;
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
