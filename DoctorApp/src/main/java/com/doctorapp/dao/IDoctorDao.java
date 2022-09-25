package com.doctorapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorDao {
	Doctor getById(int doctorId);
	void addDoctor(Doctor doctor);
	int updateDoctor(int doctorId,double fees);
	int deleteDoctor(int doctorId);
	List<Doctor> getAllDoctors();
	List<Doctor> getBySpeciality(String speciality);
	List<Doctor> getBySpecialityAndExp(String speciality,int experience);
	List<Doctor> getBySpecialityAndfees(String speciality,double fees);
	List<Doctor> getByAvailability(LocalDateTime startTime);
}
