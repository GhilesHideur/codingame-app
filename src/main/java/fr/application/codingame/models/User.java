
/*
 * Copyright 2021 Ghiles HIDEUR.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.application.codingame.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(min = 2)
	private String lastname;

	@NotNull(message = "First name is required")
	@Size(min = 2)
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
