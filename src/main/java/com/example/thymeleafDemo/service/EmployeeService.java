package com.example.thymeleafDemo.service;

import java.util.List;

import com.example.thymeleafDemo.entity.*;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
	
}
