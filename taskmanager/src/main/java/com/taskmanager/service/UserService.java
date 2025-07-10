package com.taskmanager.service;

import java.util.List;

import com.taskmanager.dto.UserDto;
import com.taskmanager.model.User;

public interface UserService {

	User saveUser(UserDto user);
	
	List<User> findAll();
	
	UserDto deleteById(Integer id);
	
	User findById(Integer id);
}
