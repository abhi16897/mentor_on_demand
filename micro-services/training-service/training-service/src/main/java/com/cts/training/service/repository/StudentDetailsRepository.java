package com.cts.training.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.service.model.StudentDetails;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails, String> {

	StudentDetails findByUserName(String userName);
}
