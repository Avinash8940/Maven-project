package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.exception.IdNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService {
	Doctor getById(int doctorId) throws IdNotFoundException;
	void addDoctor(Doctor doctor);
	int updateDoctor(int doctorId,double fees)throws IdNotFoundException;
	int deleteDoctor(int doctorId)throws IdNotFoundException;
	List<Doctor> getAllDoctors() throws DoctorNotFoundException;
	List<Doctor> getBySpeciality(String speciality)throws DoctorNotFoundException;
	List<Doctor> getBySpecialityAndExp(String speciality,int experience)throws DoctorNotFoundException;
	List<Doctor> getBySpecialityAndfees(String speciality,double fees)throws DoctorNotFoundException;
	List<Doctor> getByAvailability(LocalDateTime startTime)throws DoctorNotFoundException;
}
