package com.suns.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	
	private Map<String, CartItem> map =new LinkedHashMap<String, CartItem>();
	
	private double total;

	public Collection<CartItem> getItems(){
		return map.values();
	}
	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	//添加购物车
	public void addCart(CartItem cartItem){
		String id  = cartItem.getProduct().getPid();
		if(map.containsKey(id)){
			CartItem item = map.get(id);
			item.setCount(item.getCount()+cartItem.getCount());
		}else{
			map.put(id, cartItem);
		}
		
		total+=cartItem.getSubtotal();
		
	}
	//移除购物项
	public void removeCart(String id){
		CartItem cartItem =map.remove(id);
		total -= cartItem.getSubtotal();
		
	}
	//清空购物车
	public void clearCart(){
		map.clear();
		total=0;
	}

}
