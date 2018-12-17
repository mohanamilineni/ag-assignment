package com.ag.assignment.exception;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import static java.util.stream.Collectors.toList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by AMK on 17/12/18.
 */
@RestControllerAdvice
public class TodoServicesControllerExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	TodoErrors handleDataNotFound(ResourceNotFoundException ex, HttpServletRequest req) {
		List<TodoError> todoErrors = new ArrayList<>();
		todoErrors.add(new TodoError(ex.getMessage()));
	    return new TodoErrors(todoErrors, ExceptionConstants.NOT_FOUND_ERROR);
	}
	
	/**
	 * This method handles validation for the input arguments and returns proper message in json.
	 * @param ex	- Accepts BindException object
	 * @return		- Custom json information.
	 */
	@Override		
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleError(ex.getBindingResult(), HttpStatus.BAD_REQUEST, ExceptionConstants.VALIDATION_ERROR);    
	}
	
	/**
	 * This method handles validation for the input arguments and returns proper message in json.
	 * @param ex	- Accepts BindException object
	 * @return		- Custom json information.
	 */
	@Override		
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleError(ex.getBindingResult(), HttpStatus.BAD_REQUEST, ExceptionConstants.VALIDATION_ERROR);
    }
	
	/******************* PRIVATE APIs*************************/
	
	private ResponseEntity<Object> handleError(BindingResult bindingResult, HttpStatus httpStatus, String errorType) {
		//2 -  Prepares final object of error and bind with respose entity
        TodoErrors todoErrors = new TodoErrors(extractErrors(bindingResult), ExceptionConstants.VALIDATION_ERROR);

        return new ResponseEntity<>(todoErrors, HttpStatus.BAD_REQUEST);
	}
	
	private List<TodoError> extractErrors(BindingResult bindingResult) {
		
		//1 -  Prepares list of fields errors
        List<TodoError> todoFieldErrors = bindingResult.getFieldErrors()
        												.stream()
        											    .map(fieldError -> new TodoFieldError("params", fieldError.getField(),
        			 									    		 						  fieldError.getDefaultMessage(),fieldError.getRejectedValue()))
        											    									  .collect(toList());
        
        return todoFieldErrors;

	}
	
}
