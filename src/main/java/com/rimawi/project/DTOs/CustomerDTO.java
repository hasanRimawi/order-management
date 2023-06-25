package com.rimawi.project.DTOs;

import java.sql.Date;

public class CustomerDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private Date bornAt;

	public CustomerDTO() {

	}

	public CustomerDTO(String firstName, String lastName, Date bornAt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bornAt = bornAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
