package com.furnitureapp.service;

import com.furnitureapp.exception.UserNotFoundException;
import com.furnitureapp.model.User;

/**
 * @author AvinashSankineni
 *
 */
public interface IUserService {
	/**
	 * @param user passing user to the database
	 * @return add user
	 * @throws UserNotFoundException if user is not found
	 */
	String register(User user)throws UserNotFoundException;
	/**
	 * @param username passing username to change password
	 * @param password passing password to change password
	 * @throws UserNotFoundException if user is not found
	 */
	void changePassword(String username,String password)throws UserNotFoundException;
	/**
	 * @param username passing username to login user
	 * @param password passing password to login user
	 * @param type  passing password to login type
	 * @return user
	 * @throws UserNotFoundException if user is not found
	 */
	User login(String username, String password,String type)throws UserNotFoundException;
}