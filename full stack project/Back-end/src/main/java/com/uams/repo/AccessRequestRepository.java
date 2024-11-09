package com.uams.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uams.entity.AccessRequest;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
	
	//find all request by status(eg. "PENDING", :"APPROVED", "REJECTED")
	List<AccessRequest> findByStatus(String status);
	
	//it's optional: find all request by user id
	//List<AccessRequest> findByUserid(String userid);

}
