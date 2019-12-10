package com.cts.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.user.service.model.StudentDetails;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails, String> {

	StudentDetails findByUserName(String userName);
}
