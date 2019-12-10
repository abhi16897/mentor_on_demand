package com.cts.registration.service.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.registration.service.RegistrationServiceApplication;
import com.cts.registration.service.model.MentorDetails;
import com.cts.registration.service.model.MentorSkills;
import com.cts.registration.service.model.StudentDetails;
import com.cts.registration.service.model.User;
import com.cts.registration.service.service.MentorDetailsService;
import com.cts.registration.service.service.MentorSkillsService;
import com.cts.registration.service.service.StudentDetailsService;
import com.cts.registration.service.service.TechnologyService;
import com.cts.registration.service.service.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	MentorDetailsService mentorDetailsService;

	@Autowired
	UserService userService;

	@Autowired
	StudentDetailsService studentDetailsService;

	@Autowired
	TechnologyService technologyService;

	@Autowired
	MentorSkillsService mentorSkillsService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceApplication.class);

	@PostMapping("/mentor")
	public boolean mentorRegistration(@RequestBody MentorDetails mentorDetails) {
		MentorDetails detailsOne = mentorDetailsService.findByUserName(mentorDetails.getUserName());
		User details=userService.findUser(mentorDetails.getUserName());
		if (details == null && detailsOne == null) {
			MentorDetails newMentor = new MentorDetails();
			newMentor.setUserName(mentorDetails.getUserName());
			newMentor.setFirstName(mentorDetails.getFirstName());
			newMentor.setLastName(mentorDetails.getLastName());
			newMentor.setEmail(mentorDetails.getEmail());
			newMentor.setPassword(passwordEncoder().encode(mentorDetails.getPassword()));
			newMentor.setContact(mentorDetails.getContact());
			newMentor.setLinkedInUrl(mentorDetails.getLinkedInUrl());
			newMentor.setExperience(mentorDetails.getExperience());
			newMentor.setActive(mentorDetails.isActive());
			newMentor.setImage(mentorDetails.getImage());
			LOGGER.info("Mentor Details: " + mentorDetails);
			mentorDetailsService.saveMentorDetails(newMentor);
			User user = new User();
			user.setName(mentorDetails.getUserName());
			user.setEmail(mentorDetails.getEmail());
			user.setPassword(passwordEncoder().encode(mentorDetails.getPassword()));
			user.setRole("Mentor");
			userService.register(user);
			return true;
		}
		return false;
	}

	@PostMapping("/mentor/skills/{mentor}/{technology}")
	public boolean mentorSkillsRegistration(@RequestBody MentorSkills mentorSkills,
			@PathVariable("mentor") String userName, @PathVariable("technology") String technologyName) {
		MentorSkills newMentorSkill = new MentorSkills();
		LOGGER.info("Mentor Skills: " + mentorSkills);
		newMentorSkill.setRating(mentorSkills.getRating());
		newMentorSkill.setExperience(mentorSkills.getExperience());
		newMentorSkill.setFacilities(mentorSkills.getFacilities());
		newMentorSkill.setTrainings(mentorSkills.getTrainings());
		newMentorSkill.setMentorDetails(mentorDetailsService.findByUserName(userName));
		newMentorSkill.setTechnologies(technologyService.getTechnology(technologyName));
		mentorSkillsService.saveSkills(newMentorSkill);
		return true;
	}
	
	@PostMapping("/mentor/skills")
	public void mentorSkills(@RequestBody Set<MentorSkills> mentorSkillsSet) {
		LOGGER.info("Mentor Skills Set: "+mentorSkillsSet);
		for(MentorSkills mentorSkills : mentorSkillsSet) {
			LOGGER.info("Mentor Skills: "+mentorSkills);
			MentorSkills newMentorSkill = new MentorSkills();
			newMentorSkill.setRating(mentorSkills.getRating());
			newMentorSkill.setExperience(mentorSkills.getExperience());
			newMentorSkill.setFacilities(mentorSkills.getFacilities());
			newMentorSkill.setTrainings(mentorSkills.getTrainings());
			LOGGER.info("Mentor Details: "+mentorSkills.getMentorDetails());
			MentorDetails mentorDetails = mentorDetailsService.findByUserName(mentorSkills.getMentorDetails().getUserName());
			LOGGER.info("Mentor Details New: "+mentorDetails);
			newMentorSkill.setMentorDetails(mentorDetails);
			newMentorSkill.setTechnologies(mentorSkills.getTechnologies());
			mentorSkillsService.saveSkills(newMentorSkill);
		}
	}

	@PostMapping("/student")
	public boolean studentRegistration(@RequestBody StudentDetails studentDetails) {
		StudentDetails detailsOne = studentDetailsService.findByUserName(studentDetails.getUserName());
		User details=userService.findUser(studentDetails.getUserName());
		if (details == null && detailsOne==null) {
			StudentDetails newStudent = new StudentDetails();
			newStudent.setUserName(studentDetails.getUserName());
			newStudent.setFirstName(studentDetails.getFirstName());
			newStudent.setLastName(studentDetails.getLastName());
			newStudent.setEmail(studentDetails.getEmail());
			newStudent.setPassword(passwordEncoder().encode(studentDetails.getPassword()));
			newStudent.setContact(studentDetails.getContact());
			newStudent.setImage(studentDetails.getImage());
			studentDetailsService.registration(newStudent);
			User user = new User();
			user.setName(studentDetails.getUserName());
			user.setEmail(studentDetails.getEmail());
			user.setPassword(passwordEncoder().encode(studentDetails.getPassword()));
			user.setRole("Student");
			userService.register(user);
			return true;
		}
		return false;
	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
