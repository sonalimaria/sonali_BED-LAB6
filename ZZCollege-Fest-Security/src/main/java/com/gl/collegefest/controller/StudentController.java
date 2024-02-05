package com.gl.collegefest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.collegefest.entity.Student;
import com.gl.collegefest.service.StudentService;

@Controller
@RequestMapping("students")
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/list")
	public String listStudent(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "student/student-list";
	}

	@GetMapping("/showStudentFormForAdd")
	public String showStudentForm(Model model) {
		Student student = new Student();

		model.addAttribute("student", student);
		return "student/student-form";
	}
	@GetMapping("/studentFormForEdit/{id}")
	public String studentFormForEdit(Model model, @PathVariable int id) {
		Student student = studentService.findById(id);
		model.addAttribute("student", student);
		return "student/student-form";
	}
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		studentService.deleteByid(id);
		return "redirect:/students/list";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(Model model, @ModelAttribute("student") Student student) {
		studentService.save(student);
		return "redirect:/students/list";
	}

}
