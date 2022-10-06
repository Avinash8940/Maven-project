package com.furnitureapp.model;

/**
 * @author AvinashSankineni
 *
 */
public enum Material {
	STEEL("Steel"),
	IRON("Iron"),
	WOOD("Wood"),
	DECOLAM("Decolams"),
	GLASS("Glass");
	

	public String material;

	Material(String material) {
		this.material = material;
	}
	
}
