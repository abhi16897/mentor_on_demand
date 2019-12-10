package com.cts.training.service.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "technology")
public class Technology {

	@Id
	@Column(name = "t_id")
	private int id;
	@Column(name = "t_name")
	private String name;
	@Column(name = "t_toc")
	private String tableOfContents;
	@Column(name = "t_duration")
	private int duration;
	@Column(name = "t_prerequisites")
	private String prerequisites;
	@JsonIgnore
	@OneToMany(mappedBy = "technologies")
	private Set<MentorSkills> mentorSkills;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTableOfContents() {
		return tableOfContents;
	}

	public void setTableOfContents(String tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	public Set<MentorSkills> getMentorSkills() {
		return mentorSkills;
	}

	public void setMentorSkills(Set<MentorSkills> mentorSkills) {
		this.mentorSkills = mentorSkills;
	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", name=" + name + ", tableOfContents=" + tableOfContents + ", duration="
				+ duration + ", prerequisites=" + prerequisites + "]";
	}

}
