package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Cart;
import com.jt.service.CartService;
import com.jt.vo.SysResult;
import com.sun.org.apache.bcel.internal.generic.NEW;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/query/{userId}")
	
	public SysResult findCart(@PathVariable Integer userId) {
		
		try {
			
			List<Cart> myCart = cartService.myCart(userId);
			
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "查询失败");
	}
	
	@RequestMapping("/save")
	
	public SysResult saveItem(Cart cart) {
		try {
			cartService.save(cart);
			return SysResult.oK(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "failure");
	}
	
	@RequestMapping("/update/{userId}/{itemId}/{num}")
	public SysResult updateById(Cart cart) {
		try {
			//Cart cart=new Cart();
			//cart.setUserId(cartUp.getUserId());
			//cart.setItemId(cartUp.getItemId());
			//cart.setNum(cartUp.getNum());
			cartService.updateNum(cart);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "修改失败");
	}
	
	@RequestMapping("/delete/{userId}/{itemId}")
	public SysResult delete(@PathVariable String userId,@PathVariable String itemId) {
		
		try {
			cartService.delete(userId,itemId);
			return SysResult.oK("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "删除失败");
	}
	
}
