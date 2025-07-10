package com.taskmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Override
	Optional<User> findById(Integer id);

	@Override
	List<User> findAll();

	
}
