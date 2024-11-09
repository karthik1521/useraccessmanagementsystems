package com.uams.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uams.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//find a user by username
	Optional<User> findByUsername(String username);
	
	//it's optional: check username already exists
	boolean existsByUsername(String username);

}