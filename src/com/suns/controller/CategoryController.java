package com.suns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suns.entity.Category;
import com.suns.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@RequestMapping("findAll")
	@ResponseBody
	public List findAll(){
		List<Category>list = service.findAll();
		return list;
	}

}
