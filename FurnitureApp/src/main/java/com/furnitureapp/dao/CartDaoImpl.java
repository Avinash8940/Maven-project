/**
 * 
 */
package com.furnitureapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.furnitureapp.model.Furniture;
import com.furnitureapp.model.User;
import com.furnitureapp.util.DbConnection;
import com.furnitureapp.util.Queries;

/**
 * @author AvinashSankineni
 *
 */
public class CartDaoImpl implements ICartDao {

	/**
	 * @param furnitureId knowing availability of furniture by passing furnitureId
	 * @param quantity knowing availability of furniture by passing quantity
	 * @return furniture
	 */
	@Override
	public Furniture getAvailability(int furnitureId, int quantity) {
		Furniture furniture = null;

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.GETAVAILABILITYQUERY);) {
			statement.setInt(1, furnitureId);
			statement.setInt(2, quantity);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				furniture=new Furniture();
				furniture.setFurnitureId(resultSet.getInt(1));
				furniture.setFurnitureName(resultSet.getString(2));
				furniture.setCategory(resultSet.getString(3));
				furniture.setType(resultSet.getString(4));
				furniture.setMaterial(resultSet.getString(5));
				furniture.setShape(resultSet.getString(6));
				furniture.setPrice(resultSet.getDouble(7));
				furniture.setQuantity(quantity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return furniture;
	}

	/**
	 * @param funiture  passing furniture to add cart database
	 */
	@Override
	public void addCart(Furniture furniture,User user) {
		// TODO Auto-generated method stub
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.ADDCARTQUERY);) {
			statement.setInt(1, furniture.getFurnitureId());
			statement.setString(2, furniture.getFurnitureName());
			statement.setDouble(3, furniture.getPrice());
			statement.setInt(4, furniture.getQuantity());
			statement.setString(5, user.getUsername());
			statement.setDouble(6, furniture.getPrice() * furniture.getQuantity());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param furnitureId  passing furniture to delete cart database
	 * @return 1-if cart found
	 * 			0-if cart not found
	 */
	@Override
	public int deleteCart(int furnitureId,String username) {
		// TODO Auto-generated method stub
		int result=0;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.DELETECARTQUERY);) {
			statement.setInt(1, furnitureId);
			statement.setString(2, username);
			result=statement.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
