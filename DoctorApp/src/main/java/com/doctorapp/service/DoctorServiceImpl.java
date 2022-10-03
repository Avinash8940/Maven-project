package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.doctorapp.dao.IDoctorDao;
import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.exception.IdNotFoundException;
import com.doctorapp.dao.DoctorDaoImpl;
import com.doctorapp.model.Doctor;

public class DoctorServiceImpl implements IDoctorService {
	/*DbConnection database=new DbConnection();
	Connection connection=null;*/
	List<Doctor>doctorList=new ArrayList<>();
	int check;
	//Doctor doctor=new Doctor();
	IDoctorDao service=new DoctorDaoImpl();
	@Override
	public Doctor getById(int doctorId) throws IdNotFoundException{
		Doctor doctor=service.getById(doctorId);
		/*
		 * Optional<Object> option = Optional.of(doctor); if(option.isEmpty()) { throw
		 * new IdNotFoundException("doctor not found by id"); } else return doctor;
		 */
		if(doctor!=null)
			return doctor;
			else
				throw new IdNotFoundException("doctor not found by id");
	}

	@Override
	public void addDoctor(Doctor doctor){
		service.addDoctor(doctor);
	}

		@Override
	public int updateDoctor(int doctorId, double fees) throws IdNotFoundException {
		check=service.updateDoctor(doctorId,fees);
		if(check==0) {
			throw new IdNotFoundException("id not found");
		}else
			System.out.println("updated successfully");
		return check;
		
	}

	@Override
	public int deleteDoctor(int doctorId)throws IdNotFoundException {
		check=service.deleteDoctor(doctorId);
		if(check==0) {
			throw new IdNotFoundException("delete id not found");
		}
		else
			System.out.println("doctor deleted successfully");
		return check;
		
	}

	@Override
	public List<Doctor> getAllDoctors()throws DoctorNotFoundException {
		doctorList=service.getAllDoctors();
		if(doctorList.isEmpty()) {
			throw new DoctorNotFoundException("Doctors not found");
		}
		return doctorList.stream()
				.sorted((item1,item2)->item1.getDoctorName().compareTo(item2.getDoctorName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
		doctorList=service.getBySpeciality(speciality);
		if(doctorList.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found by speciality");
		}
		else
			return doctorList.stream()
					.sorted((item1,item2)->item1.getDoctorName().compareTo(item2.getDoctorName()))
					.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
		doctorList=service.getBySpecialityAndExp(speciality, experience);
		if(doctorList.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found speciality and experience");
		}
		else
			return doctorList.stream()
					.sorted((item1,item2)->item1.getDoctorName().compareTo(item2.getDoctorName()))
					.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityAndfees(String speciality, double fees)throws DoctorNotFoundException{
		List<Doctor> doctorList=new ArrayList<>();
		doctorList=service.getBySpecialityAndfees(speciality, fees);
		if(doctorList.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not found by speciality and fees");
		}
		else
			return doctorList.stream()
					.sorted((item1,item2)->item1.getDoctorName().compareTo(item2.getDoctorName()))
					.collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getByAvailability(LocalDateTime startTime) throws DoctorNotFoundException{
		doctorList=service.getByAvailability(startTime);
		if(doctorList.isEmpty()) {
			throw new DoctorNotFoundException("doctor not found by availability");
		}
		else
			return doctorList.stream()
					.sorted((item1,item2)->item1.getDoctorName().compareTo(item2.getDoctorName()))
					.collect(Collectors.toList());
	}

}