package com.taskmanager.dto;

import com.taskmanager.model.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

	@NotEmpty(message = "Name Should Not Be Empty")
	@Pattern(regexp = "^[A-Za-z]+( [A-Za-z]+)*$", message = "Provide A Proper Name")
	private String name;

	@Email(message = "User Enter A Valid Email")
	private String email;

	private Role role;
	
	private String password;
}
