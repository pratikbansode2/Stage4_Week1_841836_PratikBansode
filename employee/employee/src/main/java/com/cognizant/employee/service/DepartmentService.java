package com.cognizant.employee.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.employee.Department;
import com.cognizant.employee.Dao.DepartmentDao;

@Service
public class DepartmentService {

	public ArrayList<Department> getAllDepartments(){
		DepartmentDao dd=new DepartmentDao();
		return dd.getAllDepartments();
	}
}
