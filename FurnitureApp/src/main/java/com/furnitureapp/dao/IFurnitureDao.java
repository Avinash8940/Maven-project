package com.furnitureapp.dao;

import java.util.List;
import com.furnitureapp.model.Furniture;

/**
 * @author AvinashSankineni
 *
 */
public interface IFurnitureDao {
	/**
	 * @param funiture for passing furniture to add into the database
	 */
	void addFurniture(Furniture funiture);
	/**
	 * @param furnitureId to check the furniture with required Id
	 * @param price to update the price of furniture
	 * @return 1-if furniture is updated
	 *   	   0-if furniture is not updated
	 */
	int updateFurniture(int furnitureId,double price);
	/**
	 * @param furnitureId used to delete the furniture in the database
	 * @return 1-if furniture is updated
	 * 		   0-if furniture is not updated
	 */
	int deleteFurniture(int furnitureId);
	/**
	 * @param furnitureId to check the furniture with required Id
	 * @return List-if furniture found with required Id
	 *         EmptyList- if there are no furniture found
	 */
	Furniture findById (int furnitureId);
	/**
	 * @return all furnitures in the database
	 */
	List<Furniture> findAllFurnitures();
	/**
	 * @param category find the furniture by using required category
	 * @return List-if furniture found with required category
	 *         EmptyList- if there are no furniture found
	 */
	List<Furniture> findByCategory(String category); // study room furniture
	/**
	 * @param type find the furniture by using required type
	 * @return List-if furniture found with required type
	 *         EmptyList- if there are no furniture found
	 */
	List<Furniture> findByType(String type);  //all sofas
	/**
	 * @param category find the furniture by using required category
	 * @param type find the furniture by using required type
	 * @return List-if furniture found with required type
	 *         EmptyList- if there are no furniture found
	 */
	List<Furniture> findByCategoryAndType(String category,String type); // all type of tables in Dining Hall
	/**
	 * @param furnitureName find the furniture by using required furnitureName
	 * @param shape find the furniture by using required shape
	 * @return List-if furniture found with required furnitureName and shape
	 *         Empty List- if there are no furniture found
	 */
	List<Furniture> findByNameAndShape(String furnitureName,String shape);
	/**
	 * @param furnitureName find the furniture by using required furnitureName
	 * @param material find the furniture by using required material
	 * @return List-if furniture found with required furnitureName and material
	 *         EmptyList- if there are no furniture found
	 */
	List<Furniture> findByNameAndMaterial(String furnitureName,String material);
	/**
	 * @param furnitureName find the furniture by using required furnitureName
	 * @param price find the furniture by using required price
	 * @return List-if furniture found with required furnitureName and price
	 *         EmptyList- if there are no furniture found
	 */
	List<Furniture> findByNameAndPrice(String furnitureName,double price);
	/**
	 * @param furnitureName  find the furniture by using required furnitureName
	 * @param category  find the furniture by using required category
	 * @return List-if furniture found with required furnitureName and price
	 *         EmptyList- if there are no furniture found
	 */
	List<Furniture> findByNameAndCategory(String furnitureName,String category);

	

}
