package com.niraj.sbt.datatest;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.niraj.sbt.entity.Student;
import com.niraj.sbt.repository.StudentRepository;

@SpringBootTest
public class StudentRepositoryDataTest {

	@Autowired
	private StudentRepository studentRepository;
	
//	@Test
	public void saveStudent() {
		Student student1 = new Student("Niraj", "Kumar", "niraj@gmail.com", "guardianName", "guardian@yahoo.com","8888888888");		
		Student student2 = new Student("Raju", "Singh", "raju@koko.com", "kokoGuardian", "kokoGuard@yahoo.com","8786526672");		
		studentRepository.save(student2);
	}

//	@Test
	public void getAllStudent() {
		  List<Student> allStudent = studentRepository.findAll();
		  System.out.println("Data from DB Size " + allStudent.size());
		  for (Student student : allStudent) {
			System.out.println("DATA From DB =>"+ student);		
		}
	}
	
	
}
