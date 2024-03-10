package com.Project_management_System.service;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.Project_management_System.model.Project;
import com.Project_management_System.repository.ProjectRepository;

public class ProjectServiceTest {

	@Mock
	ProjectRepository projectRepository;
	
	@InjectMocks
	public ProjectServiceImpl projectService;
	 @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	@Test
	void createProject() {
		
		Project pt=new Project();
		pt.setId(1);
		pt.setDescription("ecommerce");
		pt.setName("Web-app");
		pt.setEndDate(LocalDate.now().plusDays(5));
		pt.setStartDate(LocalDate.now());
		
		Mockito.when(projectRepository.save(any(Project.class))).thenReturn(pt);
		Project createdProject=projectService.addProject(pt);
		assertEquals(pt.getName(), createdProject.getName());
		assertEquals(pt.getDescription(), createdProject.getDescription());
		assertEquals(pt.getStartDate(), createdProject.getStartDate());
		assertEquals(pt.getEndDate(), createdProject.getEndDate());
		
		
	}
	@Test
	void updateProject() {
		int id =1;
		Project existing=new Project();
		existing.setId(id);
		existing.setDescription("ecommerce");
		existing.setName("Web-app");
		existing.setStartDate(LocalDate.now());
		existing.setEndDate(LocalDate.now().plusDays(5));
		Project updated=new Project();
		updated.setId(id);
		updated.setDescription("standLone");
		updated.setName("Web-app");
		updated.setStartDate(LocalDate.now().plusDays(1));
		updated.setEndDate(LocalDate.now().plusDays(6));
		
		Mockito.when(projectRepository.findById(id)).thenReturn(Optional.of(existing));
		Mockito.when(projectRepository.save(any(Project.class))).thenReturn(updated);
	
		//Act
		Project result=projectService.updateProject(updated);
	
				
		assertEquals(updated.getName(), result.getName());
		assertEquals(updated.getDescription(), result.getDescription());
		assertEquals(updated.getStartDate(), result.getStartDate());
		assertEquals(updated.getEndDate(), result.getEndDate());
		
	}
	@Test
	void getById() {
		
		
		int id=1;
		Project pt=new Project();
		pt.setId(1);
		Mockito.when(projectRepository.findById(id)).thenReturn(Optional.of(pt));
		
		Project reteriveProject=projectService.getProjectById(id);
		assertEquals(reteriveProject.getId(), pt.getId());
		
				
	}
	@Test
	void testDeleteProject() {
	    // Arrange
	    int projectId = 1;
	    Project existingProject = new Project();
	    existingProject.setId(projectId);
	    existingProject.setName("web-app");
	 
	    when(projectRepository.findById(projectId)).thenReturn(Optional.of(existingProject));

	    // Act & Assert
	    assertDoesNotThrow(() -> {
	        // Act
	        String resultMessage = projectService.deleteProject(projectId);

	        // Assert
	        String expectedSuccessMessage = existingProject.getName()+ " has been deleted successfully";
	        assertEquals(expectedSuccessMessage, resultMessage, "Expected success message for project deletion");
	        verify(projectRepository, times(1)).findById(projectId);
	        verify(projectRepository, times(1)).deleteById(projectId);
	    }, () -> "[Failure] deleteProject: Method threw an unexpected exception");

	    
	}

}