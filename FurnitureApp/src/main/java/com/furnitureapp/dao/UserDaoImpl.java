package com.furnitureapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.furnitureapp.model.User;
import com.furnitureapp.util.DbConnection;
import com.furnitureapp.util.PasswordGenerator;
import com.furnitureapp.util.Queries;

/**
 * @author AvinashSankineni
 *
 */
public class UserDaoImpl implements IUserDao {
	

	/**
	 * @param user passing user to the database
	 * @return password by user
	 */
	@Override
	public String addUser(User user) {
		
		String password=PasswordGenerator.generatePassword(10);
		try (Connection connection=DbConnection.openConnection();
			PreparedStatement statement=connection.prepareStatement(Queries.ADDUSERQUERY);){
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getName());
			statement.setLong(3, user.getMobileNo());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getCity());
			statement.setString(6, password);
			statement.setString(7, user.getType());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	/**
	 * @param username to check the user to by username
	 * @param password to check the user to by password
	 * @return user
	 */
	@Override
	public User findByUsername(String username, String password) {
		User user=new User();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
			PreparedStatement statement=connection.prepareStatement(Queries.FINDUSERNAMEQUERY);){
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				user.setUsername(resultSet.getString(2));
				//user.setPassword(resultSet.getString(3));
				user.setName(resultSet.getString(4));
				user.setCity(resultSet.getString(5));
				user.setEmail(resultSet.getString(6));
				user.setMobileNo(resultSet.getLong(7));
				user.setType(resultSet.getString(8));;
				
				return user;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(resultSet!=null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}

	/**
	 * @param username to check the user to by username
	 * @param password to check the user to change password
	 * @return result
	 */
	@Override
	public int changePassword(String username,String password) {
		int result=0;
		try (Connection connection=DbConnection.openConnection();
			PreparedStatement statement=connection.prepareStatement(Queries.CHANGEPASSWORDQUERY);){
			statement.setString(1, password);
			statement.setString(2, username);
			result=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
