package com.Project_management_System.service;

import java.util.List;

import com.Project_management_System.exception.ProjectException;
import com.Project_management_System.model.Project;

public interface ProjectService {

	Project addProject(Project project) throws ProjectException;
	Project getProjectById(int id) throws ProjectException;
	String deleteProject(int id) throws ProjectException;
	List<Project> getAllProjects() throws ProjectException;
	Project updateProject(Project project) throws ProjectException;
	
}
