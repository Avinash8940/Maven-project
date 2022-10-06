package com.furnitureapp.model;

/**
 * @author AvinashSankineni
 *
 */
public enum Category {
	STUDYROOM("Study Room"),
	HALL("Hall"),
	BEDROOM("Bed Room"),
	DINING("Dining Room"),
	OFFICE("Office");
	
	public String category;
	
	Category(String category) {
		this.category=category;
	}
}
