package com.gl.collegefest.service;

import java.util.List;

import com.gl.collegefest.entity.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(int id);

	public void save(Student theStudent);

	public void deleteByid(int id);

}
