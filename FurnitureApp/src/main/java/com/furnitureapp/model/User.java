package com.furnitureapp.model;

public class User {
	private String username;
	private String name;
	private long mobileNo;
	private String email;
	private String city;
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String name, long mobileNo, String email, String city, String password) {
		super();
		this.username = username;
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.city = city;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", city=" + city + ", password=" + password + "]";
	}
	
}