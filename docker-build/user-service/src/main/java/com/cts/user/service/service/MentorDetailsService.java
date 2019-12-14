package com.cts.user.service.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.user.service.model.MentorDetails;
import com.cts.user.service.model.Training;
import com.cts.user.service.repository.MentorDetailsRepository;
import com.cts.user.service.repository.TrainingRepository;

@Service
public class MentorDetailsService {

	@Autowired
	TrainingRepository trainingRepository;
	
	@Autowired
	MentorDetailsRepository mentorDetailsRepository;
	
	public List<Training> getProposal(String mentorName, String status) {
		return trainingRepository.findByMentorDetails(mentorName, status);
		
	}
	
	@Transactional
	public void updateProposal(int trainingId, String status) {
        Training training = trainingRepository.findById(trainingId);
        training.setStatus(status);
        MentorDetails mentorDetails = training.getMentorDetails();
        if(status=="D"){
        mentorDetails.setActive(true);
        }
        else{
               mentorDetails.setActive(false);
        }
        trainingRepository.save(training);
 }

}
