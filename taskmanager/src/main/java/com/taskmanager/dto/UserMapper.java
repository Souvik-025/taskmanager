package com.taskmanager.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.taskmanager.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

//	@Mapping(source = "uName", target = "uName")
	User toUser(UserDto u);
	
//	@Mapping(source = "uName", target = "uName")
	UserDto toUserDto(User u);
}
