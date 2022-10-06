package com.furnitureapp.service;

import com.furnitureapp.dao.IUserDao;
import com.furnitureapp.dao.UserDaoImpl;
import com.furnitureapp.exception.UserNotFoundException;
import com.furnitureapp.model.User;
import com.furnitureapp.util.PasswordGenerator;

/**
 * @author AvinashSankineni
 *
 */
public class UserServiceImpl implements IUserService {
	IUserDao userDao=new UserDaoImpl();

	/**
	 * @param user passing user to the database
	 * @return add user
	 * @throws UserNotFoundException if user not found
	 */
	@Override
	public String register(User user)throws UserNotFoundException {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}
	/**
	 * @param username passing username to user login
	 * @param password passing password to user login
	 * @param type passing type to user login
	 * @return user
	 * @throws UserNotFoundException if user is not found
	 */
	@Override
	public User login(String username, String password,String type)throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user=userDao.findByUsername(username, password);
		if(user!=null && user.getType().equalsIgnoreCase(type))
			return user;
		else
			throw new UserNotFoundException("invalid");
	}
	/**
	 * @param username passing username to change password
	 * @param password passing password to change password
	 * @throws UserNotFoundException if user is not found
	 */
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
