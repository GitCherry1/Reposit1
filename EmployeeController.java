package com.example.domain.controller;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.dao.EmployeeMongoRepository;

import com.example.domain.model.Employee;

//import com.mongospring.model.Employee;
//import com.mongospring.dao.EmployeeRepository;

//@RestController
@Controller
public class EmployeeController {

	
    @Autowired
    EmployeeMongoRepository employeeRepository; 
   // @InjectMocks
    //CarMongoRepository carRepository1;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("empList", employeeRepository.findAll());
        return "Home";
    }
    @RequestMapping(value = "/addEmp", method = RequestMethod.POST)
    public String addEmp(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:home";
    }
  //to display employee based on id
    @RequestMapping("/dispEmp")
    public String home1(Model model) {
        
    	model.addAttribute("empList", employeeRepository.findOne("104"));
        return "home1";
    }
  }
