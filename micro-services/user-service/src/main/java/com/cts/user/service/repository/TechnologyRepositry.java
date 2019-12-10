package com.cts.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.user.service.model.Technology;

public interface TechnologyRepositry extends JpaRepository<Technology, String> {
	
	Technology findByName(String name);

}
