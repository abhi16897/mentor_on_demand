package com.cts.training.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "training")
public class Training {

	@Id
	@Column(name = "tr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "tr_status")
	private String status;
	@Column(name = "tr_progress")
	private String progress;
	@Column(name = "tr_rating")
	private int rating;
	@Column(name = "tr_amount")
	private int amount;
	@ManyToOne
	@JoinColumn(name = "tr_sd_id")
	private StudentDetails studentDetails;
	@ManyToOne
	@JoinColumn(name = "tr_md_id")
	private MentorDetails mentorDetails;
	@ManyToOne
	@JoinColumn(name = "tr_ms_id")
	private MentorSkills mentorSkills;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public MentorDetails getMentorDetails() {
		return mentorDetails;
	}

	public void setMentorDetails(MentorDetails mentorDetails) {
		this.mentorDetails = mentorDetails;
	}

	public MentorSkills getMentorSkills() {
		return mentorSkills;
	}

	public void setMentorSkills(MentorSkills mentorSkills) {
		this.mentorSkills = mentorSkills;
	}

	@Override
	public String toString() {
		return "Training [id=" + id + ", status=" + status + ", progress=" + progress + ", rating=" + rating
				+ ", amount=" + amount + ", studentDetails=" + studentDetails + ", mentorDetails=" + mentorDetails
				+ ", mentorSkills=" + mentorSkills + "]";
	}

}
