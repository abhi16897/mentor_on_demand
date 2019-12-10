package com.cts.user.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mentor_skill")
public class MentorSkills {

	@Id
	@Column(name = "ms_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "ms_self_rating")
	private int rating;
	@Column(name = "ms_exp")
	private float experience;
	@Column(name = "ms_facilities")
	private String facilities;
	@Column(name = "ms_trainings_delivered")
	private int trainings;
	@ManyToOne
	@JoinColumn(name = "ms_md_id")
	private MentorDetails mentorDetails;
	@ManyToOne
	@JoinColumn(name = "ms_t_id")
	private Technology technologies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public int getTrainings() {
		return trainings;
	}

	public void setTrainings(int trainings) {
		this.trainings = trainings;
	}

	public MentorDetails getMentorDetails() {
		return mentorDetails;
	}

	public void setMentorDetails(MentorDetails mentorDetails) {
		this.mentorDetails = mentorDetails;
	}

	public Technology getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Technology technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "MentorSkills [id=" + id + ", rating=" + rating + ", experience=" + experience + ", facilities="
				+ facilities + ", trainings=" + trainings + ", mentorDetails=" + mentorDetails + ", technologies="
				+ technologies + "]";
	}

}
