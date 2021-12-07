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

import fr.application.codingame.models.User;
import fr.application.codingame.services.UserService;

/**
 * This is a user controller class Contains the following methods :
 * <i>createNewUser</i> <i>getListUsers</i> <i>getUserById</i> <i>deleteUser</i>
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
