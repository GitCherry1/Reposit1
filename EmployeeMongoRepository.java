package com.example.domain.dao;


import com.example.domain.model.Employee;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeMongoRepository extends MongoRepository<Employee, String>{

   
    public Employee findByFirstName(String firstName);
    public Employee findByLastName(String lastName);
    public Employee findByLocation(String id);
    public Employee findBySalary(int  salary);
	//public List<Car> findByModel(String model);
	//public List<Car> findByMake(String make);
 
  }