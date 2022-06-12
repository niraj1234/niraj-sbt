package com.niraj.sbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niraj.sbt.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
