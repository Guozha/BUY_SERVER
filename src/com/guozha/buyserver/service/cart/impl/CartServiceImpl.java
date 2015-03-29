package com.guozha.buyserver.service.cart.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.common.util.PriceUtils;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BuyCart;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.MarMarketGoods;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.beans.MnuMenuGoods;
import com.guozha.buyserver.persistence.mapper.BuyCartMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MarMarketGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.cart.CartService;
import com.guozha.buyserver.service.common.CommonService;
import com.guozha.buyserver.service.common.MenuUnitPriceBo;
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
	private CommonService commonService;
	
    
	@Override
	public MsgResponse add(CartRequest vo) {
		int marketId= this.commonService.getMaketId( vo.getAddressId());
		BuyCart po = this.buyCartMapper.loadByGoodsOrMenuId(vo.getUserId(), vo.getId(),vo.getProductType());
		if(po==null){  //新的购物车信息
			po = new BuyCart();
			if("01".equals(vo.getProductType())){ //菜谱 constants.xml 
				MnuMenu menu = this.mnuMenuMapper.load(vo.getId());
				if(menu==null){
					return new MsgResponse(MsgResponse.FAIL, "商品已下架");
				}
			}else if("02".equals(vo.getProductType())){ //单品  constants.xml
				GooGoods goods = this.gooGoodsMapper.load(vo.getId());
				if(goods==null){
					return new MsgResponse(MsgResponse.FAIL, "商品已下架");
				}
				if(this.marMarketGoodsMapper.loadIsOpenBuyByGoodsId(marketId, vo.getId())==null){
					return new MsgResponse(MsgResponse.FAIL, "商品已下架");
				}
			}else{
				return new MsgResponse(MsgResponse.FAIL, "商品已下架");
			}
			po.setUserId(vo.getUserId());
			po.setGoodsOrMenuId(vo.getId());
			po.setSplitType(vo.getProductType());
			po.setAmount(vo.getAmount()[0]);
			
			this.buyCartMapper.insert(po);
		}else{  //修改购物车信息
			po.setAmount(po.getAmount()+vo.getAmount()[0]);
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
		this.buyCartMapper.deleteNotIn(vo.getUserId(), vo.getCartId());
		return new MsgResponse(MsgResponse.SUCC, "修改购物车成功");
	}

	@Override
	public MsgResponse del(CartRequest vo) {
		this.buyCartMapper.deleteByIds(vo.getUserId(),vo.getCartId());
		return new MsgResponse(MsgResponse.SUCC, "删除购物车成功");
	}

	@Override
	public MsgResponse clear(CartRequest vo) {
		this.buyCartMapper.deleteByUserId(vo.getUserId());
		return new MsgResponse(MsgResponse.SUCC, "清空购物车成功");
	}
    
	
	@Override
	public CartResponse find(CartRequest vo) {
		int marketId= this.commonService.getMaketId( vo.getAddressId());
		CartResponse response = new CartResponse();
		response.setServiceFee(PriceUtils.getServiceFee());
		response.setServiceFeePrice(PriceUtils.getServiceFeePrice());
		
		int totalPrice=0;
	    int quantity=0;
		
		//菜谱
		List<BuyCart> menuCartList = this.buyCartMapper.findMenuByUserId(vo.getUserId());
		for(BuyCart cart:menuCartList){
			Menu menu = new Menu();
			menu.setCartId(cart.getCartId());
			menu.setGoodsName(mnuMenuMapper.load(cart.getGoodsOrMenuId()).getMenuName());
			menu.setAmount(cart.getAmount());
			menu.setUnit("08");
			
			int price =0;
			int unitPrice=0;
			
			List<MnuMenuGoods> menuGoodsList = this.mnuMenuMapper.findGoodsById(cart.getGoodsOrMenuId());
			for(MnuMenuGoods menuGoods:menuGoodsList){
				Goods goods = new Goods();
				goods.setGoodsName(menuGoods.getGoodsName());
				GooGoods gooGoods = this.gooGoodsMapper.load(menuGoods.getGoodsId());
				goods.setAmount(commonService.getMenuGoodsAmount(menuGoods.getGoodsId(), menuGoods.getAmount(),gooGoods.getUnit())); //	去上值的重量而不是菜谱的配置食材重量
				goods.setUnit(gooGoods.getUnit());
				menu.getGoodsList().add(goods);
			}
		    
			MenuUnitPriceBo menuUnitPriceBo  = commonService.getMenuUnitPrice(marketId, cart.getGoodsOrMenuId());
			//如果菜谱有效  则设置菜谱有效  反之菜谱无效
			if("1".equals(menuUnitPriceBo.getStatus())){	
				menu.setCartStatus("1");
				unitPrice = menuUnitPriceBo.getUnitPrice();
				quantity+=1;
			}else{ 
			    menu.setCartStatus("0");
			}
			price = unitPrice*cart.getAmount();
			menu.setUnitPrice(unitPrice);
			menu.setPrice(price);	//菜谱价格= 菜谱单价*分享
			
			response.getMenuList().add(menu);
			
			totalPrice+=price;
		}
		
		//食材
		List<BuyCart> goodsCartList = this.buyCartMapper.findGoodsByUserId(vo.getUserId());
		for(BuyCart cart:goodsCartList){
			int goodsId = cart.getGoodsOrMenuId();
			GooGoods gooGoods = this.gooGoodsMapper.load(goodsId);
			Goods goods = new Goods();
			goods.setCartId(cart.getCartId());
			goods.setGoodsId(goodsId);
			goods.setGoodsName(gooGoods.getGoodsName());
			goods.setUnit(gooGoods.getUnit());
			goods.setAmount(cart.getAmount());
			
			int price =0;
			int unitPrice=0;
			MarMarketGoods marketGoods = this.marMarketGoodsMapper.loadIsOpenBuyByGoodsId(marketId, goodsId);
			//如果菜谱有效  则设置商品有效  反之商品无效
			if(marketGoods!=null){
				goods.setCartStatus("1");
				unitPrice = marketGoods.getUnitPrice();
				price = PriceUtils.getGoodsPrice(unitPrice, cart.getAmount(), gooGoods.getUnit());
				
				quantity+=1;
			}else{
				goods.setCartStatus("0");
			}
			goods.setUnitPrice(unitPrice);
			goods.setPrice(price);
			response.getGoodsList().add(goods);
			
			totalPrice+=price;
		}
		response.setQuantity(quantity);
		response.setTotalPrice(totalPrice);
		response.setCurrServiceFee(PriceUtils.getServiceFee(totalPrice));
		return response;
	}

}
