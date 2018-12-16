/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.exception;

/**
 * This class acts as a base class for all ToDo errors
 * @author Mohan AMILINENI
 *
 */
public class TodoError {

	//0 - Variable Declarations
	private String message;

	//1 - Constructor Declarations
    public TodoError(String errorMessage) {
        this.message   = errorMessage;
    }    

    //2 - Getters Declarations
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "TodoGenericError [message=" + message + "]";
	}		
}
