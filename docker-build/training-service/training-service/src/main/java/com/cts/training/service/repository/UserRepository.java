package com.cts.training.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.service.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByName(String name);
	
	User findByEmail(String email);
}
