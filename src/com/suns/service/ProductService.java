package com.suns.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suns.entity.PageBean;
import com.suns.entity.Product;

public interface ProductService {

	public List<Product> findNew();
	
	public List<Product> findHot();
	
	public Product getById(long id);
	
	public PageBean<Product> findByPage(int start,int pageSize,String cid);
	public List<Product> selectByLike(String str);
	
}
