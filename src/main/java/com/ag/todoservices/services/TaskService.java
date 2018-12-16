/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.services;


import com.ag.todoservices.domain.Task;


/**
 * This class acts as an interface for task Services 
 * @author Mohan AMILINENI
 *
 */
public interface TaskService {
	
	/**
	 * Evaluates input string and determines the string is balanced or not.
	 * 	 * Criteria is to have every opening bracket must have its corresponding bracket in an ordered form.
	 * e.g. [] 		- true
	 *      {[()]}  - true
	 *      {[)]}   - false
	 *      )[]}    - false
	 * @param bracerStr - Input string containing brackets.
	 * @return boolean true if the string is balanced.
	 *
	 */
    public Task validateBrackets(Task task);
}

