package com.cognizant.employee.service;

import java.beans.Transient;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.employee.Employee;
import com.cognizant.employee.Dao.EmployeeDao;

@Service
public class EmployeeService {

	public ArrayList<Employee> getAllEmployees(){
		EmployeeDao ed=new EmployeeDao();
		return ed.getAllEmployees();
	}
	
}
