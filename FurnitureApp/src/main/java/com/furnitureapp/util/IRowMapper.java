package com.furnitureapp.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.furnitureapp.model.Furniture;

/**
 * @author AvinashSankineni
 *
 */
public interface IRowMapper {
	/**
	 * @param resultSet  getting the resultSet values into List 
	 * @return furnitureList
	 * @throws SQLException throwing SQLException
	 */
	List<Furniture> mapRow(ResultSet resultSet) throws SQLException;
}
