/**
 * 
 */
package com.furnitureapp.model;

/**
 * @author AvinashSankineni
 *
 */
public class Cart {
	private String productName;
	private int productId;
	private int quantity;
	private double price;
	private String username;
	private double bill;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String productName, int productId, int quantity, double price, String username, double bill) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.username = username;
		this.bill = bill;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "Cart [productName=" + productName + ", productId=" + productId + ", quantity=" + quantity + ", price="
				+ price + ", username=" + username + ", bill=" + bill + "]";
	}
	
	
	}