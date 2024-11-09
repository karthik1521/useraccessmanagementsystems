package com.uams.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uams.entity.User;
import com.uams.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepo;
	
	public User registerUser(User user)
	{
		//New user for employee
		user.setRole("EMPLOYEE");
		return userrepo.save(user);
	}
	
	public Optional<User> loginuser(String username, String password)
	{
		//check user exists or not and create validate password
		Optional<User> user = userrepo.findByUsername(username);
		
		if(user.isPresent() && user.get().getPassword().equals(password)) {
			return user; //all correct login successful
		}
		return Optional.empty(); //login failed
	}

}
