package com.gl.collegefest.dto;

import lombok.Data;

@Data
public class LoginDto {
	private String usernameOrEmail;
	private String password;
}
