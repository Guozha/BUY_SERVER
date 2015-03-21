package com.guozha.buyserver.service.cart.impl;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.AmountUtils;
import com.guozha.buyserver.common.util.PriceUtils;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BuyCart;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.GooGoodsAmount;
import com.guozha.buyserver.persistence.beans.MarMarketGoods;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.MnuMenuGoods;
import com.guozha.buyserver.persistence.mapper.BuyCartMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsAmountMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.cart.CartService;
import com.guozha.buyserver.service.market.MarketService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.cart.CartRequest;
import com.guozha.buyserver.web.controller.cart.CartResponse;
import com.guozha.buyserver.web.controller.cart.Goods;
import com.guozha.buyserver.web.controller.cart.Menu;

@Transactional(rollbackFor = Exception.class)
@Service("cartService")
public class CartServiceImpl extends AbstractBusinessObjectServiceMgr implements CartService {
	
    @Autowired
	private GooGoodsMapper gooGoodsMapper;
    @Autowired
	private MnuMenuMapper mnuMenuMapper;
    @Autowired
	private BuyCartMapper buyCartMapper;
    
	@Autowired
	private MarMarketGoodsMapper marMarketGoodsMapper;
	
	@Autowired
	private GooGoodsAmountMapper gooGoodsAmountMapper;
	
	@Autowired
	private MarketService marketService;
    
	@Override
	public MsgResponse add(CartRequest vo) {
		int marketId= this.marketService.findMaketId( vo.getAddressId());
		BuyCart po = this.buyCartMapper.selectByGoodsOrMenuId(vo.getUserId(), vo.getId(),vo.getProductType());
		if(po==null){  //新的购物车信息
			po = new BuyCart();
			if("01".equals(vo.getProductType())){ //菜谱 constants.xml 
				MnuMenu menu = this.mnuMenuMapper.load(vo.getId());
				po.setDisplayName(menu.getMenuName());
				po.setUnit("08");//constants.xml 
				
				List<MarMarketGoods> marketGoodsList = this.marMarketGoodsMapper.findByMenuId(marketId, vo.getId());
				String marketGoodsId ="";
				for(MarMarketGoods marketGoods:marketGoodsList){
					marketGoodsId += marketGoods.getMarketGoodsId()+",";
				}
				marketGoodsId = marketGoodsId.substring(0, marketGoodsId.lastIndexOf(","));
				po.setMarketGoodsId(marketGoodsId);
			}else if("02".equals(vo.getProductType())){ //单品  constants.xml
				GooGoods goods = this.gooGoodsMapper.load(vo.getId());
				po.setDisplayName(goods.getGoodsName());
				po.setUnit(goods.getUnit());//constants.xml 
				
				//存储农贸市场商品ID
				MarMarketGoods marketGoods = this.marMarketGoodsMapper.findByGoodsId(marketId, vo.getId());
				po.setMarketGoodsId(marketGoods.getMarketGoodsId().toString());
			}
			po.setUserId(vo.getUserId());
			po.setGoodsOrMenuId(vo.getId());
			po.setSplitType(vo.getProductType());
			po.setAmount(vo.getAmount()[0]);
			
			po.setMarketId(marketId);
			this.buyCartMapper.insert(po);
		}else{  //修改购物车信息
			po.setAmount(vo.getAmount()[0]);
			this.buyCartMapper.update(po);
		}
		return new MsgResponse(MsgResponse.SUCC, "添加购物车成功");
	}

	@Override
	public MsgResponse update(CartRequest vo) {
		//更新购物车
		for(int i=0;i<vo.getCartId().length;i++){
			BuyCart po = new BuyCart();
			po.setCartId(vo.getCartId()[i]);
			po.setAmount(vo.getAmount()[i]);
			this.buyCartMapper.update(po);
		}
		//删除已被用户移除的购物车信息
		this.buyCartMapper.deletesNotIn(vo.getUserId(), vo.getCartId());
		return new MsgResponse(MsgResponse.SUCC, "修改购物车成功");
	}

	@Override
	public MsgResponse del(CartRequest vo) {
		this.buyCartMapper.deletes(vo.getCartId());
		return new MsgResponse(MsgResponse.SUCC, "删除购物车成功");
	}

