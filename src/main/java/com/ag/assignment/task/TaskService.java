package com.ag.assignment.task;

/**
 * Created by AMK on 17/12/18.
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

