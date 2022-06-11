package com.niraj.sbt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niraj.sbt.entity.Department;
import com.niraj.sbt.service.DepartmentService;



@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		Department dept = departmentService.saveDepartment(department);
		return dept;
	}
	
}
