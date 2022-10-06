/**
 * 
 */
package com.furnitureapp.service;

import com.furnitureapp.model.Furniture;
import com.furnitureapp.model.User;

/**
 * @author AvinashSankineni
 *
 */
public interface ICartService {
	/**
	 * @param furnitureId knowing availability of furniture by passing furnitureId
	 * @param quantity knowing availability of furniture by passing quantity
	 * @return furniture
	 */
	Furniture getAvailability(int furnitureId,int quantity);
	/**
	 * @param furniture passing furniture for add cart
	 * @param user passing user for add cart
	 */
	void addCart(Furniture furniture,User user);
	/**
	 * @param furnitureId passing furnitureId for delete cart
	 * @param username passing username for delete cart
	 * @return 1-if cart found
	 * 			0-if cart not found
	 */
	int deleteCart(int furnitureId,String username);
	
	
}
