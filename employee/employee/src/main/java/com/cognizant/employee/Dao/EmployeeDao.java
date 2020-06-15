package com.cognizant.employee.Dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.employee.Employee;

public class EmployeeDao {

	private static ArrayList<Employee> employeeList;
	
	public EmployeeDao() {
		// TODO Auto-generated constructor stub
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
     	employeeList = context.getBean("employeeList", ArrayList.class);
	}
	
	public ArrayList<Employee> getAllEmployees(){
		return employeeList;
	}
}
