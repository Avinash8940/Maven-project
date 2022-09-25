package com.doctorapp.util;

public class Queries {
	public static final String CREATEQUERY="create table doctor(doctorName varchar(20),doctorId Integer primary key auto_increment,speciality varchar(30),fees double,experience Integer,startTime timestamp,endTime timestamp)";
	public static final String INSERTQUERY="insert into doctor(doctorName,speciality,fees,experience,startTime,endTime) values(?,?,?,?,?,?)";
	public static final String GETBYID="select * from doctor where doctorId=?";
	public static final String UPDATEQUERY="update doctor set fees=? where doctorId=?";
	public static final String DELETEQUERY="delete from doctor where doctorId=?";
	public static final String GETALLDOCTOR="select * from doctor";
	public static final String GETBYSPECIALITY="select * from doctor where speciality=?";
	public static final String GETBYSPECIALITYANDEXP="select * from doctor where speciality=? and experience=?";
	public static final String GETBYSPECIALITYANDFEES="select * from doctor where speciality=? and fees=?";
	public static final String GETBYAVAILABILITY="select * from doctor where startTime>=?";
}
