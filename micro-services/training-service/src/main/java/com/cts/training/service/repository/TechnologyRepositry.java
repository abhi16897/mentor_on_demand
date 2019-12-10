package com.cts.training.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.service.model.Technology;

public interface TechnologyRepositry extends JpaRepository<Technology, String> {
	
	Technology findByName(String name);

}
