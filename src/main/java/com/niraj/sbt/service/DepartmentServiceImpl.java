package com.niraj.sbt.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niraj.sbt.entity.Department;
import com.niraj.sbt.error.DepartmentNotFoundException;
import com.niraj.sbt.error.InvalidRequestParameterException;
import com.niraj.sbt.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	
	@Override
	public List<Department> fetchAllDepartment() {
		return departmentRepository.findAll();
	}

	
	@Override
	public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
//		return departmentRepository.findById(departmentId).get();
		Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
		if(!departmentOptional.isPresent()) { throw new DepartmentNotFoundException("Department not found with id "+departmentId);}
		return departmentOptional.get();
	}

	
	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	
	@Override
	public Department updateDepartmentById(Long departmentId, Department department) {
		Department deptInDB = departmentRepository.findById(departmentId).get();
		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			deptInDB.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			deptInDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			deptInDB.setDepartmentCode(department.getDepartmentCode());
		}		
		return departmentRepository.save(deptInDB);
	}


	@Override
	public List<Department> getDepartmentByName(String name) throws InvalidRequestParameterException {
		boolean deparmentNameValidFlag = false;
		if(name.equalsIgnoreCase("Electrical") || name.equalsIgnoreCase("Mechanical") || name.equalsIgnoreCase("Civil")
				|| name.equalsIgnoreCase("Computer")) {
			deparmentNameValidFlag = true;
		}
		
		if (!deparmentNameValidFlag) {
            String messageForDeparment = "Engineering Department with name [ "+name+" ] is not available !" ;
			throw new InvalidRequestParameterException(messageForDeparment);
		}
		
		List<Department> dept = departmentRepository.findByDepartmentName(name);
		return dept;
	}


	@Override
	public List<Department> getDepartmentByCode(String code) {
		List<Department> dept = departmentRepository.getDepartmentByCode(code);
		return dept;
	}


	@Override
	public List<Department> getDepartmentByAddress(String addr) {
		List<Department> dept = departmentRepository.getDepartmentByAddress(addr);
		return dept;
	}
	
	
}
