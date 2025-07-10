package com.taskmanager.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskmanager.dto.UserDto;
import com.taskmanager.dto.UserMapper;
import com.taskmanager.exception.ResourceNotFoundException;
import com.taskmanager.model.User;
import com.taskmanager.repository.UserRepository;
import com.taskmanager.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository ur;
	private final UserMapper um;
	private final PasswordEncoder pe;

	@Override
	public User saveUser(UserDto user) {
		user.setPassword(pe.encode(user.getPassword()));
		return ur.save(um.toUser(user));
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public UserDto deleteById(Integer id) {
		User u = findById(id);
		ur.delete(u);
		return um.toUserDto(u);
	}

	@Override
	public User findById(Integer id) {
		User u = ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found With This ID"));
		return u;
	}

}
