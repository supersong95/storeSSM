package com.suns.service;

import com.suns.entity.User;

public interface UserService {

	public void regist(User user);
	public User login(String username,String password);
}
