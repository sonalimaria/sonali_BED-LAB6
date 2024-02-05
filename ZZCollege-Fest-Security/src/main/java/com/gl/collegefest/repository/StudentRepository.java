package com.gl.collegefest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.collegefest.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
