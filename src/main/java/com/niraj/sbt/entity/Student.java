package com.niraj.sbt.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table( name = "tbl_student", uniqueConstraints = 
	@UniqueConstraint(columnNames = "email_address", name = "email_unique"))
@Entity
public class Student {

	@Id
	@SequenceGenerator( name = "stu_sequence_generator", sequenceName = "stu_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stu_sequence_generator")
	private Long studentId;
	private String firstName;
	private String lastName;

	@Column(name = "email_address" , nullable = false)
	private String emailId;
	
	@Embedded
	private Guardian guardian;
			
	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String emailId, Guardian guardian) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.guardian = guardian;
	}


	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", "
				+ "firstName=" + firstName + ", lastName=" + lastName + ", "
				+ "emailId="+ emailId + ", guardian=" + guardian + "]";
	}

}
