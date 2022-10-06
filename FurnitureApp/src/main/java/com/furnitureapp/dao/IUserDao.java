package com.furnitureapp.dao;

import com.furnitureapp.model.User;

/**
 * @author AvinashSankineni
 *
 */
public interface IUserDao {
	/**
	 * @param user passing user to the database
	 * @return password by user
	 */
	String addUser(User user);
	/**
	 * @param username to check the user to by username
	 * @param password to check the user to change password
	 * @return user
	 */
	int changePassword(String username,String password);
	/**
	 * @param username to check the user to by username
	 * @param password to check the user to by password
	 * @return result
	 */
	User findByUsername(String username, String password);
	
}
