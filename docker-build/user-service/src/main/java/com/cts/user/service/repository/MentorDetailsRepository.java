package com.cts.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.user.service.model.MentorDetails;

public interface MentorDetailsRepository extends JpaRepository<MentorDetails, String> {

	MentorDetails findByUserName(String userName);
}
