package com.jt.service;

import java.util.List;

import com.jt.pojo.Cart;
import com.jt.vo.SysResult;




public interface CartService {
	public List<Cart> myCart(Integer userId);
	public SysResult save(Cart cart);
	public void updateNum(Cart cart);
	public void delete(String userId, String itemId);
	
}
