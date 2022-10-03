package com.furnitureapp.service;

import java.util.List;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.exception.IdNotFoundException;
import com.furnitureapp.model.Furniture;

public interface IFurnitureService {
	void addFurniture(Furniture funiture);

	int updateFurniture(int furnitureId, double price)throws IdNotFoundException;

	int deleteFurniture(int furnitureId)throws IdNotFoundException;

	Furniture getById(int furnitureId)throws IdNotFoundException;

	List<Furniture> getAllFurnitures()throws FurnitureNotFoundException;

	List<Furniture> getByCategory(String category)throws FurnitureNotFoundException; // study room furniture

	List<Furniture> getByType(String type)throws FurnitureNotFoundException;  //all sofas

	List<Furniture> getByCategoryAndType(String category, String type)throws FurnitureNotFoundException;// all type of tables in Dining Hall

	List<Furniture> getByNameAndShape(String furnitureName, String shape)throws FurnitureNotFoundException;

	List<Furniture> getByNameAndMaterial(String furnitureName, String material)throws FurnitureNotFoundException;

	List<Furniture> getByNameAndPrice(String furnitureName, double price)throws FurnitureNotFoundException;

	List<Furniture> getByNameAndCategory(String furnitureName, String category)throws FurnitureNotFoundException;

}
