package com.cognizant.employee.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employee.Employee;
import com.cognizant.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees(){
		EmployeeService es=new EmployeeService();
		return es.getAllEmployees();
	}
}
