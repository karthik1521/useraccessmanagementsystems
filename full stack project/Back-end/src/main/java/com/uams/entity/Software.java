package com.uams.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Software {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	private String description;
	private String accessLevels; //read write admin
	public Software() {
		super();
		
	}
	public Software(Long id, String name, String description, String accessLevels) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.accessLevels = accessLevels;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAccessLevels() {
		return accessLevels;
	}
	public void setAccessLevels(String accessLevels) {
		this.accessLevels = accessLevels;
	}
}
