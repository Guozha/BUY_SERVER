package com.guozha.buyserver.persistence.beans;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;

import com.guozha.buyserver.common.util.ArrayUtils;
import com.guozha.buyserver.dal.object.AbstractDO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 商品
 * @Package com.guozha.buyserver.persistence.beans
 * @Description: TODO
 * @author txf
 * @date 2015-3-10 下午1:25:34
 */
public class GooGoods extends AbstractDO {
	
	private Integer goodsId;   //商品ID
	private String goodsName;  //商品名
	private Integer belongOrgId; //归属组织ID
	private String goodsProp;   //商品性质
	private Integer firstFrontTypeId; //前台一级类目ID
	private Integer secondFrontTypeId;//前台二级类目ID
	private Integer backTypeId;//后台类目ID
	private byte[] goodsImg;//商品图片 

	private String unit;//计量单位
	private String memo;//商品备注
	private Date prepareEndDate;//预售截止日期
	private Integer arrivalDays;//送达天数
	private String picDesc;//图文介绍
	private String otherNames;//别名
	private Integer sort;//排序
	private String status;//状态（参考constant.xml)
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getBelongOrgId() {
		return belongOrgId;
	}
	public void setBelongOrgId(Integer belongOrgId) {
		this.belongOrgId = belongOrgId;
	}
	public String getGoodsProp() {
		return goodsProp;
	}
	public void setGoodsProp(String goodsProp) {
		this.goodsProp = goodsProp;
	}
	public Integer getFirstFrontTypeId() {
		return firstFrontTypeId;
	}
	public void setFirstFrontTypeId(Integer firstFrontTypeId) {
		this.firstFrontTypeId = firstFrontTypeId;
	}
	public Integer getSecondFrontTypeId() {
		return secondFrontTypeId;
	}
	public void setSecondFrontTypeId(Integer secondFrontTypeId) {
		this.secondFrontTypeId = secondFrontTypeId;
	}
	public Integer getBackTypeId() {
		return backTypeId;
	}
	public void setBackTypeId(Integer backTypeId) {
		this.backTypeId = backTypeId;
	}
	public byte[]  getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(byte[] goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getPrepareEndDate() {
		return prepareEndDate;
	}
	public void setPrepareEndDate(Date prepareEndDate) {
		this.prepareEndDate = prepareEndDate;
	}
	public Integer getArrivalDays() {
		return arrivalDays;
	}
	public void setArrivalDay(Integer arrivalDays) {
		this.arrivalDays = arrivalDays;
	}
	public String getPicDesc() {
		return picDesc;
	}
	public void setPicDesc(String picDesc) {
		this.picDesc = picDesc;
	}
	public String getOtherNames() {
		return otherNames;
	}
	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public static void main(String[] args)  {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection coon = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.106.6:3306/wymc","root","root");
		//商品
		//PreparedStatement state = (PreparedStatement) coon.prepareStatement("update  GOO_GOODS set goods_img=? where GOODS_PROP=?" );
		//File file = new File("E:\\maicai\\WYMC\\01开发库\\040系统设计\\020详细设计\\icon\\xhdpi\\main_vegetable_img_01.png");
		
		
		//菜谱
		PreparedStatement state = (PreparedStatement) coon.prepareStatement("update MNU_MENU  set MENU_img=?" );
		File file = new File("E:\\maicai\\WYMC\\01开发库\\040系统设计\\020详细设计\\andriod效果图\\icons\\xhdpi\\main_recipe_img_02.png");
		
		
		 int length = (int) file.length();  
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));  
		 byte[] bytes = new byte[length];  
        in.read(bytes, 0,length);  
		state.setBytes(1, bytes);
		int flag = state.executeUpdate();
		state.close();
		coon.close();
		System.out.println(flag);
		ArrayUtils.byte2image(bytes, "E:\\maicai\\jd.png");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
