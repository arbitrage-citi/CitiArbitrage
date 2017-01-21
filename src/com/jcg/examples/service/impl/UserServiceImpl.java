package com.jcg.examples.service.impl;

import java.sql.SQLException;

import com.jcg.examples.dao.UserDao;
import com.jcg.examples.dao.impl.UserDaoImpl;
import com.jcg.examples.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean isValidUser(String username, String password) throws SQLException {
		UserDaoImpl userDao = new UserDaoImpl();
		System.out.println("In isValidUser() of UserServiceImpl");
		return userDao.isValidUser(username, password);
	}

}
