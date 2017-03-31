package com.suns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suns.dao.ProductMapper;
import com.suns.entity.PageBean;
import com.suns.entity.Product;
import com.suns.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper mapper;

	@Override
	public List<Product> findNew() {
		return mapper.findNew();
	}

	@Override
	public List<Product> findHot() {
		return mapper.findHot();
	}

	@Override
	public Product getById(long id) {
		
		return mapper.getById(id);
	}

	@Override
	public PageBean<Product> findByPage(int start, int pageSize, String cid) {
		List<Product> list = mapper.getByPage(start, pageSize, cid);
		int totalCount = mapper.getTotalCount(cid);
		int currPage = start/12+1;
		return new PageBean<>(list, currPage, pageSize, totalCount);
	}

	@Override
	public List<Product> selectByLike( String str) {
		List<Product> list = mapper.selectByLike( str);
		
		return list;
	}

	


	

	

}
