package com.example.thymeleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	//create a mapping for "hello"
	
	@GetMapping("/hello")
	public String sayHello(Model theModel){
		theModel.addAttribute("theDate", new java.util.Date());
		return "helloWorld"; //we have thymeleaf dependency on pom file.. so Spring boot will auto configure to use thymeleaf
		//searches on src/main/resources/templates/helloworld.html
		
	}

	
}
