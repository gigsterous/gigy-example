package com.gigy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gigy.model.User;

/**
 * Access to the user data. JpaRepository grants us convenient access methods here.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	
	/**
	 * Find a user by username
	 *
	 * @param username the user's username
	 * @return user which contains the user with the given username or null.
	 */
	User findOneByUsername(String username);

}
