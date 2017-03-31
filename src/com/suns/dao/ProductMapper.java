package com.suns.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.suns.entity.Product;

public interface ProductMapper {

	public List<Product> findNew();
	
	public List<Product> findHot();
	
	public Product getById(long id);
	
	public List<Product> getByPage(@Param("start")int start,@Param("pageSize")int pageSize,@Param("cid")String cid);
	
	public Integer getTotalCount(String cid);
	
	public List<Product> selectByLike(@Param("str")String str);
    
	

}
