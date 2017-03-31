package com.suns.dao;

import com.suns.entity.User;

public interface UserMapper {
	//添加用户
	public void add(User user);

	public User getByUsernameAndPwd(String username,String password);
}
