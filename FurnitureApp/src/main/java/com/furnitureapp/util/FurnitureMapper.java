package com.furnitureapp.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.furnitureapp.model.Furniture;

/**
 * @author AvinashSankineni
 *
 */
public class FurnitureMapper implements IRowMapper {

	/**
	 * @param resultSet getting the resultSet values into List 
	 * @return furnitureList
	 * @throws SQLException throwing SQLException
	 */
	@Override
	public List<Furniture> mapRow(ResultSet resultSet) throws SQLException {
		List<Furniture> furnitureList=new ArrayList<>();
		while(resultSet.next()) {
			Furniture furniture=new Furniture();
			furniture.setFurnitureId(resultSet.getInt(1));
			furniture.setFurnitureName(resultSet.getString(2));
			furniture.setMaterial(resultSet.getString(3));
			furniture.setType(resultSet.getString(4));
			furniture.setCategory(resultSet.getString(5));
			furniture.setShape(resultSet.getString(6));
			furniture.setPrice(resultSet.getDouble(7));
			furniture.setQuantity(resultSet.getInt(8));
			furnitureList.add(furniture);
		}
		return furnitureList;
	}

}
