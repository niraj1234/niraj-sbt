package com.niraj.sbt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niraj.sbt.entity.Department;
import com.niraj.sbt.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/department")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/department")
	public List<Department> getfetchDepartments(){
		return departmentService.fetchAllDepartment();		
	}

	@GetMapping("/department/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.getDepartmentById(departmentId);
	}

	@DeleteMapping("/department/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
        return "Department deleted with id "+departmentId ;		
	}
	
	@PutMapping("/department/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId, 
										   @RequestBody Department department) {
		return departmentService.updateDepartmentById(departmentId , department);
	}
	
	
	@GetMapping("/department/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String name) {
		return departmentService.getDepartmentByName(name);
	}

	
	@GetMapping("/department/code/{code}")
	public List<Department> getDepartmentByCode(@PathVariable("code") String code) {
		return departmentService.getDepartmentByCode(code);
	}
	
	@GetMapping("/department/address/{addr}")
	public List<Department> getDepartmentByAddress(@PathVariable("addr") String addr) {
		return departmentService.getDepartmentByAddress(addr);
	}
	

}
