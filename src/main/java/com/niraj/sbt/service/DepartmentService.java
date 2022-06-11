package com.niraj.sbt.service;

import java.util.List;

import com.niraj.sbt.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> fetchAllDepartment();

	Department getDepartmentById(Long departmentId);

	void deleteDepartmentById(Long departmentId);

	Department updateDepartmentById(Long departmentId, Department department);

}
