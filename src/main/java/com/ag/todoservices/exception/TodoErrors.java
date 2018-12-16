/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.exception;

import java.util.List;

/**
 * This class acts as a aggregator model for Todo errors
 * @author Mohan AMILINENI
 *
 */
public class TodoErrors {
	
	//0 - Variable Declarations
	private List<TodoError> details;
	private String name;

	//1 - Construction Declarations
	public TodoErrors(List<TodoError> details, String name) {
		this.details = details;
		this.name    = name;			
	}
	
	//2 - Getters
	public List<TodoError> getDetails() {
		return details;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "TodoValidationErrors [details=" + details + ", name=" + name + "]";
	}
	
	
}
