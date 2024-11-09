package com.uams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uams.entity.Software;
import com.uams.repo.SoftwareRepository;

@Service
public class SoftwareService {
	
	@Autowired
	public SoftwareRepository softwarerepo;
	
	public Software createsoftware(Software software)
	{
		return softwarerepo.save(software);
	}
	
	public List<Software> getallsoftware()
	{
		return softwarerepo.findAll();
	}

}
