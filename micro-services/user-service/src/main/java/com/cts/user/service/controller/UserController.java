package com.cts.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.user.service.model.Training;
import com.cts.user.service.service.MentorDetailsService;
import com.cts.user.service.service.StudentDetailsService;

@RestController
@RequestMapping("/proposal")
public class UserController {

	@Autowired
	MentorDetailsService mentorDetailsService;

	@Autowired
	StudentDetailsService studentDetailsService;

	@PostMapping("/{userName}/{mentorName}/{skillId}")
	public void giveProposal(@PathVariable("userName") String userName, @PathVariable("mentorName") String mentorName,
			@PathVariable("skillId") int skillId) {
		studentDetailsService.giveProposal(userName, mentorName, skillId);
	}

	@GetMapping("/mentor/{mentorName}/{status}")
	public List<Training> getMentorProposal(@PathVariable("mentorName") String mentorName,
			@PathVariable("status") String status) {
		return mentorDetailsService.getProposal(mentorName, status);
	}

	@PutMapping("/{trainingId}/{status}")
	public void updateProposal(@PathVariable("trainingId") int trainingId, @PathVariable("status") String status) {
		mentorDetailsService.updateProposal(trainingId, status);
	}

	@GetMapping("/student/{studentName}")
	public List<Training> getStudentProposal(@PathVariable("studentName") String studentName) {
		return studentDetailsService.getProposal(studentName);
	}
}
