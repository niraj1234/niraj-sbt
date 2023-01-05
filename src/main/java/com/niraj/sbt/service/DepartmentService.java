package com.niraj.sbt.service;

import java.util.List;

import com.niraj.sbt.entity.Department;
import com.niraj.sbt.error.DepartmentNotFoundException;
import com.niraj.sbt.error.InvalidRequestParameterException;

public interface DepartmentService {
	Department saveDepartment(Department department);
	List<Department> fetchAllDepartment();
	Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;
	void deleteDepartmentById(Long departmentId);
	Department updateDepartmentById(Long departmentId, Department department);
	List<Department> getDepartmentByName(String name) throws InvalidRequestParameterException;
	List<Department> getDepartmentByCode(String code);
	List<Department> getDepartmentByAddress(String addr);
}
