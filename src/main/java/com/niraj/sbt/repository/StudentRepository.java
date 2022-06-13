package com.niraj.sbt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.niraj.sbt.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByFirstName(String firstName);
	List<Student> findByGuardianName(String guardinName);

	//JPQL
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);

	//Native SQL Query
	@Query(value = "select * from tbl_student where email_address = ?1" , nativeQuery = true)
	Student getStudentByEmailAddressNative(String emailId);

	//Native Named Parameter
	@Query(value = "select * from tbl_student where email_address = :emailId" , nativeQuery = true)
	Student getStudentByEmailAddressNativeNamedParameter(@Param("emailId") String  emailId);


	//Native Query Update
	@Modifying
	@Transactional
	@Query( 
			value = "update tbl_student set first_name = ?1 where email_address = ?2" , 
			nativeQuery = true
	)
	int updateStudentFirstNameByEmailId(String  firstName, String  emailId);


}
