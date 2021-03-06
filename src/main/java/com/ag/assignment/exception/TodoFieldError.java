package com.ag.assignment.exception;

/**
 * Created by AMK on 17/12/18.
 */
public class TodoFieldError extends TodoError {

	//0 - Variable Declarations
	private String location;
	private String param;
	private Object value;
	
	//1 - Construction Declarations
    public TodoFieldError(final String location, final String field, final String errorMessage, final Object rejectedValue) {
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
