package com.furnitureapp.service;

import java.util.ArrayList;
import java.util.List;

import com.furnitureapp.dao.FurnitureDaoImpl;
import com.furnitureapp.dao.IFurnitureDao;
import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.exception.IdNotFoundException;
import com.furnitureapp.model.Furniture;

/**
 * @author AvinashSankineni
 *
 */
public class FurnitureServiceImpl implements IFurnitureService {
	IFurnitureDao serviceDao=new FurnitureDaoImpl();

	/**
	 * @param furniture passing the furniture to add the database
	 */
	public void addFurniture(Furniture furniture) {
		serviceDao.addFurniture(furniture);
		
	}

	/**
	 * @param furnitureId to check the furniture with required furnitureId
	 * @param price to update the furniture
	 * @return 1-if furniture is found
	 * 			0-if furniture is not found
	 * @throws IdNotFoundException if there is no furniture is available
	 */
	public int updateFurniture(int furnitureId, double price) throws IdNotFoundException {
		int result=serviceDao.updateFurniture(furnitureId, price);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
	}

	/**
	 * @param furnitureId to delete the furniture with required furnitureId
	 * @return 1-if furniture is found
	 * 			0-if furniture is not found
	 * @throws IdNotFoundException if there is no furniture is available
	 */
	public int deleteFurniture(int furnitureId) throws IdNotFoundException {
		int result=serviceDao.deleteFurniture(furnitureId);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
	}

	/**
	 * @param furnitureId to get the furniture with required furnitureId
	 * @return List-if furniture found with required Id
	 *         EmptyList- if there are no furniture found
	 * @throws IdNotFoundException if the furniture is null
	 */
	public Furniture getById(int furnitureId) throws IdNotFoundException {
		Furniture furniture=serviceDao.findById(furnitureId);
		if(furniture!=null)	
			return furniture;
		else
			throw new IdNotFoundException("Id Not Found");
	}

	/**
	 * @return List-if furniture found
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	public List<Furniture> getAllFurnitures() throws FurnitureNotFoundException {
		List<Furniture>furnitureList=serviceDao.findAllFurnitures();
	    if(furnitureList.isEmpty()) {
	    	throw new FurnitureNotFoundException("Furniture Not Found");
	    }
	    else
	    	return furnitureList;
	}

	/**
	 * @param category to get the furniture with required category
	 * @return List-if furniture found with required category
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	public List<Furniture> getByCategory(String category) throws FurnitureNotFoundException {
		 List<Furniture>furnitureList=serviceDao.findByCategory(category);
		 if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	/**
	 * @param type to get the furniture with required type
	 * @return List-if furniture found with required type
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	public List<Furniture> getByType(String type) throws FurnitureNotFoundException {
		 List<Furniture>furnitureList=serviceDao.findByType(type);
		 if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	/**
	 * @param category to get the furniture with required category
	 * @param type to get the furniture with required type
	 * @return List-if furniture found with required category and type
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	public List<Furniture> getByCategoryAndType(String category, String type) throws FurnitureNotFoundException {
		List<Furniture>furnitureList=serviceDao.findByCategoryAndType(category, type);
		if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	/**
	 * @param furnitureName to get the furniture with required furnitureName
	 * @param shape to get the furniture with required shape
	 * @return List-if furniture found with required furnitureName and shape
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException when furniture is not found
	 */
	public List<Furniture> getByNameAndShape(String furnitureName, String shape) throws FurnitureNotFoundException {
		List<Furniture>furnitureList=serviceDao.findByNameAndShape(furnitureName, shape);
		if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	/**
	 * @param furnitureName to get the furniture with required furnitureName
	 * @param material to get the furniture with required material
	 * @return List-if furniture found with required furnitureName and material
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty 
	 */
	public List<Furniture> getByNameAndMaterial(String furnitureName, String material) throws FurnitureNotFoundException {
		List<Furniture>furnitureList=serviceDao.findByNameAndMaterial(furnitureName, material);
		if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	/**
	 * @param furnitureName to get the furniture with required furnitureName
	 * @param price to get the furniture with required price
	 * @return List-if furniture found with required furnitureName and price
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	public List<Furniture> getByNameAndPrice(String furnitureName, double price) throws FurnitureNotFoundException {
		List<Furniture>furnitureList=serviceDao.findByNameAndPrice(furnitureName, price);
		if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	/**
	 * @param furnitureName to get the furniture with required furnitureName 
	 * @param category to get the furniture with required category
	 * @return List-if furniture found with required furnitureName and category
	 *         EmptyList- if there are no furniture found
	 * @throws FurnitureNotFoundException if the furniture is empty
	 */
	public List<Furniture> getByNameAndCategory(String furnitureName, String category) throws FurnitureNotFoundException {
		List<Furniture>furnitureList=new ArrayList<>();
		furnitureList=serviceDao.findByNameAndCategory(furnitureName, category);
		if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}
}