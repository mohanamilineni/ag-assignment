package com.ag.assignment.exception;

/**
 * Created by AMK on 17/12/18.
 */
public class TodoError {

	//0 - Variable Declarations
	private String message;

	//1 - Constructor Declarations
    public TodoError(final String errorMessage) {
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
