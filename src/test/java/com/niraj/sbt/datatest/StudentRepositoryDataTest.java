package com.niraj.sbt.datatest;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.niraj.sbt.entity.Guardian;
import com.niraj.sbt.entity.Student;
import com.niraj.sbt.repository.StudentRepository;

@SpringBootTest
public class StudentRepositoryDataTest {

	@Autowired
	private StudentRepository studentRepository;
	
//	@Test
	public void saveStudent() {
//		Student student1 = new Student("Niraj", "Kumar", "niraj@gmail.com", "guardianName", "guardian@yahoo.com","8888888888");		
//		Student student2 = new Student("Raju", "Singh", "raju@koko.com", "kokoGuardian", "kokoGuard@yahoo.com","8786526672");		

		Guardian guardianA = new Guardian("shwetaGuardian", "shwetaGuard@soso.com", "7663545554");
		Student studentA = new Student("Shweta", "Rastogi", "shweta@soso.com", guardianA);
		studentRepository.save(studentA);
	}

	
//	@Test
	public void getAllStudent() {
		  List<Student> allStudent = studentRepository.findAll();
		  System.out.println("Data from DB Size " + allStudent.size());
		  for (Student student : allStudent) {
			System.out.println("DATA From DB =>"+ student);		
		}
	}
	
//	@Test
	public void getStudentByEmailAddressUsingJPQL() {
		Student studentData = studentRepository.getStudentByEmailAddress("shweta@soso.com");
		System.out.println(studentData);
	}
	
//	@Test
	public void getStudentByEmailAddressUsingNative() {
		Student studentData = studentRepository.getStudentByEmailAddressNative("shweta@soso.com");
		System.out.println(studentData);
	}
	
//	@Test
	public void getStudentByEmailAddressUsingNativeNamedParameter() {
		Student studentData = studentRepository.getStudentByEmailAddressNativeNamedParameter("shweta@soso.com");
		System.out.println(studentData);
	}

//	@Test
	public void updateStudentFirstNameByEmailIdNativeTXN() {
		int responseFromDB = studentRepository.updateStudentFirstNameByEmailId("Shweta Rastogi", "shweta@soso.com");
		System.out.println("Response from DB ==> " + responseFromDB);
	}
	
	
}
