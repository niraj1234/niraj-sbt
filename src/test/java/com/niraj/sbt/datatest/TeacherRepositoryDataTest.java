package com.niraj.sbt.datatest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.niraj.sbt.entity.Course;
import com.niraj.sbt.entity.Teacher;
import com.niraj.sbt.repository.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryDataTest {

	
	@Autowired
	private TeacherRepository teacherRepository;
	
//	@Test
	public void saveTeacher() {
		Course coursePHP = new Course("PHP", 3);
		Course courseLaravel = new Course("Laravel", 5);
		Course courseCodeIgniter = new Course("CodeIgniter", 2);
		
		List<Course> courseListPHP  =  new ArrayList<Course>();
		courseListPHP.add(coursePHP);
		courseListPHP.add(courseLaravel);
		courseListPHP.add(courseCodeIgniter);

//		Teacher t1 = new Teacher("Rajeev", "Thakur", courseListPHP);		
//		teacherRepository.save(t1);
		
	}
	
}
