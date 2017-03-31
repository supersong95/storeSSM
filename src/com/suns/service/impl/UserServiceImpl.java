package com.suns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suns.dao.UserMapper;
import com.suns.entity.User;
import com.suns.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
	private UserMapper mapper;

	@Override
	public void regist(User user) {
		mapper.add(user);
		
	}

	@Override
	public User login(String username, String password) {
		return mapper.getByUsernameAndPwd(username, password);
	}

}
