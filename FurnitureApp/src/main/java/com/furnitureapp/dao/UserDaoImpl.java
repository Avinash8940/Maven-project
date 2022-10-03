package com.furnitureapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.furnitureapp.model.User;
import com.furnitureapp.util.DbConnection;
import com.furnitureapp.util.Queries;

public class UserDaoImpl implements IUserDao {
	

	@Override
	public String addUser(User user) {
		
		try (Connection connection=DbConnection.openConnection();
			PreparedStatement statement=connection.prepareStatement(Queries.ADDUSERQUERY);){
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getName());
			statement.setLong(3, user.getMobileNo());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getCity());
			//statement.setInt(6, user.getUserId());
			statement.setString(6,user.getPassword());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user.getPassword();
	}

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
				user.setName(resultSet.getString(4));
				user.setMobileNo(resultSet.getLong(7));
				user.setEmail(resultSet.getString(6));
				user.setCity(resultSet.getString(5));
				//user.setUserId(resultSet.getInt(6));
				user.setPassword(resultSet.getString(3));
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
