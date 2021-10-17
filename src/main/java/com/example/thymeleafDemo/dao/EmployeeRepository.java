package com.example.thymeleafDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.thymeleafDemo.entity.*;


// Jpa repository is an inbuilt interface that has templates for CRUD operations.. we just have to plugin the Entity and primary key values
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//add a method to sort by last name
	//spring data jpa will parse the method name - looks for a specific format and pattern
	// it creates appropriate Query (behind the scenes)
	public List<Employee> findAllByOrderByLastNameAsc();
	
	//here "findAllBy" is part of the pattern, OrderByLastNameAsc - will parse this for Order by clause for the given Query statement

	//simply means "from Employee order by last name asc" will happen in query
	
	
	//similar examples
	
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	
	/*
	 * 
	 *  List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

  // Enables the distinct flag for the query
  List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
  List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

  // Enabling ignoring case for an individual property
  List<Person> findByLastnameIgnoreCase(String lastname);
  // Enabling ignoring case for all suitable properties
  List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

  // Enabling static ORDER BY for a query
  List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
  List<Person> findByLastnameOrderByFirstnameDesc(String lastname);
	 */
}
