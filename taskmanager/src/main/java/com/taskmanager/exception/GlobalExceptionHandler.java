package com.taskmanager.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.taskmanager.response.ResponseApi;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity<?> resourceError(ResourceNotFoundException e) {
		return ResponseEntity.badRequest().body(ResponseApi.builder().message("error").data(e.getMessage()).status(false).build());
	}
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> resourceError(MethodArgumentNotValidException e) {
		Map<String, String> err = new HashMap<String, String>();
		e.getBindingResult().getFieldErrors().forEach(error -> err.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.badRequest().body(err);
	}
}
