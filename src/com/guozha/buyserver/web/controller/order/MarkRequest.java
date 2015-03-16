package com.guozha.buyserver.web.controller.order;

/**
 * @Package com.guozha.buyserver.web.controller.order
 * @Description: 订单评价
 * @author sunhanbin
 * @date 2015-3-26 上午10:42:30
 */
public class MarkRequest {

	private Integer orderId;
	private String commentDesc;// 订单评论
	private Integer serviceStar;// 订单打分
	private Integer orderMenuGoodsId;// 菜谱商品主键
	private Integer orderGoodsId;// 逛菜场商品主键
	private Integer goodsStar;// 打分
	private String markType;// 1-菜谱商品打分;2-菜场商品打分

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCommentDesc() {
		return commentDesc;
	}

	public void setCommentDesc(String commentDesc) {
		this.commentDesc = commentDesc;
	}

	public Integer getServiceStar() {
		return serviceStar;
	}

	public void setServiceStar(Integer serviceStar) {
		this.serviceStar = serviceStar;
	}

	public Integer getOrderMenuGoodsId() {
		return orderMenuGoodsId;
	}

	public void setOrderMenuGoodsId(Integer orderMenuGoodsId) {
		this.orderMenuGoodsId = orderMenuGoodsId;
	}

	public Integer getOrderGoodsId() {
		return orderGoodsId;
	}

	public void setOrderGoodsId(Integer orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}

	public Integer getGoodsStar() {
		return goodsStar;
	}

	public void setGoodsStar(Integer goodsStar) {
		this.goodsStar = goodsStar;
	}

	public String getMarkType() {
		return markType;
	}

	public void setMarkType(String markType) {
		this.markType = markType;
	}

}
