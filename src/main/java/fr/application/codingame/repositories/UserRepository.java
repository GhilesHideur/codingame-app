package fr.application.codingame.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.application.codingame.models.User;

/**
 * This interface extends the MongoRepository interface which allows to have a MongoDB API 
 * 
 * @author Ghiles
 * @version 1.0
 */

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findByEmail(String email);
}
