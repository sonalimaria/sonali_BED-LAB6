package com.gl.collegefest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.collegefest.entity.Student;
import com.gl.collegefest.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		Optional<Student> results = studentRepository.findById(id);
		Student theStudent = null;
		if (results.isPresent())
			theStudent = results.get();

		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		studentRepository.save(theStudent);

	}

	@Override
	public void deleteByid(int id) {
		studentRepository.deleteById(id);

	}

}
