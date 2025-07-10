package com.taskmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.dto.UserDto;
import com.taskmanager.model.User;
import com.taskmanager.response.ResponseApi;
import com.taskmanager.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UserController {

	private final UserService us;
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok().body(us.findAll());
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseApi<User>> post(@Valid @RequestBody UserDto ud){
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi<User>("User Added", us.saveUser(ud), true));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseApi<UserDto>> delete(@PathVariable(name = "id") Integer id){
		return ResponseEntity.status(HttpStatus.GONE).body(new ResponseApi<UserDto>("User Deleted", us.deleteById(id), true));
	}
	
	
}
