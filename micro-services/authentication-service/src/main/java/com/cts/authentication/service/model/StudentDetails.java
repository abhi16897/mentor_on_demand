package com.cts.authentication.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "student_details")
public class StudentDetails {
	@Id
	@NotNull
	@Column(name = "sd_id")
	private int id;

	@NotEmpty(message = "please provide student username")
	@Column(name = "sd_username")
	private String userName;

	@NotEmpty(message = "please provide student firstname")
	@Column(name = "sd_firstname")
	private String firstName;

	@NotEmpty(message = "please provide student lastname")
	@Column(name = "sd_lastname")
	private String lastName;

	@NotEmpty(message = "please provide student emailId")
	@Column(name = "sd_email")
	private String email;

	@NotEmpty(message = "please provide student password")
	@Column(name = "sd_password")
	private String password;

	@NotEmpty(message = "please provide student contact")
	@Column(name = "sd_contact")
	private String contact;

	@NotEmpty(message = "please provide image url")
	@Column(name = "sd_image")
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + ", contact=" + contact + ", image=" + image
				+ "]";
	}

}
