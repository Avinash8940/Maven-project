package com.furnitureapp.model;

/**
 * @author AvinashSankineni
 *
 */
public class Furniture {
	private Integer furnitureId;
	private String furnitureName;
	private String material;
	private String type;
	private String category;
	private String shape;
	private double price;
	private int quantity;
	public Furniture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Furniture(Integer furnitureId, String furnitureName, String material, String type, String category,
			String shape, double price, int quantity) {
		super();
		this.furnitureId = furnitureId;
		this.furnitureName = furnitureName;
		this.material = material;
		this.type = type;
		this.category = category;
		this.shape = shape;
		this.price = price;
		this.quantity = quantity;
	}
	public Integer getFurnitureId() {
		return furnitureId;
	}
	public void setFurnitureId(Integer furnitureId) {
		this.furnitureId = furnitureId;
	}
	public String getFurnitureName() {
		return furnitureName;
	}
	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Furniture [furnitureId=" + furnitureId + ", furnitureName=" + furnitureName + ", material=" + material
				+ ", type=" + type + ", category=" + category + ", shape=" + shape + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
}