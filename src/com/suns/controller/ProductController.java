package com.suns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suns.entity.PageBean;
import com.suns.entity.Product;
import com.suns.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("getById")
	public String getById(long pid,Model model){
		Product product = productService.getById(pid);
		model.addAttribute("bean", product);
		return "product_info";
		
	}
	
	@RequestMapping("getByPage")
	public String getByPage(String cid,int currPage,Model model){
		int pageSize = 12; 
		int start = (currPage-1)*pageSize;
		PageBean<Product> bean = productService.findByPage(start, pageSize, cid);
		model.addAttribute("pb", bean);
		return "product_list";
		
	}
	@RequestMapping("selectByLike")
	public String selectByLike(String str,Model model){
		
		List<Product> list = productService.selectByLike( str);
		model.addAttribute("like", list);
		return "likeproduct_list";
		
	}

}
