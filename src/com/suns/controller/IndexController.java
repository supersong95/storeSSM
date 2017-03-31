package com.suns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suns.entity.Product;
import com.suns.service.ProductService;

@Controller
public class IndexController {
	@Autowired
	private ProductService productService;
	@RequestMapping("index")
	public String index(Model model){
		List<Product> hList = productService.findHot();
		List<Product> nList = productService.findNew();
		model.addAttribute("hList", hList);
		model.addAttribute("nList", nList);
		
		
		return "index";
	}

}
