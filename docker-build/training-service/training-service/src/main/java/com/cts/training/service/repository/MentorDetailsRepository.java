package com.cts.training.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.service.model.MentorDetails;

public interface MentorDetailsRepository extends JpaRepository<MentorDetails, String> {

	MentorDetails findByUserName(String userName);
}
