package com.Project_management_System.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project_management_System.model.Project;
import com.Project_management_System.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	
	final ProjectService projectService;

	public ProjectController(ProjectService projectService) {
	
		this.projectService = projectService;
	}
	
	@PostMapping
	ResponseEntity<Project> addProject(@Valid @RequestBody Project project){		
	 return new ResponseEntity<Project>(projectService.addProject(project),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	ResponseEntity<Project> projectGetById(@Valid @PathVariable("id") int id){
		return new ResponseEntity<Project>(projectService.getProjectById(id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteProject(@Valid @PathVariable("id") int id){
		
		return new ResponseEntity<String>(projectService.deleteProject(id),HttpStatus.OK);
	}
	@PutMapping
	ResponseEntity<Project> updateProject(@Valid @RequestBody Project project){
		return new ResponseEntity<Project>(projectService.updateProject(project),HttpStatus.OK);
	}
     @GetMapping
     ResponseEntity<List<Project>> getAllProjects(){
    	 return new ResponseEntity<>(projectService.getAllProjects(),HttpStatus.OK);
     }
}
