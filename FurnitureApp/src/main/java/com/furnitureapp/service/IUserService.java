package com.furnitureapp.service;

import com.furnitureapp.exception.UserNotFoundException;
import com.furnitureapp.model.User;

public interface IUserService {
	String register(User user)throws UserNotFoundException;
	void changePassword(String username,String password)throws UserNotFoundException;
	User login(String username, String password)throws UserNotFoundException;
}