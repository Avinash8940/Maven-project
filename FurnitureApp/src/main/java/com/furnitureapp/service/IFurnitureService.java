package com.furnitureapp.service;

import java.util.List;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.exception.IdNotFoundException;
import com.furnitureapp.model.Furniture;

/**
 * @author AvinashSankineni
 *
 */
public interface IFurnitureService {
	/**
	 * @param funiture passing furniture by adding into database
	 */
	void addFurniture(Furniture funiture);

	/**
	 * @param furnitureId to check the furniture with required Id
	 * @param price for updating the price of required furniture
	 * @return 1-if furniture is found
	 * 			0-if furniture is not found
	 * @throws IdNotFoundException if there is no furniture available
	 */
	int updateFurniture(int furnitureId, double price)throws IdNotFoundException;

	/**
	 * @param furnitureId to delete the furniture with required Id
	 * @return 1-if furniture is found
	 * 			0-if furniture is not found
	 * @throws IdNotFoundException if there is no furniture available
	 */
	int deleteFurniture(int furnitureId)throws IdNotFoundException;

	/**
	 * @param furnitureId to check the furniture with required Id
	 * @return List-if furniture found with required category
	 *         EmptyList- if there are no furniture found
	 * @throws IdNotFoundException if there is no furniture available
	 */
	Furniture getById(int furnitureId)throws IdNotFoundException;

	/**
	 * @return List-if furniture found 
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	List<Furniture> getAllFurnitures()throws FurnitureNotFoundException;

	/**
	 * @param category to check the furniture with required category
	 * @return List-if furniture found with required category
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	List<Furniture> getByCategory(String category)throws FurnitureNotFoundException; // study room furniture

	/**
	 * @param type to check the furniture with required category
	 * @return List-if furniture found with required type
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	List<Furniture> getByType(String type)throws FurnitureNotFoundException;  //all sofas

	/**
	 * @param category to check the furniture with required category
	 * @param type to check the furniture with required type
	 * @return List-if furniture found with required category and type
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	List<Furniture> getByCategoryAndType(String category, String type)throws FurnitureNotFoundException;// all type of tables in Dining Hall

	/**
	 * @param furnitureName to check the furniture with required furnitureName
	 * @param shape to check the furniture with required shape
	 * @return List-if furniture found with required furnitureName and shape
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	List<Furniture> getByNameAndShape(String furnitureName, String shape)throws FurnitureNotFoundException;

	/**
	 * @param furnitureName to check the furniture with required furnitureName
	 * @param material to check the furniture with required material
	 * @return List-if furniture found with required furnitureName and material
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	List<Furniture> getByNameAndMaterial(String furnitureName, String material)throws FurnitureNotFoundException;

	/**
	 * @param furnitureName to check the furniture with required furnitureName
	 * @param price to check the furniture with required price
	 * @return List-if furniture found with required furnitureName and price
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	List<Furniture> getByNameAndPrice(String furnitureName, double price)throws FurnitureNotFoundException;

	/**
	 * @param furnitureName to check the furniture with required furnitureName
	 * @param category to check the furniture with required category
	 * @return List-if furniture found with required furnitureName and category
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	List<Furniture> getByNameAndCategory(String furnitureName, String category)throws FurnitureNotFoundException;

}
