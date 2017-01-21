package com.jcg.examples.delegate;

import java.sql.SQLException;

import com.jcg.examples.service.impl.UserServiceImpl;

public class LoginDelegate
{

		public boolean isValidUser(String username, String password) throws SQLException
    {
			UserServiceImpl userService=new UserServiceImpl();
			System.out.println("In isValidUser() of LoginDelegate");
		    return userService.isValidUser(username, password);
    }
}
