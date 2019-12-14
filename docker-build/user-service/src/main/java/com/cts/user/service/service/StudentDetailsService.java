package com.cts.user.service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.user.service.UserServiceApplication;
import com.cts.user.service.model.MentorDetails;
import com.cts.user.service.model.Training;
import com.cts.user.service.repository.MentorDetailsRepository;
import com.cts.user.service.repository.MentorSkillsRepository;
import com.cts.user.service.repository.StudentDetailsRepository;
import com.cts.user.service.repository.TrainingRepository;

@Service
public class StudentDetailsService {

	@Autowired
	StudentDetailsRepository studentDetailsRepository;

	@Autowired
	MentorDetailsRepository mentorDetailsRepository;

	@Autowired
	MentorSkillsRepository mentorSkillsRepository;

	@Autowired
	TrainingRepository trainingRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceApplication.class);

	public void giveProposal(String userName, String mentorName, int skillId) {
		LOGGER.info("Nuvve ante naaku chaala ishtam : "+mentorName);
		Training newTraining = new Training();
		newTraining.setStatus("P");
		newTraining.setRating(0);
		newTraining.setProgress("0");
		newTraining.setAmount(0);
		newTraining.setMentorDetails(mentorDetailsRepository.findByUserName(mentorName));
		newTraining.setStudentDetails(studentDetailsRepository.findByUserName(userName));
		newTraining.setMentorSkills(mentorSkillsRepository.findById(skillId));
		trainingRepository.save(newTraining);
		MentorDetails mentorDetails = mentorDetailsRepository.findByUserName(mentorName);
		mentorDetails.setActive(false);
		mentorDetailsRepository.save(mentorDetails);
	}
	
	public List<Training> getProposal(String studentName) {
		return trainingRepository.findByStudentDetails(studentDetailsRepository.findByUserName(studentName));
	}
}
