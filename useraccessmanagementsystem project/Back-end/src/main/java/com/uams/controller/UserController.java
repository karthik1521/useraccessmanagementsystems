package com.uams.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uams.entity.User;
import com.uams.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("/User")
public class UserController {
@Autowired
private UserService userserv;

@PostMapping("/Register")//register/create a new user
public ResponseEntity<String> registeruser(@RequestBody User user) {
	
	userserv.registerUser(user);
	
    return ResponseEntity.ok("register successfully");
}
//Login User
@PostMapping("/Login")
public ResponseEntity<String> loginuser(@RequestBody User user) {
    Optional<User> loggedInUser =userserv.loginuser(user.getUsername(), user.getPassword());
    if (loggedInUser.isPresent()){
    	return ResponseEntity.ok("Login Successfully");
    	
    }
    
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invaild Credentials");
}
}
