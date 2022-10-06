/**
 * 
 */
package com.furnitureapp.service;

import com.furnitureapp.dao.CartDaoImpl;
import com.furnitureapp.dao.ICartDao;
import com.furnitureapp.exception.UserNotFoundException;
import com.furnitureapp.model.Furniture;
import com.furnitureapp.model.User;

/**
 * @author AvinashSankineni
 *
 */
public class CartServiceImpl implements ICartService {
	ICartDao cartService=new CartDaoImpl();

	/**
	 * @param furnitureId knowing availability of furniture by passing furnitureId
	 * @param quantity knowing availability of furniture by passing quantity
	 * @return furniture
	 */
	@Override
	public Furniture getAvailability(int furnitureId, int quantity) {
		// TODO Auto-generated method stub
		
		Furniture furniture=cartService.getAvailability(furnitureId, quantity);
		if(furniture==null)
			throw new NullPointerException("Id Not Found");
		return furniture;
	}

	/**
	 * @param furniture passing furniture for add cart
	 * @param user passing user for add cart
	 */
	@Override
	public void addCart(Furniture furniture,User user) {
		// TODO Auto-generated method stub
		cartService.addCart(furniture,user);

	}

	
	/**
	 * @param furnitureId passing furnitureId for delete cart
	 * @param username passing username for delete cart
	 * @return check
	 */
	@Override
	public int deleteCart(int furnitureId,String username) {
		// TODO Auto-generated method stub
		int check=cartService.deleteCart(furnitureId,username);
		if(check==0)
			throw new UserNotFoundException("empty cart");
		return check;
	}

}
