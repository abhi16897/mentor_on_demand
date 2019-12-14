package com.cts.training.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.training.service.model.StudentDetails;
import com.cts.training.service.model.Training;

public interface TrainingRepository extends JpaRepository<Training, String> {

	@Query(nativeQuery = true, value = "select * from training t join mentor_details md on t.tr_md_id=md.md_id where md.md_username=?1 and t.tr_status=?2")
	List<Training> findByMentorDetails(String mentorName, String status);
	
	@Query(nativeQuery = true, value = "select * from training t join student_details sd on t.tr_sd_id=sd.sd_id where sd.sd_username=?1 and t.tr_status=?2")
	List<Training> findByStudentDetails(String studentName, String status);
	
	Training findById(int id);
	
	List<Training> findByStudentDetails(StudentDetails studentDetails);
	
	@Query(nativeQuery = true, value = "select * from training t join mentor_details md on t.tr_md_id=md.md_id where md.md_username=?1 and t.tr_status=?2")
	Training findByMentorDetail(String mentorName, String status);
}
