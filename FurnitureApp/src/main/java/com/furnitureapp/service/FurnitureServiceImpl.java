package com.furnitureapp.service;

import java.util.ArrayList;
import java.util.List;

import com.furnitureapp.dao.FurnitureDaoImpl;
import com.furnitureapp.dao.IFurnitureDao;
import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.exception.IdNotFoundException;
import com.furnitureapp.model.Furniture;

public class FurnitureServiceImpl implements IFurnitureService {
	IFurnitureDao serviceDao=new FurnitureDaoImpl();

	public void addFurniture(Furniture furniture) {
		serviceDao.addFurniture(furniture);
		
	}

	public int updateFurniture(int furnitureId, double price) throws IdNotFoundException {
		int result=serviceDao.updateFurniture(furnitureId, price);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
	}

	public int deleteFurniture(int furnitureId) throws IdNotFoundException {
		int result=serviceDao.deleteFurniture(furnitureId);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
	}

	public Furniture getById(int furnitureId) throws IdNotFoundException {
		Furniture furniture=serviceDao.findById(furnitureId);
		if(furniture!=null)	
			return furniture;
		else
			throw new IdNotFoundException("Id Not Found");
	}

	public List<Furniture> getAllFurnitures() throws FurnitureNotFoundException {
		List<Furniture>furnitureList=serviceDao.findAllFurnitures();
	    if(furnitureList.isEmpty()) {
	    	throw new FurnitureNotFoundException("Furniture Not Found");
	    }
	    else
	    	return furnitureList;
	}

	public List<Furniture> getByCategory(String category) throws FurnitureNotFoundException {
		 List<Furniture>furnitureList=serviceDao.findByCategory(category);
		 if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	public List<Furniture> getByType(String type) throws FurnitureNotFoundException {
		 List<Furniture>furnitureList=serviceDao.findByType(type);
		 if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	public List<Furniture> getByCategoryAndType(String category, String type) throws FurnitureNotFoundException {
		List<Furniture>furnitureList=serviceDao.findByCategoryAndType(category, type);
		if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	public List<Furniture> getByNameAndShape(String furnitureName, String shape) throws FurnitureNotFoundException {
		List<Furniture>furnitureList=serviceDao.findByNameAndShape(furnitureName, shape);
		if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	public List<Furniture> getByNameAndMaterial(String furnitureName, String material) throws FurnitureNotFoundException {
		List<Furniture>furnitureList=serviceDao.findByNameAndMaterial(furnitureName, material);
		if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	public List<Furniture> getByNameAndPrice(String furnitureName, double price) throws FurnitureNotFoundException {
		List<Furniture>furnitureList=serviceDao.findByNameAndPrice(furnitureName, price);
		if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}

	public List<Furniture> getByNameAndCategory(String furnitureName, String category) throws FurnitureNotFoundException {
		List<Furniture>furnitureList=new ArrayList<>();
		furnitureList=serviceDao.findByNameAndCategory(furnitureName, category);
		if(furnitureList.isEmpty())
			 throw new FurnitureNotFoundException("Furniture Not Found");
		 else
			 return furnitureList;
	}
}