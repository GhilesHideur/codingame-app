package fr.application.codingame.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the user model
 * 
 * @author Ghiles
 * @version 1.0
 */

@Data
@NoArgsConstructor
@Document(collection = "users")
public class User {

	@Id
	private String id;
	
	@NotNull(message = "Last name is required")
	private String lastname;

	@NotNull(message = "First name is required")
	private String firstname;

	@NotNull(message = "Age is required")
	private int age;

	@Email
	private String email;

	@NotNull(message = "Country name is required")
	private String country;

	public User(String lastname, String firstname, int age, String email, String country) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
		this.email = email;
		this.country = country;
	}
}
