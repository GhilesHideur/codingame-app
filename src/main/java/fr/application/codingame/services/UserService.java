package fr.application.codingame.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.application.codingame.aspects.Log;
import fr.application.codingame.error.AccessForbiddenException;
import fr.application.codingame.error.ConflictException;
import fr.application.codingame.error.NotFoundException;
import fr.application.codingame.models.User;
import fr.application.codingame.repositories.UserRepository;

/**
 * This is a user service class
 * 
 * @author Ghiles
 * @version 1.0
 */

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Insert a user in database
	 * 
	 * @param user
	 * @return user
	 */
	@Log
	public User saveUser(User user) {
		if (user.getAge() < 18 || !user.getCountry().equalsIgnoreCase("france")) {
			throw new AccessForbiddenException("Access Denided");
		}
		if(userRepository.findByEmail(user.getEmail()) != null) {
			throw new ConflictException("Existing email address");
		}
		return this.userRepository.insert(user); 
	}

	/**
	 * Get all Users from database
	 * 
	 * @return List of Users
	 */
	@Log
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	/**
	 * Get a user with an ID from database
	 * 
	 * @param id
	 * @return user
	 * @exception NoSuchElementException
	 * @throws NotFoundException
	 */
	@Log
	public User getUser(String id) {
		try {
			return this.userRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new NotFoundException(String.format("No record with the ID %s in database", id));
		}
	}

	/**
	 * Remove a user with an ID from database
	 * 
	 * @param id
	 */
	@Log
	public void detelet(String id) {
		this.userRepository.deleteById(id);
	}
}
