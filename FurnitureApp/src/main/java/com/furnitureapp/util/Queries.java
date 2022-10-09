package com.furnitureapp.util;

/**
 * @author AvinashSankineni
 *
 */
public class Queries {
	public static final String CREATEQUERY="create table furnituree(furnitureId Integer primary key auto_increment,furnitureName varchar(30),material varchar(20),type varchar(20),category varchar(20),shape varchar(20),price double)";
	public static final String ADDQUERY="insert into furnituree(furnitureId,furnitureName,material,type,category,shape,price,quantity) values(?,?,?,?,?,?,?,?)";
	public static final String UPDATEQUERY="update furnituree set price=? where furnitureId=?";
	public static final String DELETEQUERY="delete from furnituree where furnitureId=?";
	public static final String QUERYBYID="select * from furnituree where furnitureId=?";
	public static final String QUERYALL="select * from furnituree";
	public static final String QUERYBYCATEGORY="select * from furnituree where category=?";
	public static final String QUERYBYTYPE="select * from furnituree where type=?";
	public static final String QUERYBYCATEGORYANDTYPE="select * from furnituree where category=? and type=?";
	public static final String QUERYBYNAMEANDSHAPE="select * from furnituree where furnitureName like concat('%',?,'%') and shape=?";
	public static final String QUERYBYNAMEANDMATERIAL="select * from furnituree where furnitureName like concat('%',?,'%') and material=?";
	public static final String QUERYBYNAMEANDPRICE="select * from furnituree where furnitureName like concat('%',?,'%') and price=?";
	public static final String QUERYBYNAMEANDCATEGORY="select * from furnituree where furnitureName like concat('%',?,'%') and category=?";
	public static final String ADDUSERQUERY="insert into user(username,name,mobileNo,email,city,password,type) values(?,?,?,?,?,?,?)";
	public static final String FINDUSERNAMEQUERY="select * from user where username=? and password=?";
	public static final String CHANGEPASSWORDQUERY="update user set password=? where username=?";
	public static final String GETAVAILABILITYQUERY="select * from furnituree where furnitureId=? and quantity>=?";
	public static final String ADDCARTQUERY="insert into carts(furnitureId,furnitureName,price,quantity,username,bill) values(?,?,?,?,?,?)";
	public static final String DELETECARTQUERY="delete from carts where furnitureId=? and username=?";
	public static final String PURCHASEQUERY="select * from carts where username=?";
}
