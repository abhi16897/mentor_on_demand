package com.cts.search.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.search.service.model.MentorDetails;
import com.cts.search.service.model.MentorSkills;

public interface MentorDetailsRepository extends JpaRepository<MentorDetails, String> {

	MentorDetails findByUserName(String userName);
	

	@Query(nativeQuery = true, value = "select * from mentor_details md join mentor_skill ms on md.md_id=ms.ms_md_id join technology t on ms.ms_t_id=t.t_id where md_username=?1 or md_username like %?1%")
	MentorDetails findByName(String username);
}
