/**
 * 
 ************************************************
 POC: MongoDB with Springboot Rest Controller
 
 Author: @ Nisum
 
 *************************************************
 * 
 *
 */
package com.example.domain.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.domain.model.EmployeeRepository;
import com.example.domain.dao.Employee;
import com.example.domain.model.EmployeeRepository;

@RestController
public class EmployeeController {
	
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	
	// To Display the details of all employees 
	@RequestMapping("/getEmpDetails")
	
	 public List empDetails() {
	        List<Employee> employees = new ArrayList<Employee>();
	        employees.add(new Employee("11","Rajesh","K","Bangalore","Engineer",25,20000));
	        employees.add(new Employee("12","Lokesh","K","Hyderabad","Manager",30,30000));
	        employees.add(new Employee("13","Ganesh","D","Noida","CTO",20,200000));
	        employees.add(new Employee("14","Satya","Das","Chennai","Engineer",33,9000));
	        employeeRepository.save(employees);
	        System.out.println("No of employess added "+employees.size());
	        return employees;
	    }
	
	// To display the details of the employee based on the firstName  
	@RequestMapping("/getEmployeeName")
	public Employee empName() { 
		
 	     Employee emp1=employeeRepository.findByFirstName("Lokesh");
		
		return emp1;
	}
	// To Display one Employee based on his lastName
	
		@RequestMapping("/getOneEmpDetails")
		public Employee empName2() {
			
			
			Employee emp1=employeeRepository.findByLastName("Kumar");
			
			return emp1;
		}
		
	// To display a given employee  name after Updating the record
	//UPDATE	
		
	@RequestMapping("/getUpdateEmployee")
	public Employee updateEmpName() {
		
		Employee emp1=employeeRepository.findByFirstName("Ganesh");
		emp1.setFirstName("Vijay");
		emp1.setLastName("Kumar");
		employeeRepository.save(emp1);
		return emp1; 
	}
	
	           
	// To Display the number of documents(Records) in the Employee table(collection))
	
	@RequestMapping("/getEmpCount")
	public long  empCount1() {
		
		long empCount=employeeRepository.count();
		
		return empCount;
	}
	
	@RequestMapping("/getEmpDetailsById")
	public Employee getEmpLocation() {
	
		
		Employee  emploc=employeeRepository.findByLocation("Bangalore");
		return  emploc;
	}
	
	//Display the employee details based on  his salary
	
	@RequestMapping("/getEmpDetailsBySalary")
	public Employee getEmpSalary() {
	
		
		Employee   empsal=employeeRepository.findBySalary(200000);
		return  empsal;
	}
	
	//To display fallback method if there are no matching mappings
	
	@RequestMapping("*")

	public String fallbackMethod(){
		return "fallback method";
	}
	
	//displaying Employee details based on his firstName
	
	@RequestMapping(value="/getEmpDetails_Name/{fname}")
	
		public Employee EmpDetails_Name(@PathVariable String fname) {
		
		return employeeRepository.findByFirstName(fname);
		}
	
	//displaying Employee details based on his salary
	
	@RequestMapping(value="/getEmpDetails_Salary/{salary}")
		
	       public Employee EmpDetails_Salary(@PathVariable int  salary) {
	
	         return employeeRepository.findBySalary(salary);
		}
	
   
	//To Display the First name of the employee by taking his location name
	
 	@RequestMapping(value="/displayName/{id}")
	
 	public String getLocation(@PathVariable String  id) {
	
 		String empname=employeeRepository.findByLocation(id).getFirstName();
 						//employee.getFirstName();
 		//Employee employee=employeeRepository.findByLocation(id);
 		
	//return "The location of "+empname+ " is "+id;
 		return empname;
 		//return employee.getFirstName();  
	}
 	
 	
 	//To Delete a given employee based on his id
 	//DELETE   operation
 	
     @RequestMapping(value="/deleteEmployee_Id/{id}")
	
 	 public void  deleteEmployee(@PathVariable String  id) {
	
	
			employeeRepository.delete(id);
	}
     
     //To search for a given employee based on the employee id
     
     @RequestMapping(value="/searchEmployee_Id/{id}")
     
     public boolean existEmployee(@PathVariable String id) {
    	 
    	 boolean bb=employeeRepository.exists(id);
    	  
    	 if(bb)
    	 {
    	 System.out.println("The given employee with ID:  " +id+" is available in our Database");
    	 }
    	 else {
    		 System.out.println("The given employee with ID:  "+id+" is NOT availablein our database ");
    	 }
    		 
    	 return bb;
     }
     
     
	
}
