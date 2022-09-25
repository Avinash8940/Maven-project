package com.doctorapp.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;
import com.doctorapp.service.DoctorServiceImpl;

public class Main {

	public static void main(String[] args) {

		IDoctorService service = new DoctorServiceImpl();
		System.out.println("WELCOME TO OUR DOCTOR APP");
		boolean flag = false;
		do {
			System.out.println("1.Add Doctor\n2.update Doctor fees\n3.Get doctor by id\n4.Delete doctor by id\n5.Get All Doctors\n6.Get Doctor by speciality\n7.Get Doctor by speciality and experience\n8.Get Doctor by speciality and fees\n9.Get by Availability");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter Doctor Name");
				String name = sc.next();
				System.out.println("enter Doctor speciality");
				String speciality = sc.next();
				System.out.println("enter Doctor Fees");
				Double fees = sc.nextDouble();
				System.out.println("enter Doctor Experience");
				int experience = sc.nextInt();
				LocalDateTime startTime = LocalDateTime.of(2020, 5, 1, 11, 0, 0);
				LocalDateTime endTime = LocalDateTime.of(2022, 12, 30, 6, 0, 0);
				Doctor doctor = new Doctor(name,speciality,fees,experience, startTime, endTime);
				service.addDoctor(doctor);
				break;
			case 2:	System.out.println("enter doctor id and fees");
			    int doctorId=sc.nextInt();
			    Double doctorfees=sc.nextDouble();
				service.updateDoctor(doctorId, doctorfees);
				break;
			case 3:
				System.out.println("Enter which id do you want to enter");
				int doctorid=sc.nextInt();
				System.out.println(service.getById(doctorid));
				break;
			case 4:
				System.out.println("enter which doctor id do you want to delete");
				int docid=sc.nextInt();
				service.deleteDoctor(docid);
				break;
			case 5:	
				service.getAllDoctors().forEach(System.out::println);
				break;
			case 6:
				System.out.println("enter  Doctor speciality");
				String specialitydoctor=sc.next();
				System.out.println(service.getBySpeciality(specialitydoctor));
				break;
			case 7:	
				System.out.println("Enter Doctor speciality and Doctor experience");
				String docspeciality=sc.next();
				int docexperience=sc.nextInt();
				System.out.println(service.getBySpecialityAndExp(docspeciality,docexperience));
				break;
			case 8:
				System.out.println("Enetr Doctor speciality and Doctor fees");
				String specialitydoc=sc.next();
				Double fee=sc.nextDouble();
				System.out.println(service.getBySpecialityAndfees(specialitydoc, fee));
				break;
			case 9:
				System.out.println("Enter date");
				String date=sc.next();
				LocalDate inDate = LocalDate.parse(date);
				System.out.println("Enter time");
				String time=sc.next();
				LocalTime inTime = LocalTime.parse(time);
				LocalDateTime localDateTime=LocalDateTime.of(inDate, inTime);
				System.out.println(service.getByAvailability(localDateTime));
			
			default:
				System.out.println("what you entered is invalid");
			}
			System.out.println("do you want to continue\n1.continue\n 2.exit");
			int x = sc.nextInt();
			if (x == 1)
				flag = true;
			else
				flag = false;

		} while (flag);
	}
}
