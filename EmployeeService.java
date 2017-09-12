package com.example.domain.controller;

import org.springframework.stereotype.Service;

import com.example.domain.dao.EmployeeMongoRepository;


@Service
public class EmployeeService {
	EmployeeMongoRepository employeeRepository;
	
	public int calculateSalary(int noOfDays) {
		int salary=(noOfDays+1)*1000;
		return salary;
	}
	public long noOfRecords() {
		
		long  noOfRecords=employeeRepository.count();
		
		return noOfRecords;
		
	}
	

}
