package com.example.domain.model;

//import com.example.domain.controller.EmployeeController;
import com.example.domain.dao.Employee;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee, String>{

   
    public Employee findByFirstName(String firstName);
    public Employee findByLastName(String lastName);
    public Employee findByLocation(String id);
    public Employee findBySalary(int  salary);
 
  }