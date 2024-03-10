package com.Project_management_System.ProjectControllerIntegration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Project_management_System.model.Project;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjectControllerIntegrationTest {

	  @LocalServerPort
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;

	  
	  	    private String baseUrl;

	    @BeforeEach
	    public void setUp() {
	        baseUrl = "http://localhost:" + port + "/projects";
	    }

	    @Test
	    @Order(1)
	    public void testAddProject() {
	        // Test Create
	        Project projectToAdd = new Project();
	        projectToAdd.setName("Test Project");
	        projectToAdd.setDescription("This is a test project");
	        projectToAdd.setStartDate(LocalDate.now());
	        projectToAdd.setEndDate(LocalDate.now().plusDays(3));
	        
	    

	        ResponseEntity<Project> createResponse = restTemplate.postForEntity(baseUrl, projectToAdd, Project.class);
	     
	        assertEquals(HttpStatus.CREATED, createResponse.getStatusCode());

	    }
	    @Test
	    @Order(2)
	    public void testGetProjectById() {
	        // Arrange (assuming a project with ID 1 was created in previous test)
	        int projectId = 1;
	        String url = baseUrl+"/"+ projectId;

	        // Act
	        ResponseEntity<Project> getResponse = restTemplate.getForEntity(url, Project.class);

	        // Assert
	        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
	        assertNotNull(getResponse.getBody());
	        assertEquals(projectId, getResponse.getBody().getId());
	    }
	    @Test
	    @Order(3)
	    public void testUpdateProject() {
	        // Arrange (assuming a project with ID 1 exists)
	        int projectId = 1;
	        String url = baseUrl;
	        Project updatedProject = new Project();
	        updatedProject.setId(projectId);
	        updatedProject.setName("Updated Test Project");
	        updatedProject.setDescription("Updated description");
	        updatedProject.setStartDate(LocalDate.now());
	        updatedProject.setEndDate(LocalDate.now().plusDays(1));

	        // Act
	        ResponseEntity<Project> response = restTemplate.exchange(
	            url,
	            HttpMethod.PUT,
	            new HttpEntity<>(updatedProject),
	            Project.class
	        );
System.out.println(response);
	        // Assert
	        assertEquals(HttpStatus.OK, response.getStatusCode());

	        //  Verify the updated project details by retrieving it from the server
	        ResponseEntity<Project> updatedResponse = restTemplate.getForEntity(url+"/"+projectId, Project.class);
	        assertEquals("Updated Test Project", updatedResponse.getBody().getName());
	        assertEquals("Updated description", updatedResponse.getBody().getDescription());
	    }

	    @Test
	    @Order(4)
	    public void testDeleteProject() {
	      
	        int projectId = 1;
	        String url = baseUrl +"/" + projectId;
	        ResponseEntity<Project> getResponse = restTemplate.getForEntity(url, Project.class);

	        // Assert
	        assertEquals(HttpStatus.OK, getResponse.getStatusCode());

	        
	    }
}
