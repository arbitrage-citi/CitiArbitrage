package com.jcg.examples.dao.impl;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;


import com.jcg.examples.dao.UserDao;

/**
 * @author CENTAUR
 */
public class UserDaoImpl implements UserDao {

	

	@Override
	public boolean isValidUser(String username, String password) throws SQLException {
        System.out.println("\nIn isValidUser of DAO");
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class found");
        }
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","asmita","oracle123"); 
        System.out.println("Connection established");
        System.out.println(username);
        System.out.println(password);
		String query = "Select count(1) from users where username = ? and password = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
        
		if (resultSet.next()) {
			System.out.println("in userDaoImpl if condition");
		    return (resultSet.getInt(1) > 0);
		} else {
			System.out.println("in userDaoImpl else condition");
			return false;
		}
        
	}

}