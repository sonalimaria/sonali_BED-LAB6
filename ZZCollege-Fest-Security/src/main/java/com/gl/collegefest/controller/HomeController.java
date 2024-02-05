package com.gl.collegefest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/access-denied")
	public String accesDenied() {
		return "access-denied";
	}

}
