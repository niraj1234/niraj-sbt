package com.niraj.sbt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class CourseMaterial {

	@Id
	@SequenceGenerator(name ="course_material_sequence" , sequenceName = "course_material_sequence" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "course_material_sequence")
	private Long courseMaterialId;
    private String url;

    
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER , optional = false)
    @JoinColumn(name = "course_id_fk" , referencedColumnName = "courseId")
    private Course course;
    

    public CourseMaterial() {
		super();
	}

	public CourseMaterial(String url) {
		super();
		this.url = url;
	}

	public CourseMaterial(String url, Course course) {
		super();
		this.url = url;
		this.course = course;
	}

	public Long getCourseMaterialId() {
		return courseMaterialId;
	}

	public void setCourseMaterialId(Long courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CourseMaterial [courseMaterialId=" + courseMaterialId + ", url=" + url + ", course=" + course + "]";
	}


    
}
