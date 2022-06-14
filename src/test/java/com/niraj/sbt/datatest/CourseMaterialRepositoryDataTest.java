package com.niraj.sbt.datatest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.niraj.sbt.entity.Course;
import com.niraj.sbt.entity.CourseMaterial;
import com.niraj.sbt.repository.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepositoryDataTest {

	@Autowired
	private CourseMaterialRepository repository;

	
//	@Test
	public void saveCourseMaterial() {
		Course course = new Course("Scala", 3);
		CourseMaterial courseMaterial = new CourseMaterial("www.scala.io", course);
		repository.save(courseMaterial);
	}
	
//	@Test
	public void getAllCourseMaterial() {
		List<CourseMaterial> courseMaterialList = repository.findAll();
		for(CourseMaterial cm : courseMaterialList) {
			System.out.println(cm);
		}		
	}
	
	
}


