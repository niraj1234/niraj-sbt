package com.niraj.sbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niraj.sbt.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
}
