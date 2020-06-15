package com.cognizant.employee.Dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.employee.Department;

public class DepartmentDao {

	private static ArrayList<Department> departmentList;

	public DepartmentDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
     	departmentList = context.getBean("departmentList", ArrayList.class);
	}
	
	public ArrayList<Department> getAllDepartments(){
		return departmentList;
	}
}
