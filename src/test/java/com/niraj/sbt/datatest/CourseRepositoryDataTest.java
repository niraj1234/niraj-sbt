package com.niraj.sbt.datatest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.niraj.sbt.entity.Course;
import com.niraj.sbt.entity.Guardian;
import com.niraj.sbt.entity.Student;
import com.niraj.sbt.entity.Teacher;
import com.niraj.sbt.repository.CourseRepository;

@SpringBootTest
public class CourseRepositoryDataTest {

	@Autowired
	private CourseRepository  cr;
	
//	@Test
	public void saveCourseWithTeacher() {
	
		Teacher teachPriya = new Teacher("Priya", "Sinha");
		Course coursePyThon = new Course("Python", 16);
		coursePyThon.setTeacher(teachPriya);
		
		cr.save(coursePyThon);		 
	}

	// Paging and Sorting 
	
//	@Test
	public void findAllPagination() {

//		List<Course> courseList = cr.findAll();
		
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
		List<Course> courseList = cr.findAll(secondPageWithTwoRecords).getContent();
	
		for (Course c : courseList) {
			System.out.println("|||  Course Data ||==> " + c);
		}
		
		System.out.println("Total Records " + cr.findAll(firstPageWithThreeRecords).getTotalElements());
		System.out.println("Total Pages " + cr.findAll(firstPageWithThreeRecords).getTotalPages());		
	}
	
//	@Test
	public void findCourseDataWithSorting() {
		
		Pageable sortByTitle = PageRequest.of(0, 4 , Sort.by("title"));
		Pageable sortByCreditDecending = PageRequest.of(0, 5 , Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDecending = PageRequest.of(0, 6 , Sort.by("title").descending().and(Sort.by("credit")));

		List<Course> courseList = cr.findAll(sortByTitleAndCreditDecending).getContent();		

		for (Course c : courseList) {
			System.out.println("|||  Course Data ||==> " + c);
		}

	}
	
//	@Test
	public void findCourseDataByTitleContaining() {
		
		Pageable firstPageNoneRecord = PageRequest.of(0, 9);		
		List<Course> courseList = cr.findByTitleContaining("S", firstPageNoneRecord).getContent();
		for (Course c : courseList) {
			System.out.println("|||  Course Data ||==> " + c);
		}

	}
	

//  Many to Many save data	
//	@Test
	public void saveCourseWithStudentManyToMany() {
        Course courseHibernate =  new Course("Hibernate", 22);
        Teacher techerJim = new Teacher("Jim", "Wilson");
        Guardian rameshGuardian = new Guardian("ramesh guardian", "ramsshGuard@dodo.com", "7726355344");
        Student stuB1 = new Student("Ramesh", "Lal", "ramesh@dodo.com", rameshGuardian);
        Guardian sureshGuardian = new Guardian("suresh guardian", "sureshGuard@dodo.com", "6655445654");
        Student stuB2 = new Student("Suresh", "Lamba", "suresh@dodo.com", sureshGuardian);

        courseHibernate.setTeacher(techerJim);
        courseHibernate.addStudent(stuB1);
        courseHibernate.addStudent(stuB2);
        
        cr.save(courseHibernate);
                
	}
	
	
	@Test
	public void getCourseData() {
		List<Course> courseList = cr.findAll();
		for (Course c : courseList) {
			System.out.println("|||  Course Data ManyToMany ||==> " + c);
		}
	}


}

