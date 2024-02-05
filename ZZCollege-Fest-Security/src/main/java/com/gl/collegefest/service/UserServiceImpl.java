package com.gl.collegefest.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.collegefest.dto.SignUpDto;
import com.gl.collegefest.entity.Role;
import com.gl.collegefest.entity.User;
import com.gl.collegefest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {

		User user = userRepository.findByUsernameOrEmail(userNameOrEmail, userNameOrEmail).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username or email: " + userNameOrEmail));

		Set<GrantedAuthority> authorites = new HashSet<>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			authorites.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorites);
	}

	@Override
	public User save(SignUpDto signUpDto) {
		Role roles = new Role();
		roles.setName("ROLE_ADMIN");
		User user = new User(signUpDto.getName(), signUpDto.getUsername(), signUpDto.getEmail(),
				passwordEncoder.encode(signUpDto.getPassword()));
		user.setRoles(Collections.singleton(roles));
		return userRepository.save(user);
	}

}
