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

package fr.application.codingame.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.application.codingame.aspects.Log;
import fr.application.codingame.database_api.UserRepository;
import fr.application.codingame.error.NotFoundException;
import fr.application.codingame.models.User;

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
