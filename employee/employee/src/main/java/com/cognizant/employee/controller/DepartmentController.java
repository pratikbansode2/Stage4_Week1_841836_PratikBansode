package com.cognizant.employee.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employee.Department;
import com.cognizant.employee.service.DepartmentService;

@RestController
public class DepartmentController {

	@GetMapping("/departments")
	public ArrayList<Department> getAllDepartments(){
		DepartmentService ds=new DepartmentService();
		return ds.getAllDepartments();
	}
}
