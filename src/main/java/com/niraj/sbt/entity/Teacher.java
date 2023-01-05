package com.niraj.sbt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Teacher {

	
	@Id
	@SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "teacher_sequence")
	private Long teacherId;
	private String firstName;
	private String lastName;
	

//  This is OneToMany | Same thing will be done as ManyToOne to Course | 
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
//	List<Course> courses;


	public Teacher() {
		super();
	}

	public Teacher(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public Long getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
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



	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
//  When @OneToMany will be used with Course

//	import javax.persistence.FetchType;
//	import javax.persistence.CascadeType;
//	import javax.persistence.JoinColumn;
//	import javax.persistence.OneToMany;
//	import java.util.List;
	
	
//	public Teacher(String firstName, String lastName, List<Course> courses) {
//	super();
//	this.firstName = firstName;
//	this.lastName = lastName;
//	this.courses = courses;
//  }
	
//	public List<Course> getCourses() {return courses;}
//	public void setCourses(List<Course> courses) {this.courses = courses;}
	
}