	@Override
	public MsgResponse clear(CartRequest vo) {
		this.buyCartMapper.deleteByUserId(vo.getUserId());
		return new MsgResponse(MsgResponse.SUCC, "清空购物车成功");
	}
    
	
	@Override
	public CartResponse find(CartRequest vo) {
       
		CartResponse response = new CartResponse();
		
		int totalPrice=0;
	    int quantity=0;
	    int freeServicePrice =0; //免服务费金额
	    int serviceFee =0;       //服务费
	
		
		//菜谱
		List<BuyCart> menuCartList = this.buyCartMapper.findMenuByUserId(vo.getUserId());
		for(BuyCart cart:menuCartList){
			Menu menu = new Menu();
			menu.setCartId(cart.getCartId());
			menu.setMenuName(cart.getDisplayName());
			menu.setAmount(cart.getAmount());
			int unitPrice = getMenuUnitPrice(cart.getMarketId(), cart.getGoodsOrMenuId());
			menu.setUnitPrice(unitPrice);
			int price=unitPrice*cart.getAmount();
			menu.setPrice(price);
			List<MnuMenuGoods> menuGoodsList = this.mnuMenuMapper.findGoodsById(cart.getGoodsOrMenuId());
			for(MnuMenuGoods menuGoods:menuGoodsList){
				Goods goods = new Goods();
				goods.setGoodsName(menuGoods.getGoodsName());
				goods.setAmount(getMenuGoodsAmount(menuGoods.getGoodsId(), menuGoods.getAmount())); //	去上值的重量而不是菜谱的配置食材重量
				menu.getGoodsList().add(goods);
				
				quantity+=1;
			}
			response.getMenuList().add(menu);
			
			totalPrice+=price;
		}
		
		//食材
		List<BuyCart> goodsCartList = this.buyCartMapper.findGoodsByUserId(vo.getUserId());
		for(BuyCart cart:goodsCartList){
			Goods goods = new Goods();
			goods.setCartId(cart.getCartId());
			goods.setGoodsId(cart.getGoodsOrMenuId());
			goods.setGoodsName(cart.getDisplayName());
			goods.setUnit(cart.getUnit());
			goods.setAmount(cart.getAmount());
			int unitPrice = this.marMarketGoodsMapper.findByGoodsId(cart.getMarketId(),cart.getGoodsOrMenuId()).getUnitPrice();
			goods.setUnitPrice(unitPrice);
			int price = PriceUtils.getGoodsPrice(unitPrice, cart.getAmount(), cart.getUnit());
			goods.setPrice(price);
			response.getGoodsList().add(goods);
			
			quantity+=1;
			totalPrice+=price;
		}
		response.setQuantity(quantity);
		response.setTotalPrice(totalPrice);
		return response;
	}

	@Override
	public int getMenuUnitPrice(int marketId, int menuId) {
		int menuUnitPrice =0; //菜谱单价
		List<MnuMenuGoods> menuGoodsList = this.mnuMenuMapper.findGoodsById(menuId);
		
		for(MnuMenuGoods menuGoods:menuGoodsList){
			List<GooGoodsAmount> goodsAmountList = this.gooGoodsAmountMapper.findByGoodsId(menuGoods.getGoodsId());
			int unitPrice = this.marMarketGoodsMapper.findByGoodsId(marketId, menuGoods.getGoodsId()).getUnitPrice();
			int amounts []  = new int[goodsAmountList.size()];
			for(int j =0;j<goodsAmountList.size();j++){
				amounts[j] = goodsAmountList.get(j).getAmount();
			}
			Arrays.sort(amounts);
			GooGoods goods = gooGoodsMapper.load(menuGoods.getGoodsId());
			int goodsUnitPrice = PriceUtils.getMenuGoodsPrice(unitPrice, menuGoods.getAmount(), amounts,goods.getUnit());
			menuUnitPrice+=goodsUnitPrice;
		}
		return menuUnitPrice;
	}
	
	/**
	 * 计算菜谱中食材的上值份量
	 * @param marketId
	 * @param goodsId
	 * @return
	 */
	private int getMenuGoodsAmount(int goodsId,int amount){
		GooGoods goods = this.gooGoodsMapper.load(goodsId);
		List<GooGoodsAmount> goodsAmountList = this.gooGoodsAmountMapper.findByGoodsId(goodsId);
		int amounts []  = new int[goodsAmountList.size()];
		for(int j =0;j<goodsAmountList.size();j++){
			amounts[j] = goodsAmountList.get(j).getAmount();
		}
		Arrays.sort(amounts);
		return AmountUtils.getMenuGoodsAmount(amount, amounts, goods.getUnit());
	}

}
