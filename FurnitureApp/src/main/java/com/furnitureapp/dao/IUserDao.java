package com.furnitureapp.dao;

import com.furnitureapp.model.User;

public interface IUserDao {
	String addUser(User user);
	int changePassword(String username,String password);
	User findByUsername(String username, String password);
	
}
