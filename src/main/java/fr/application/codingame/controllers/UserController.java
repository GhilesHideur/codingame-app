
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

package fr.application.codingame.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.application.codingame.models.User;
import fr.application.codingame.services.UserService;

/**
 * This is a user controller class
 * 
 * @author Ghiles
 * @version 1.0
 */

@RestController
@RequestMapping("/form")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/", "" })
	public String displayForm() {
		return "index.html";
	}

	/*
	 * @PostMapping(value = "/user") public ResponseEntity<HttpStatus>
	 * recoverDataFrom(@RequestParam(name = "lastname", required = true) String
	 * lastName,
	 * 
	 * @RequestParam(name = "firstname", required = true) String
	 * firstName, @RequestParam(required = true) int age,
	 * 
	 * @RequestParam(required = true) String email, @RequestParam(required = true)
	 * String country) {
	 * 
	 * if (age < 18) { ResponseEntity.ok(HttpStatus.OK); throw new
	 * ResponseStatusException(HttpStatus.UNAUTHORIZED,
	 * "Access prohibited to minors"); }
	 * 
	 * 
	 * //userService.saveUser(new User(lastName, firstName, age, email, country));
	 * return ResponseEntity.ok(HttpStatus.OK); }
	 */

	/**
	 * This methode gets all users from database
	 * 
	 * @return ResponseEntity Display Ok
	 */
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getListUsers() {
		List<User> result = userService.getUsers();
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}

	/**
	 * This methode gets a user by ID from database
	 * 
	 * @param id
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id) {
		User result = this.userService.getUser(id);
		return new ResponseEntity<User>(result, HttpStatus.OK);
	}

	/**
	 * This method allows to add a new user in the database
	 * 
	 * @param user
	 * @return ResponseEntity
	 * @throws
	 */
	@PostMapping(value = { "/", "" })
	public ResponseEntity<User> createNewUser(@Valid @RequestBody User user) {
		if (user.getAge() < 18 && user.getCountry().equalsIgnoreCase("france")) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Access prohibited to minors");
		}
		
		User result = this.userService.saveUser(user);
		return new ResponseEntity<User>(result, HttpStatus.ACCEPTED);
	}

	/**
	 * This method removes a user from the database
	 * 
	 * @param id
	 * @return ResponseEntity
	 */
	@DeleteMapping(value = "/users/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		userService.detelet(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
