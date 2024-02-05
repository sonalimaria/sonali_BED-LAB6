package com.gl.collegefest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.collegefest.dto.SignUpDto;
import com.gl.collegefest.entity.User;
import com.gl.collegefest.service.UserService;

@Controller
public class UserRegistrationController {
	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String showHome(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		System.out.println("Reg");
		return "registration";
	}

	@PostMapping("/regSuccess")
	public String regUser(@ModelAttribute SignUpDto signUpDto) {
		userService.save(signUpDto);
		return "redirect:/registration?success";
	}

}
