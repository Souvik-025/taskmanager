package com.taskmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.dto.TaskDto;
import com.taskmanager.response.ResponseApi;
import com.taskmanager.service.TaskService;
import com.taskmanager.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
	
	private final UserService us;
	private final TaskService ts;

	@PostMapping("/create")
	public ResponseEntity<ResponseApi<TaskDto>> createTask(@Valid @RequestBody TaskDto td) {
		ts.createTask(td);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi<TaskDto>("Task Created", td, true));
	}
	
	
}
