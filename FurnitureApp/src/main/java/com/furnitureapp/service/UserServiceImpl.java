package com.furnitureapp.service;

import com.furnitureapp.dao.IUserDao;
import com.furnitureapp.dao.UserDaoImpl;
import com.furnitureapp.exception.UserNotFoundException;
import com.furnitureapp.model.User;
import com.furnitureapp.util.PasswordGenerator;

public class UserServiceImpl implements IUserService {
	IUserDao userDao=new UserDaoImpl();

	@Override
	public String register(User user)throws UserNotFoundException {
		String password=PasswordGenerator.generatePassword(10);
		// TODO Auto-generated method stub
		//user.setPassword(password);
		return userDao.addUser(user);
	}
	@Override
	public User login(String username, String password)throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user=userDao.findByUsername(username, password);
		if(user!=null)
			return user;
		else
			throw new UserNotFoundException("user not found");
	}
	@Override
	public void changePassword(String username,String password)throws UserNotFoundException {
		// TODO Auto-generated method stub
		int check=userDao.changePassword(username, password);
		if(check==0)
			throw new UserNotFoundException("user not found");
		else
			System.out.println("Password changed");
			
	}

}
