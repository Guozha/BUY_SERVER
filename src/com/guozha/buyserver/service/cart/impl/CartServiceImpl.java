package com.guozha.buyserver.service.cart.impl;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BuyCart;
import com.guozha.buyserver.persistence.beans.GooGoods;
import com.guozha.buyserver.persistence.beans.MnuMenu;
import com.guozha.buyserver.persistence.mapper.BuyCartMapper;
import com.guozha.buyserver.persistence.mapper.GooGoodsMapper;
import com.guozha.buyserver.persistence.mapper.MnuMenuMapper;
import com.guozha.buyserver.service.cart.CartService;
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
	@Override
	public MsgResponse add(CartRequest vo) {
		BuyCart po = this.buyCartMapper.selectByGoodsOrMenuId(vo.getUserId(), vo.getId(),vo.getProductType());
		if(po==null){  //新的购物车信息
			po = new BuyCart();
			if("01".equals(vo.getProductType())){ //菜谱 constants.xml 
				MnuMenu menu = this.mnuMenuMapper.load(vo.getId());
				po.setDisplayName(menu.getMenuName());
				po.setUnit("08");//constants.xml 
			}else if("02".equals(vo.getProductType())){ //单品  constants.xml
				GooGoods goods = this.gooGoodsMapper.load(vo.getId());
				po.setPrice(goods.getPrice());
				po.setDisplayName(goods.getGoodsName());
				po.setUnit("01");//constants.xml 
			}
			po.setUserId(vo.getUserId());
			po.setGoodsOrMenuId(vo.getId());
			po.setSplitType(vo.getProductType());
			po.setAmount(vo.getAmount()[0]);
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
		
		//设置结果集
		List<ProductTypeResponse> bos = new ArrayList<ProductTypeResponse>();
		for (String productType : map.keySet()) {
			ProductTypeResponse bo = new ProductTypeResponse(productType);
			bo.setCartList(map.get(productType));
			bos.add(bo);
		}
		return bos;
	}

	

}
