package com.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {

	@NotBlank(message = "Message Should Not Be Blank")
	private String message;
	
	@NotBlank(message = "Description Should Not Be Blank")
	private String description;
	
	private Integer userId;

}
