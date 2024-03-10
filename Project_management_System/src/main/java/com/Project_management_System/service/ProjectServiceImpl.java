package com.Project_management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project_management_System.exception.ProjectException;
import com.Project_management_System.model.Project;
import com.Project_management_System.repository.ProjectRepository;

@Service
public class ProjectServiceImpl  implements ProjectService {
		
		final ProjectRepository projectRepository;
		
      
		public ProjectServiceImpl(ProjectRepository projectRepository) {
		
			this.projectRepository = projectRepository;
		}

		@Override
		public Project addProject(Project project) throws ProjectException {
			
			return projectRepository.save(project);
		}

		@Override
		public Project getProjectById(int id) throws ProjectException {
		
			return projectRepository.findById(id).get();
		}

		@Override
		public String deleteProject(int id) throws ProjectException {
			Optional<Project> pt= projectRepository.findById(id);
			if(pt.isPresent()) {
			projectRepository.deleteById(id);
			return pt.get().getName()+" has been deleted successfully";
			}
			return "Project with this id "+id+"not found";
		}

		@Override
		public List<Project> getAllProjects() throws ProjectException {
			
			return projectRepository.findAll();
		}

		@Override
		public Project updateProject(Project updatedproject) throws ProjectException {
			
		Project project= projectRepository.findById(updatedproject.getId()).get();
				project.setName(updatedproject.getName());
				project.setDescription(updatedproject.getDescription());
				project.setStartDate(updatedproject.getStartDate());
				project.setEndDate(updatedproject.getEndDate());
			  
			return projectRepository.save(project);
			
		}	
	

}
