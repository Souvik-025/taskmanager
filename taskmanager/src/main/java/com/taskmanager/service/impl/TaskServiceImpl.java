package com.taskmanager.service.impl;

import org.springframework.stereotype.Service;

import com.taskmanager.dto.TaskDto;
import com.taskmanager.dto.TaskMapper;
import com.taskmanager.exception.ResourceNotFoundException;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;
import com.taskmanager.repository.TaskRepository;
import com.taskmanager.repository.UserRepository;
import com.taskmanager.service.TaskService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
	
	private final UserRepository ur;
	private final TaskRepository tr;
//	private final TaskMapper tm;

	@Override
	public Task createTask(TaskDto t) {
		User u = ur.findById(t.getUserId())
					.orElseThrow(() -> new ResourceNotFoundException("User With Passed Id Is Not Present"));
		Task task = Task.builder()
					.description(t.getDescription())
					.message(t.getMessage())
					.createdBy(u).build();
		return tr.save(task);
	}

	@Override
	public void deleteTask(Long id) {
		tr.delete(tr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task Not Found With This ID")));	
	}

}
