package com.Project_management_System.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @NotEmpty(message = "please enter name")
	private String name;
    @NotNull(message = "please enter Description")
	private String description;
   
    @NotNull(message = "enter valid date")
    @JsonFormat(pattern = "yyyy-MM-dd")
	private  LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "enter valid date")
    private LocalDate endDate;
	

}
