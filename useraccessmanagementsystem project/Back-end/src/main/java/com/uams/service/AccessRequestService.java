package com.uams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uams.entity.AccessRequest;
import com.uams.repo.AccessRequestRepository;

@Service
public class AccessRequestService {
	
	@Autowired
	private AccessRequestRepository accessrequestrepo;
	
	public AccessRequest submitrequest(AccessRequest accessrequest)
	{
		accessrequest.setStatus("PENDING");
		return accessrequestrepo.save(accessrequest);
	}
	
	public List<AccessRequest> getpendingrequest()
	{
		return accessrequestrepo.findByStatus("PENDING");
	}
	
	public AccessRequest approverequest(Long userid)
	{
		AccessRequest request = accessrequestrepo.findById(userid)
				.orElseThrow(()->new RuntimeException("Request not found"));
		request.setStatus("Approved");
		return accessrequestrepo.save(request);
	}
	
	public AccessRequest rejectrequest(Long userid)
	{
		AccessRequest request = accessrequestrepo.findById(userid)
				.orElseThrow(()->new RuntimeException("Request not found"));
		request.setStatus("Rejected");
		return accessrequestrepo.save(request);
	}

}
