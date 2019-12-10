package com.cts.search.service.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.search.service.model.MentorDetails;
import com.cts.search.service.model.MentorSkills;
import com.cts.search.service.model.Technology;
import com.cts.search.service.repository.MentorDetailsRepository;
import com.cts.search.service.repository.MentorSkillsRepository;
import com.cts.search.service.repository.TechnologyRepositry;

@Service
public class MentorSkillsService {

	@Autowired
	MentorSkillsRepository mentorSkillsRepository;
	
	@Autowired
	TechnologyRepositry technologyRepositry;
	
	@Autowired
	MentorDetailsRepository mentorDetailsRepository;
	
	@Autowired
	TechnologyRepositry technologyrepository;
	
	public void saveSkills(MentorSkills mentorSkills) {
		mentorSkillsRepository.save(mentorSkills);
	}
	
	public List<MentorSkills> getAllDetails() {
		return mentorSkillsRepository.findAll();
	}
	
	public List<MentorSkills> searchMentor(String technolgyName) {
		return mentorSkillsRepository.findByTechnologies(technolgyName);
	}
	public MentorDetails getMentor(String userName){
		return mentorDetailsRepository.findByName(userName);
		
	}
	public List<MentorSkills> getMentorDetails(String mentorName) {
        return mentorSkillsRepository.findByMentorDetails(mentorDetailsRepository.findByUserName(mentorName));
	}
	@Transactional
	public List<MentorDetails> getAllMentors(){
		return mentorDetailsRepository.findAll();
	}
	@Transactional
	public List<Technology> getAllTechnologies(){
		return technologyrepository.findAll();
	}

}
