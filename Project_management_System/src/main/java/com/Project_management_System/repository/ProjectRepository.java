package com.Project_management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project_management_System.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	
}
