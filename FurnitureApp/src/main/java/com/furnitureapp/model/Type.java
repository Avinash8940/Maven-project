package com.furnitureapp.model;

/**
 * @author AvinashSankineni
 *
 */
public enum Type {
	TWOSOFA("Flex Two Seater Sofas"),
	FOURSOFA("Flex Four-seater Sofas"),
	BEDS("Santorini Beds,Vitello Beds"),
	SINGLEBED("Pico Single Beds"),
	TABLES("Pico Bedside Tables"),
	CENTERTABLE("Mili Center Tables"),
	CHAIRS("Rocking Chairs"),
	STUDYCHAIR("Study Chairs"),
	RACKS("Fusil Shoe Racks");
	
	public String type;
	
	Type(String type) {
		this.type= type;
	}	
}
