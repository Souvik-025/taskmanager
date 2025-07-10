package com.taskmanager.service;

import com.taskmanager.dto.TaskDto;
import com.taskmanager.model.Task;


public interface TaskService {

	Task createTask(TaskDto t);
	
	void deleteTask(Long id);
}
