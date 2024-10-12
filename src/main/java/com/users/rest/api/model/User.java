package com.users.rest.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_name")
	private String username;

	@Column(name = "first name")
	private String firstName;

	@Column(name = "last name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone number")
	private String phoneNumber;

}
