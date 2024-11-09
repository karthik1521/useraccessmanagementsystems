package com.uams.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uams.entity.Software;

public interface SoftwareRepository extends JpaRepository<Software, Long> {

}
