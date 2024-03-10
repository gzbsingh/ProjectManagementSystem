package com.Project_management_System.exception;



import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ProjectException.class)
	public ResponseEntity<ErrorFormat> projectExceptionHandler(ProjectException se,HttpServletRequest req){
		System.out.println("erro");
		ErrorFormat er=new ErrorFormat();
		er.setMessage(se.getMessage());
		er.setTimestamp(LocalDateTime.now());
		er.setUrl(req.getRequestURI());
		return new ResponseEntity<>(er , HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<String> NoHandelerExceptionHandler(NoHandlerFoundException se){
		return new ResponseEntity<>("There is no handler for this endpoint" , HttpStatus.BAD_REQUEST) ;
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorFormat> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException se,HttpServletRequest req){
		
		ErrorFormat er=new ErrorFormat();
		er.setMessage(se.getBindingResult().getFieldError().getDefaultMessage());
		er.setTimestamp(LocalDateTime.now());
		er.setUrl(req.getRequestURI());
		return new ResponseEntity<>(er , HttpStatus.BAD_REQUEST) ;
	}
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorFormat> MethodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException se,HttpServletRequest req){
		
		ErrorFormat er=new ErrorFormat();
		er.setMessage("please fill format right");
		er.setTimestamp(LocalDateTime.now());
		er.setUrl(req.getRequestURI());
		return new ResponseEntity<>(er , HttpStatus.BAD_REQUEST) ;
	}
	// 1.05
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorFormat> GeneralExceptionHandler(Exception se,HttpServletRequest req){
		
		ErrorFormat er=new ErrorFormat();
		er.setMessage(se.getMessage());
		er.setTimestamp(LocalDateTime.now());
		er.setUrl(req.getRequestURI());
		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST) ;
	}

}
