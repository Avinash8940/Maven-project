package com.doctorapp.dao;

import java.sql.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.DbConnection;
import com.doctorapp.util.Queries;

public class DoctorDaoImpl implements IDoctorDao {
	DbConnection database = new DbConnection();
	List<Doctor> doctorList=new ArrayList<>();
	Connection connection = null;
	PreparedStatement statement = null;
	//Doctor doctor = new Doctor();

	@Override
	public Doctor getById(int doctorId) {
		
		connection = database.getConnection();
		try {
			statement = connection.prepareStatement(Queries.GETBYID);
			statement.setInt(1, doctorId);
			ResultSet rs = statement.executeQuery();
			Doctor doctor = new Doctor();
			while (rs.next()) {
				doctor.setDoctorName(rs.getString(1));
				doctor.setDoctorId(rs.getInt(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setFees(rs.getDouble(4));
				doctor.setExperience(rs.getInt(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				return doctor;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (statement != null)
				try {
					statement.close();
					if (connection != null)
						statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}


	@Override
	public void addDoctor(Doctor doctor) {
		String sql = Queries.INSERTQUERY;
		connection = database.getConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, doctor.getDoctorName());
			statement.setString(2, doctor.getSpeciality());
			statement.setDouble(3, doctor.getFees());
			statement.setInt(4, doctor.getExperience());
			statement.setTimestamp(5, Timestamp.valueOf(doctor.getStartTime()));
			statement.setTimestamp(6, Timestamp.valueOf(doctor.getEndTime()));
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	@Override
	public int updateDoctor(int doctorId, double fees) {
		connection = database.getConnection();
		int check = 0;

		try {
			statement = connection.prepareStatement(Queries.UPDATEQUERY);
			statement.setDouble(1, fees);
			statement.setInt(2, doctorId);
		    check=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return check;
	}

	@Override
	public int deleteDoctor(int doctorId) {
		connection = database.getConnection();
		int check=0;
		try {
			statement = connection.prepareStatement(Queries.DELETEQUERY);
			statement.setInt(1, doctorId);
			check=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
					if (connection != null)
						statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return check;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctorList=new ArrayList<>();
		connection=database.getConnection();
		try {
			statement=connection.prepareStatement(Queries.GETALLDOCTOR);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorName(rs.getString(1));
				doctor.setDoctorId(rs.getInt(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setFees(rs.getDouble(4));
				doctor.setExperience(rs.getInt(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
				
		}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if (statement != null)
				try {
					statement.close();
					if (connection != null)
						statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		List<Doctor> doctorList=new ArrayList<>();
		connection=database.getConnection();
		try {
			statement=connection.prepareStatement(Queries.GETBYSPECIALITY);
			statement.setString(1, speciality);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorName(rs.getString(1));
				doctor.setDoctorId(rs.getInt(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setFees(rs.getDouble(4));
				doctor.setExperience(rs.getInt(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
				
				} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (statement != null)
				try {
					statement.close();
					if (connection != null)
						statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
      return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) {
		List<Doctor> doctorList=new ArrayList<>();
		connection=database.getConnection();
		try {
			statement=connection.prepareStatement(Queries.GETBYSPECIALITYANDEXP);
			statement.setString(1, speciality);
			statement.setInt(2, experience);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorName(rs.getString(1));
				doctor.setDoctorId(rs.getInt(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setFees(rs.getDouble(4));
				doctor.setExperience(rs.getInt(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if (statement != null)
				try {
					statement.close();
					if (connection != null)
						statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndfees(String speciality, double fees) {
		List<Doctor> doctorList=new ArrayList<>();
		connection=database.getConnection();
		try {
			statement=connection.prepareStatement(Queries.GETBYSPECIALITYANDFEES);
			statement.setString(1, speciality);
			statement.setDouble(2, fees);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorName(rs.getString(1));
				doctor.setDoctorId(rs.getInt(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setFees(rs.getDouble(4));
				doctor.setExperience(rs.getInt(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if (statement != null)
				try {
					statement.close();
					if (connection != null)
						statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getByAvailability(LocalDateTime startTime) {
		List<Doctor> doctorList=new ArrayList<>();
		connection=database.getConnection();
		try {
			statement=connection.prepareStatement(Queries.GETBYAVAILABILITY);
			statement.setTimestamp(1, Timestamp.valueOf(startTime));
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorName(rs.getString(1));
				doctor.setDoctorId(rs.getInt(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setFees(rs.getDouble(4));
				doctor.setExperience(rs.getInt(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctorList;
	}
	}


