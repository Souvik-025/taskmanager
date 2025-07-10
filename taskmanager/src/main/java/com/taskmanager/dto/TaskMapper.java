package com.taskmanager.dto;

import org.mapstruct.Mapper;

import com.taskmanager.model.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

	Task toEntity(TaskDto td);
	
	TaskDto toDto(Task t);
}
