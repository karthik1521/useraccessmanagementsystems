package com.uams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uams.entity.AccessRequest;
import com.uams.service.AccessRequestService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("AccessRequest")
public class AccessRequestController {
	
	@Autowired
	private AccessRequestService accessrequestserv;
	
	@PostMapping("/submit")//new access request from Employee
	public ResponseEntity<String> submirequest(@RequestBody AccessRequest accessRequest) {
		
		accessrequestserv.submitrequest(accessRequest);		
		return ResponseEntity.ok("Access Request submitted successfully");
	}
	
	@GetMapping("/pendingrequest")//get pending list
	public ResponseEntity<List<AccessRequest>> getpendingrequest(){
		List<AccessRequest> pendingrequest = accessrequestserv.getpendingrequest();
		return ResponseEntity.ok(pendingrequest);
	}
	
	@PostMapping("/approve/{id}")//approval request
	public ResponseEntity<String> approverequest(@PathVariable Long id) {
		
		accessrequestserv.approverequest(id);
		return ResponseEntity.ok("Request Approved");
	}
	
	@PostMapping("/reject/{id}")
	public ResponseEntity<String> rejectrequest(@PathVariable Long id) {
		
		accessrequestserv.rejectrequest(id);
		return ResponseEntity.ok("Request Rejected");
	}
	

}
