package com.example.thymeleafDemo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleafDemo.entity.*;
import com.example.thymeleafDemo.dao.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//delegate all calls to the DAO
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
	//	return employeeRepository.findAll();
		
		return employeeRepository.findAllByOrderByLastNameAsc();
		//return employee list in descending order
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		
		if(result.isPresent())
			employee = result.get();
		else
			throw new RuntimeException("Did not find employee with ID: "+id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
