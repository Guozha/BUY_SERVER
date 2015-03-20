package com.guozha.buyserver.service.cart.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.guozha.buyserver.service.cart.CartBo;
import com.guozha.buyserver.service.cart.CartService;
import com.guozha.buyserver.service.market.MarketService;
import com.guozha.buyserver.web.controller.MsgResponse;
import com.guozha.buyserver.web.controller.cart.CartRequest;
import com.guozha.buyserver.web.controller.cart.CartResponse;
import com.guozha.buyserver.web.controller.cart.ProductTypeResponse;

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
	public List<ProductTypeResponse> find(CartRequest vo) {
		List<ProductTypeResponse> response = new ArrayList<ProductTypeResponse>();
		
		//菜谱
		ProductTypeResponse menuResponse = new ProductTypeResponse();
		menuResponse.setProductType("01");
		List<CartBo> menuCartList = this.buyCartMapper.findMenuByUserId(vo.getUserId());
		
		List<CartResponse> menuCartResonseList = new ArrayList<CartResponse>();
	
		for(int i=0;i<menuCartList.size();i++){
			CartBo bo = menuCartList.get(i);
			bo.setPrice(getMenuUnitPrice(bo.getMarketId(), bo.getGoodsOrMenuId()));
			menuCartResonseList.add(new CartResponse(bo));
		}
		menuResponse.setCartList(menuCartResonseList);
		
		//食材
		ProductTypeResponse goodsResponse = new ProductTypeResponse();
		goodsResponse.setProductType("02");
		List<CartBo> goodsCartList = this.buyCartMapper.findGoodsByUserId(vo.getUserId());
		List<CartResponse> goodsCartResonseList = new ArrayList<CartResponse>();
		for(CartBo bo:goodsCartList){
			goodsCartResonseList.add(new CartResponse(bo));
		}
		goodsResponse.setCartList(goodsCartResonseList);
		
		response.add(goodsResponse);
		response.add(menuResponse);
		return response;
	}

	@Override
	public int getMenuUnitPrice(int marketId, int menuId) {
		int menuUnitPrice =0; //菜谱单价
		List<MnuMenuGoods> menuGoodsList = this.mnuMenuMapper.findGoodsById(menuId);
		
		for(MnuMenuGoods menuGoods:menuGoodsList){
			List<GooGoodsAmount> goodsAmountList = this.gooGoodsAmountMapper.findByGoodsId(menuGoods.getGoodsId());
			int unitPrice = this.marMarketGoodsMapper.findByGoodsId(marketId, menuGoods.getGoodsId()).getPrice();
			int amounts []  = new int[goodsAmountList.size()];
			for(int j =0;j<goodsAmountList.size();j++){
				amounts[j] = goodsAmountList.get(j).getAmount();
			}
			Arrays.sort(amounts);
			int goodsUnitPrice = PriceUtils.getMenuGoodsPrice(unitPrice, menuGoods.getAmount(), amounts);
			menuUnitPrice+=goodsUnitPrice;
		}
		return menuUnitPrice;
	}
	
	/*
	@Override
	public List<ProductTypeResponse> find(CartRequest vo) {
		List<BuyCart> pos = this.buyCartMapper.findByUserId(vo.getUserId());
		Map<String, List<CartResponse>> map = new LinkedHashMap<String, List<CartResponse>>();
		List<CartResponse> list = null;
		//分组去重
		for(BuyCart po:pos){
			if(map.containsKey(po.getSplitType())){
				map.get(po.getSplitType()).add(new CartResponse(po));
			}else{
				list = new ArrayList<CartResponse>();
				list.add(new CartResponse(po));
				map.put(po.getSplitType(), list);
			}
		}
		
		int marketId =0;
		//获得菜场ID
		if(!pos.isEmpty()){
			marketId = pos.get(0).getMarketId();
		}
		//设置结果集
		List<ProductTypeResponse> bos = new ArrayList<ProductTypeResponse>();
		for (String productType : map.keySet()) {
			ProductTypeResponse bo = new ProductTypeResponse();
			bo.setProductType(productType);
			//计算单价
			if("01".equals(productType)){
				//菜谱单价设置
				for(int i =0;i<map.get(productType).size();i++){
					List<MarMarketGoods> marketGoodsList = this.marMarketGoodsMapper.findByMenuId(marketId, map.get(productType).get(i).getId());
					
					map.get(productType).get(i).setPrice(marketGoods.getPrice());
				}
				
				//map.get(productType).get(0).setPrice(price);
			}else if("02".equals(productType)){
				for(int i =0;i<map.get(productType).size();i++){
					//商品单价设置
					MarMarketGoods marketGoods = this.marMarketGoodsMapper.findByGoodsId(marketId, map.get(productType).get(i).getId());
					map.get(productType).get(i).setPrice(marketGoods.getPrice());
				}
			}
			bo.setCartList(map.get(productType));
			bos.add(bo);
		}
		
		//设置单价
		
		
		return bos;
	}

	*/

}
