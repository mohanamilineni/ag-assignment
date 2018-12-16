/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.exception;

/**
 * This class manages individual field error for each property of ToDo
 * @author Mohan AMILINENI
 *
 */
public class TodoFieldError extends TodoError {

	//0 - Variable Declarations
	private String location;
	private String param;
	private Object value;
	
	//1 - Construction Declarations
    public TodoFieldError(String location, String field, String errorMessage, Object rejectedValue) {
    	super(errorMessage);
        this.location  = location;
        this.param 	   = field;
        this.value 	   = rejectedValue;
    }
    
	//2 - Getters
	public String getLocation() {
		return location;
	}
	
	public String getParam() {
		return param;
	}
	
	public Object getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "TodoFieldError [location=" + location + ", param=" + param + ", message=" + getMessage() + ", value=" + value + "]";
	}	
}
