package com.niraj.sbt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Course {

	@Id
	@SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "course_sequence")
	private Long courseId;
    private String title;
    private Integer credit;
	
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id" , referencedColumnName = "teacherId")
    private Teacher teacher;
    
    public Course(String title, Integer credit, CourseMaterial courseMaterial, Teacher teacher) {
		super();
		this.title = title;
		this.credit = credit;
		this.courseMaterial = courseMaterial;
		this.teacher = teacher;
	}

	public CourseMaterial getCourseMaterial() {
		return courseMaterial;
	}

	public void setCourseMaterial(CourseMaterial courseMaterial) {
		this.courseMaterial = courseMaterial;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course() {
		super();
	}

	public Course(String title, Integer credit) {
		super();
		this.title = title;
		this.credit = credit;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", credit=" + credit + ", courseMaterial="
				+ courseMaterial + "]";
	}
    
}
