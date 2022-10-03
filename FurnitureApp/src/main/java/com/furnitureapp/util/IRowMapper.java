package com.furnitureapp.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.furnitureapp.model.Furniture;

public interface IRowMapper {
	List<Furniture> mapRow(ResultSet resultSet) throws SQLException;
}
