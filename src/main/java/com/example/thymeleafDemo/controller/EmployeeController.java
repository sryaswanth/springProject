package com.example.thymeleafDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.thymeleafDemo.entity.*;
import com.example.thymeleafDemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	//constructor Injection
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployee(Model theModel){
		
		//get employess from DB
		List<Employee> theEmployees = employeeService.findAll();
		
		//add to the Spring model
		theModel.addAttribute("employees", theEmployees);
		return "employees/list-employees"; // template name in src/main/resources
		
	}
	
	
	@GetMapping("/showFormforAddEmployees")
	public String showFromForAddEmployees(Model theModel){
		
		//create Model attribute  to bind form data
		Employee theEmployee = new Employee();
		
		// thymeleaf will access this data for binding form data
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/addEmployeeForm";
		
	}
	
	
	@GetMapping("/showFormForUpdateEmployee")
	public String updateFormForEmployee(@RequestParam("employeeId") int theId, Model theModel){
		
		//get the employee from the DB
		Employee theEmployee = employeeService.findById(theId);
		
		//set employee as Model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		//send over to our form
		
		return "employees/addEmployeeForm";	
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int theId){
		
		employeeService.deleteById(theId);
		
		return "redirect:/employees/list"; // if redirect is added then give the controller mapping path
		
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
		// @ModelAttribute("employee") -> form data passed in 
		
		//save the employee
		employeeService.save(theEmployee);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list"; // redirtect to this request mapping
		// if redirect is added then give the controller mapping path
	}

}
