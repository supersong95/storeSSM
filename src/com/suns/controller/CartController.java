package com.suns.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suns.entity.Cart;
import com.suns.entity.CartItem;
import com.suns.entity.Product;
import com.suns.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	@RequestMapping("addCart")
	public String addCart(Integer count,long pid,HttpSession session){
		Product p = productService.getById(pid);
		CartItem cartItem =new CartItem();
		cartItem.setCount(count);
		cartItem.setProduct(p);
		Cart cart = getCart(session);
		cart.addCart(cartItem);
		return "cart";
		
	}
	private Cart getCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			 cart = new Cart();
			 session.setAttribute("cart", cart);
		}
		return cart;
	}
	@RequestMapping("remove")
	public String remove(String pid,HttpSession session){
		getCart(session).removeCart(pid);
		return "cart";
		
	}
	@RequestMapping("clear")
	public String clear(HttpSession session){
		getCart(session).clearCart();
		return "cart";
	}

}
