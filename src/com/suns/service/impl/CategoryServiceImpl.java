package com.suns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suns.dao.CategoryMapper;
import com.suns.entity.Category;
import com.suns.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryMapper mapper;

	@Override
	public List<Category> findAll() {
		List<Category> list = mapper.findAll();
		return list;
	}

}
