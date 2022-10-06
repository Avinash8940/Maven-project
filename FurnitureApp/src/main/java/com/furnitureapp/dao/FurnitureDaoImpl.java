package com.furnitureapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.furnitureapp.model.Furniture;
import com.furnitureapp.util.DbConnection;
import com.furnitureapp.util.FurnitureMapper;
import com.furnitureapp.util.IRowMapper;
import com.furnitureapp.util.Queries;

/**
 * @author AvinashSankineni
 *
 */
public class FurnitureDaoImpl implements IFurnitureDao {
	/**
	 * @param furniture for passing furniture to add into the database
	 */
	public void addFurniture(Furniture furniture) {
		try (Connection connection=DbConnection.openConnection();
			PreparedStatement statement=connection.prepareStatement(Queries.ADDQUERY);){
			statement.setInt(1, furniture.getFurnitureId());
			statement.setString(2, furniture.getFurnitureName());
			statement.setString(3, furniture.getMaterial());
			statement.setString(4, furniture.getType());
			statement.setString(5, furniture.getCategory());
			statement.setString(6, furniture.getShape());
			statement.setDouble(7, furniture.getPrice());
			statement.setInt(8, furniture.getQuantity());
			statement.execute();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param furnitureId to check the furniture with required Id
	 * @param price  to update the furniture with required price
	 * @return 1-if furniture is found
	 *   	   0-if furniture is not found
	 */
	public int updateFurniture(int furnitureId, double price) {
		int result=0;
		try (Connection connection=DbConnection.openConnection();
			PreparedStatement statement=connection.prepareStatement(Queries.UPDATEQUERY);){
			statement.setDouble(1, price);
			statement.setInt(2, furnitureId);
			result=statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("ADDED SUCCESSFULLY");	
		return result;
	}

	/**
	 * @param furnitureId to check the furniture with required Id
	 * @return 1-if furniture is found
	 *   	   0-if furniture is not found
	 */
	public int deleteFurniture(int furnitureId) {
		
		int result=0;
		try (Connection connection=DbConnection.openConnection();
			PreparedStatement statement=connection.prepareStatement(Queries.DELETEQUERY);){
			statement.setInt(1, furnitureId);
			result=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return result;	
	}

	/**
	 * @param furnitureId to check the furniture with required Id
	 * @return List-if furniture found with required Id
	 *         EmptyList- if there are no furniture found
	 */
	public Furniture findById(int furnitureId) {
		
		Furniture furniture=new Furniture();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
			PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYID);){
			statement.setInt(1, furnitureId);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				furniture.setFurnitureId(resultSet.getInt(1));
				furniture.setFurnitureName(resultSet.getString(2));
				furniture.setMaterial(resultSet.getString(3));
				furniture.setType(resultSet.getString(4));
				furniture.setCategory(resultSet.getString(5));
				furniture.setShape(resultSet.getString(6));
				furniture.setPrice(resultSet.getDouble(7));
				furniture.setQuantity(resultSet.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return furniture;
	}
	

	/**
	 * @return List-if furniture found 
	 *         EmptyList- if there are no furniture found
	 */
	public List<Furniture> findAllFurnitures() {
		List<Furniture> furnitureList=new ArrayList<>();
		
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYALL);){
			resultSet=statement.executeQuery();
			IRowMapper mapper=new FurnitureMapper();
			furnitureList=mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return furnitureList;
	}
	/**
	 * @param category to check the furniture with required category
	 * @return List-if furniture found with required category
	 *         EmptyList- if there are no furniture found
	 */
	public List<Furniture> findByCategory(String category) {
		List<Furniture> furnitureList=new ArrayList<Furniture>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYCATEGORY);){
			statement.setString(1, category);
			resultSet=statement.executeQuery();
			IRowMapper mapper=new FurnitureMapper();
			furnitureList=mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return furnitureList;
	}

	/**
	 * @param type to check the furniture with required type
	 * @return List-if furniture found with required type
	 *         EmptyList- if there are no furniture found
	 */
	public List<Furniture> findByType(String type) {
		List<Furniture> furnitureList=new ArrayList<Furniture>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYTYPE);){
			statement.setString(1, type);
			resultSet=statement.executeQuery();
			IRowMapper mapper=new FurnitureMapper();
			furnitureList=mapper.mapRow(resultSet);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return furnitureList;
	}

	/**
	 * @param category to check the furniture with required category
	 * @param type to check the furniture with required type
	 * @return List-if furniture found with required category and type
	 *         EmptyList- if there are no furniture found
	 */
	public List<Furniture> findByCategoryAndType(String category, String type) {
		List<Furniture> furnitureList=new ArrayList<Furniture>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYCATEGORYANDTYPE);){
			statement.setString(1, category);
			statement.setString(2, type);
			resultSet=statement.executeQuery();
			IRowMapper mapper=new FurnitureMapper();
			furnitureList=mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					if(resultSet!=null)
						resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return furnitureList;
	}

	/**
	 * @param furnitureName to check the furniture with required furnitureName
	 * @param shape to check the furniture with required shape
	 * @return List-if furniture found with required furnitureName and shape
	 *         EmptyList- if there are no furniture found
	 */
	public List<Furniture> findByNameAndShape(String furnitureName, String shape) {
		List<Furniture> furnitureList=new ArrayList<Furniture>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYNAMEANDSHAPE);){
			statement.setString(1, furnitureName);
			statement.setString(2, shape);
			resultSet=statement.executeQuery();
			IRowMapper mapper=new FurnitureMapper();
			furnitureList=mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					if(resultSet!=null)
						resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return furnitureList;
	}

	/**
	 * @param furnitureName to check the furniture with required furnitureName
	 * @param material to check the furniture with required material
	 * @return List-if furniture found with required furnitureName and material
	 *         EmptyList- if there are no furniture found
	 */
	public List<Furniture> findByNameAndMaterial(String furnitureName, String material) {
		List<Furniture> furnitureList=new ArrayList<Furniture>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYNAMEANDMATERIAL);){
			statement.setString(1, furnitureName);
			statement.setString(2, material);
			resultSet=statement.executeQuery();
			IRowMapper mapper=new FurnitureMapper();
			furnitureList=mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					if(resultSet!=null)
						resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return furnitureList;
	}

	/**
	 * @param furnitureName to check the furniture with required furnitureName
	 * @param price to check the furniture with required price
	 * @return List-if furniture found with required furnitureName and price
	 *         EmptyList- if there are no furniture found
	 */
	public List<Furniture> findByNameAndPrice(String furnitureName, double price) {
		List<Furniture> furnitureList=new ArrayList<Furniture>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYNAMEANDPRICE);){
			statement.setString(1, furnitureName);
			statement.setDouble(2, price);
			resultSet=statement.executeQuery();
			IRowMapper mapper=new FurnitureMapper();
			furnitureList=mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					if(resultSet!=null)
						resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return furnitureList;
	}

	/**
	 * @param furnitureName to check the furniture with required furnitureName
	 * @param category to check the furniture with required category
	 * @return List-if furniture found with required furnitureName and category
	 *         EmptyList- if there are no furniture found
	 */
	public List<Furniture> findByNameAndCategory(String furnitureName, String category) {
		List<Furniture> furnitureList=new ArrayList<Furniture>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYNAMEANDCATEGORY);){
			statement.setString(1, furnitureName);
			statement.setString(2, category);
			resultSet=statement.executeQuery();
			IRowMapper mapper=new FurnitureMapper();
			furnitureList=mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					if(resultSet!=null)
						resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return furnitureList;
	}
}

