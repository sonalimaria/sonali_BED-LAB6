package com.gl.collegefest.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gl.collegefest.dto.SignUpDto;
import com.gl.collegefest.entity.User;

public interface UserService extends UserDetailsService {
	public User save(SignUpDto signUpDto);
}
