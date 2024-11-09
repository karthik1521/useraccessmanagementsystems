package com.uams.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uams.entity.Software;
import com.uams.service.SoftwareService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin("*")
@RestController
@RequestMapping("/Software")
public class SoftwareController {
	
	@Autowired
	private SoftwareService softwareserv;
	
	@PostMapping("/create")//create a new software application(admin only)
	public ResponseEntity<String> createsoftware (@RequestBody Software software) {
		
		softwareserv.createsoftware(software);
		return ResponseEntity.ok("software application create successfully");
	}
	
	@GetMapping("/get")//get all of software application
	public ResponseEntity<List<Software>> getAllsoftware( String param) {
		List<Software> softwareList= softwareserv.getallsoftware();
		return ResponseEntity.ok(softwareList);
	}
	
}
