/**
 * 
 **********************************
 TDD for EmployeeController class
 **********************************
 *
 */
package com.example.domain;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.awt.List;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.domain.controller.EmployeeController;
import com.example.domain.dao.Employee;
import com.example.domain.model.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;
	
	
	@Mock
	EmployeeRepository empRepository;
	@Mock
	Employee emp;
	
	//To check the total number of records
	
	@Test
	public void empCountTest() {
		
		long expectedValue=4; 
		
		when(empRepository.count()).thenReturn(4l);
		
		long actualValue =employeeController.empCount1();
		
		assertEquals(expectedValue, actualValue); 
	}
	
	// to check whether an employee id exists or not
	
	@Test
	public void existEmpTest() {
		
		boolean exist=true;
		 
		when(empRepository.exists("12")).thenReturn(true);
		
				
		
		boolean actualValue =employeeController.existEmployee("12");
		
		assertEquals(exist, actualValue); 
	}
	
	// Checking employee based on his firstName
	
	@Test
	public void empNameTest() {
		
		
		Employee emp=new Employee();
		
		emp.setFirstName("Lokesh");
		
		when(empRepository.findByFirstName("Lokesh")).thenReturn(emp)	;	
		Employee actemp=employeeController.empName();
		//comparing employee objects
		//assertEquals(emp, actemp);
		System.out.println("Employee name is "+emp.getFirstName());
		//comparing employee names 
		assertEquals(emp.getFirstName(), actemp.getFirstName()); 
	}
	
	//Checking employee based on his lastName
	
	@Test
	public void empName2Test() {
		
		
		Employee emp1=empRepository.findByLastName("Kk");
		when(empRepository.findByLastName("KK")).thenReturn(emp1)	;	
		Employee actemp=employeeController.empName2();
        assertEquals(emp1,actemp);		

	}
	
	// Checking employee based on his salary
	
	@Test
	
		public void  getEmpSalaryTest() {
		
			
			Employee   emp1=empRepository.findBySalary(200000);
			when(empRepository.findBySalary(20000)).thenReturn(emp1)	;	
			Employee actemp=employeeController.getEmpSalary();
		  	assertEquals(emp1,actemp);
		
		}
	
	//Checking location of the employee
	
	@Test
	public void locationTest() {
		String expname="Rajesh";
		Employee  employee=new Employee();
		employee.setId("12");
		employee.setFirstName("Rajesh");
		employee.setLocation("Bangalore");
		when(empRepository.findByLocation("Banglore")).thenReturn(employee);
		//when(emp.getFirstName()).thenReturn("Rajesh");
		
		String empname=employeeController.getLocation("Banglore");
		
		//String empname=( new EmployeeController()).getLocation("Bangalore");
		assertEquals(expname,empname);
		
		System.out.println("actual"+empname);
		assertEquals(expname,empname);
		 
		
	 }
	
  }
