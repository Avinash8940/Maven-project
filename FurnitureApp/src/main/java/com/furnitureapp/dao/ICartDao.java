/**
 * 
 */
package com.furnitureapp.dao;

import java.util.List;

import com.furnitureapp.model.Cart;
import com.furnitureapp.model.Furniture;
import com.furnitureapp.model.User;

/**
 * @author AvinashSankineni
 *
 */
public interface ICartDao {
	/**
	 * @param furnitureId knowing availability of furniture by passing furnitureId
	 * @param quantity knowing availability of furniture by passing quantity
	 * @return furniture
	 */
	Furniture getAvailability(int furnitureId,int quantity);
	/**
	 * @param furniture passing furniture to add cart database
	 * @param user passing furniture to add cart user
	 */
	void addCart(Furniture furniture,User user);
	/**
	 * @param furnitureId passing furnitureId to delete cart 
	 * @param username passing username to delete cart
	 * @return 1-if cart found
	 * 			0-if cart not found
	 */
	int deleteCart(int furnitureId,String username);
	/**
	 * @param username is uesd to get the cart item in the cart
	 */
	List<Cart> purchase(String username);
}
