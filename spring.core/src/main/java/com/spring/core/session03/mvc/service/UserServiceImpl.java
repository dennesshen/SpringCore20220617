package com.spring.core.session03.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.core.session03.mvc.model.User;
import com.spring.core.session03.mvc.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public void adduser(User user) {
		userDao.createUser(user);
	};
}
