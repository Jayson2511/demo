package com.jt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jt.mapper.CartMapper;
import com.jt.pojo.Cart;
import com.jt.vo.SysResult;


@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartMapper cartMapper;
	//查询商品
	public List<Cart> myCart(Integer userId){
		//设置where条件,新的方式QBC,新的查询方式,把查询条件封装到QBC对象
		EntityWrapper<Cart> ew = new EntityWrapper<>();
		//{0}占位符,序号从0开始编
		 ew.where("user_id={0}", userId);
		List<Cart> result = cartMapper.selectList(ew);
		return result;
		
	}
	
	//保存商品到购物车
public SysResult save(Cart cart) {
		
		//查询结果
		Cart cartDB=new Cart();
		cartDB.setUserId(cart.getUserId());
		cartDB.setItemId(cart.getItemId());
		
		Cart cart1 = cartMapper.selectOne(cartDB);
		try {
		if(cart1== null) {
			//新增
			cartMapper.insert(cart);
			return SysResult.oK();
		}else {
			//修改
			cart.setNum(cart.getNum()+cart1.getNum());
			EntityWrapper<Cart> ew = new EntityWrapper<>();
			ew.where("user_id={0}", cart.getUserId());
			ew.and("item_id={0}",cart.getItemId());
			cartMapper.update(cart, ew);
			return SysResult.build(202, "商品已存在,并修改");
		}}catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "失败!");
		
		
	}

//修改商品num
@Override
public void updateNum(Cart cart) {
	
	
	EntityWrapper<Cart> ew = new EntityWrapper<Cart>();
	ew.where("user_id={0}", cart.getUserId());
	ew.where("item_id={0}", cart.getItemId());
	
	cartMapper.update(cart, ew);
	
}

	
	
	//删除商品
@Override
public void delete(String userId, String itemId) {
	EntityWrapper<Cart> ew = new EntityWrapper<>();
	ew.where("user_id={0}", userId);
	ew.and("item_id={0}",itemId);
	try {
		cartMapper.delete(ew);
		
	} catch (Exception e) {
		throw new RuntimeException();
	}
}
	
}
