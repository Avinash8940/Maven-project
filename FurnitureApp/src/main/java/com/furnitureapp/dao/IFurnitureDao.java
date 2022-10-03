package com.furnitureapp.dao;

import java.util.List;
import com.furnitureapp.model.Furniture;

public interface IFurnitureDao {
	void addFurniture(Furniture funiture);
	int updateFurniture(int furnitureId,double price);
	int deleteFurniture(int furnitureId);
	Furniture findById (int furnitureId);
	List<Furniture> findAllFurnitures();
	List<Furniture> findByCategory(String category); // study room furniture
	List<Furniture> findByType(String type);  //all sofas
	List<Furniture> findByCategoryAndType(String category,String type); // all type of tables in Dining Hall
	List<Furniture> findByNameAndShape(String furnitureName,String shape);
	List<Furniture> findByNameAndMaterial(String furnitureName,String material);
	List<Furniture> findByNameAndPrice(String furnitureName,double price);
	List<Furniture> findByNameAndCategory(String furnitureName,String category);

	

}
