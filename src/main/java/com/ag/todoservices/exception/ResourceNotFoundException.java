/*
 * @fullReview  Mohan AMILINENI 16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * This class dedicated for handling Resource Not found exceptions across services. 
 * @author Mohan AMILINENI
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}