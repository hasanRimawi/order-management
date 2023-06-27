package com.rimawi.project.DTOs;

import java.sql.Date;

public class CustomerDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private Date bornAt;
	private String password;
	private String username;

	public CustomerDTO() {

	}

	public CustomerDTO(String firstName, String lastName, String username, String password, Date bornAt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bornAt = bornAt;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getBornAt() {
		return bornAt;
	}

	public void setBornAt(Date bornAt) {
		this.bornAt = bornAt;
	}

}
