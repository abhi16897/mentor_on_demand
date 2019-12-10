package com.cts.search.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.search.service.model.MentorDetails;
import com.cts.search.service.model.MentorSkills;
import com.cts.search.service.model.Technology;
import com.cts.search.service.service.MentorSkillsService;

@RestController
@RequestMapping("/details")
public class SearchController {

	@Autowired
	MentorSkillsService mentorSkillsService;
	
	@GetMapping("")
	public List<MentorSkills> getMentorDetails() {
		return mentorSkillsService.getAllDetails();
	}
	
	@GetMapping("/{technologyName}")
	public List<MentorSkills> searchMentor(@PathVariable("technologyName") String technologyName) {
		return mentorSkillsService.searchMentor(technologyName);
	}
	
//	@GetMapping("/mentor/{userName}")
//	public MentorDetails getMentor(@PathVariable("userName") String userName){
//		return mentorSkillsService.getMentor(userName);
//		
//	}
	@GetMapping("mentor/{mentorName}")
    public List<MentorSkills> getMentorDetail(@PathVariable("mentorName") String mentorName) {
           return mentorSkillsService.getMentorDetails(mentorName);
    }
	
	@GetMapping("mentorDetails")
	public List<MentorDetails> getAllMentors(){
		return mentorSkillsService.getAllMentors();
	}
	
	@GetMapping("technologies")
	public List<Technology> getAllTechnologies(){
		return mentorSkillsService.getAllTechnologies();
	}

}
