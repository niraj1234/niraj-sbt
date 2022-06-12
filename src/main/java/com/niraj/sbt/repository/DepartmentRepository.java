package com.niraj.sbt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.niraj.sbt.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public List<Department>  findByDepartmentName(String name);
	
	@Query(nativeQuery = true , value = "select * from department where department_code = ?1 " )
	public List<Department> getDepartmentByCode(String code);

	@Query(nativeQuery = true , value = "select * from department where department_address = :addr " )
	public List<Department> getDepartmentByAddress(@Param("addr") String addr);

}
