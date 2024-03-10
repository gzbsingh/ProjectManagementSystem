# ProjectManagementSystem

## Introduction
Developed a RESTful API using Java 17 and Spring Boot, implementing CRUD (Create,  Read, Update, Delete) operations for a Project Management System. The system should use an  in-memory database for data storage and management.

## Project Type
Backend Application

## Directory Structure
├─ Project_management_System/

## Video Walkthrough of the project
Attach a very short video walkthough of all of the features [ 1 - 3 minutes ]

## Video Walkthrough of the codebase
Attach a very short video walkthough of codebase [ 1 - 5 minutes ]

## Features
- **createProject**: creating project  api.
- **updateProject**: api for update project.
- **DeleteProject**:api for delete project.
- **Viewproject**: api for view all projects information.


## design decisions or assumptions
Assumption 1: Endpoints for the API were specified in the assignment requirements, and I implemented them accordingly. This decision ensures that the API aligns with the specified functionality and adheres to the RESTful principles outlined in the assignment. By following the provided requirements closely, I aimed to create an API that meets the expected behavior and facilitates seamless interaction with the Project Management System. Additionally, this approach helps maintain consistency and clarity in the API design, making it easier for clients to understand and utilize the available endpoints.

### Prerequisites

Before running the project, ensure you have the following installed on your system:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) version 17 or higher


  ### Installation Steps

 1. **Clone the repository:**

    ```bash
    git clone https://github.com/gzbsingh/ProjectManagementSystem.git

    b Set up the Project_management_System:
     Navigate to the Project_management_System:
     bash
     Copy code
    cd Project_management_System

## EndPoints
 GET
/projects: get list of all projects.

PUT
/projects: update project.

POST      
/projects: create projects.

GET
/projects/{id}: get project by project Id.

DELETE               
/projects/{id}  : delete project by project Id.

### Include screenshots as necessary
![swaggerPNG](https://github.com/gzbsingh/ProjectManagementSystem/assets/39863817/abd662be-1e6d-4332-9eaf-d522ca7ac2ea)

## Technology Stack


- **Back-end**: Java (Spring Boot)
- **Database**: In Memory h2 database.
- **Documentation**- Open ai doc (swagger). 


