package com.guozha.buyserver.service.common.impl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.AmountUtils;
import com.guozha.buyserver.common.util.PriceUtils;
import com.guozha.buyserver.common.util.SystemResource;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BasPaperGen;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.GooGoodsAmount;
import com.guozha.buyserver.persistence.beans.MarMarket;
import com.guozha.buyserver.persistence.beans.MnuMenuGoods;
import com.guozha.buyserver.persistence.beans.SysSmsSend;
import com.guozha.buyserver.persistence.mapper.BasPaperGenMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsAmountMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.persistence.mapper.SysSmsSendMapper;
import com.guozha.buyserver.service.common.CommonService;

@Transactional(rollbackFor = Exception.class)
@Service("commonService")
public class CommonServiceImpl extends AbstractBusinessObjectServiceMgr implements CommonService {

	@Autowired
	private BasPaperGenMapper basPaperGenMapper;

	@Autowired
	private MarMarketGoodsMapper marMarketGoodsMapper;

	@Autowired
	private GooGoodsAmountMapper gooGoodsAmountMapper;

	@Autowired
	private GooGoodsMapper gooGoodsMapper;

	@Autowired
	private MnuMenuMapper mnuMenuMapper;

	@Autowired
	private MarMarketMapper marMarketMapper;

	@Autowired
	private SysSmsSendMapper smsSendMapper;

	private static String getTargetLengthStr(int no, int length) {
		String str = String.valueOf(no);
		StringBuffer someZeroStr = new StringBuffer();
		for (int i = 0; i < length - str.length(); i++) {
			someZeroStr.append("0");
		}
		return someZeroStr + str;
	}

	private String buildPaperCode(BasPaperGen sysPaperGen) {
		return sysPaperGen.getAreaCode() + sysPaperGen.getYear() + sysPaperGen.getMonth() + sysPaperGen.getDay() + getTargetLengthStr(sysPaperGen.getNo(), 5);
	}

	private void addCodeGen(BasPaperGen sysPaperGen) {
		basPaperGenMapper.insert(sysPaperGen);
	}

	private void updateCodeGen(BasPaperGen sysPaperGen) {
		basPaperGenMapper.update(sysPaperGen);
	}

	public String getPaperNo(String areaCode, String paperType) {

		BasPaperGen sysPaperGen = new BasPaperGen();
		sysPaperGen.setAreaCode(areaCode);
		sysPaperGen.setPaperType(paperType);
		sysPaperGen.setYear(new SimpleDateFormat("yy").format(new Date()));
		sysPaperGen.setMonth(new SimpleDateFormat("MM").format(new Date()));
		sysPaperGen.setDay(new SimpleDateFormat("dd").format(new Date()));

		BasPaperGen po = basPaperGenMapper.getOne(sysPaperGen);
		if (po == null) {
			sysPaperGen.setNo(1);
			addCodeGen(sysPaperGen);
			return buildPaperCode(sysPaperGen);
		} else {
			sysPaperGen.setNo(Integer.valueOf(po.getNo().toString()) + 1);
			updateCodeGen(sysPaperGen);
			return buildPaperCode(sysPaperGen);
		}
	}

	@Override
	public int getMenuUnitPrice(int marketId, int menuId) {
		int menuUnitPrice = 0; // 菜谱单价
		List<MnuMenuGoods> menuGoodsList = this.mnuMenuMapper.findGoodsById(menuId);

		for (MnuMenuGoods menuGoods : menuGoodsList) {
			List<GooGoodsAmount> goodsAmountList = this.gooGoodsAmountMapper.findByGoodsId(menuGoods.getGoodsId());
			int amounts[] = new int[goodsAmountList.size()];
			for (int j = 0; j < goodsAmountList.size(); j++) {
				amounts[j] = goodsAmountList.get(j).getAmount();
			}
			Arrays.sort(amounts);
			GooGoods goods = gooGoodsMapper.load(menuGoods.getGoodsId());
			int unitPrice = this.marMarketGoodsMapper.findByGoodsId(marketId, menuGoods.getGoodsId()).getUnitPrice();
			int goodsUnitPrice = PriceUtils.getMenuGoodsPrice(unitPrice, menuGoods.getAmount(), amounts, goods.getUnit());
			menuUnitPrice += goodsUnitPrice;
		}
		return menuUnitPrice;
	}

	@Override
	public int getMenuGoodsAmount(int goodsId, int amount) {
		GooGoods goods = this.gooGoodsMapper.load(goodsId);
		List<GooGoodsAmount> goodsAmountList = this.gooGoodsAmountMapper.findByGoodsId(goodsId);
		int amounts[] = new int[goodsAmountList.size()];
		for (int j = 0; j < goodsAmountList.size(); j++) {
			amounts[j] = goodsAmountList.get(j).getAmount();
		}
		Arrays.sort(amounts);
		return AmountUtils.getMenuGoodsAmount(amount, amounts, goods.getUnit());
	}

	@Override
	public int getMaketId(Integer addressId) {
		int defalutMarketId = Integer.valueOf(SystemResource.getConfig("default_market_id"));
		if (addressId == null || addressId == 0) {
			return defalutMarketId;
		}
		MarMarket market = this.marMarketMapper.findByAddressId(addressId);
		return market != null ? market.getMarketId() : defalutMarketId;
	}

	/**
	 * 短信发送插入短信表
	 * 
	 * @author sunhanbin
	 * @date 2015-03-25
	 */
	public void insertSms(SysSmsSend sms) {
		this.smsSendMapper.insertSms(sms);
	}

}
