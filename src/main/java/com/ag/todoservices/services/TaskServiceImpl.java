/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.services;

import java.util.Stack;

import org.springframework.stereotype.Service;

import com.ag.todoservices.domain.Task;


/**
 * This class acts as an implementation for Task Services and internally leverages Validator services
 * @author Mohan AMILINENI - 16/11/2018
 *
 */

@Service
public class TaskServiceImpl implements TaskService {
	
	public TaskServiceImpl() {}
	
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
	@Override
	public Task validateBrackets(Task task) {
		task.setIsBalanced(isValid(task.getInput().trim()));	
		return task;
	}

	/******************* PRIVATE APIs*************************/
	
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
	private boolean isValid(String bracerStr) {
		
		//0- Declarations
		boolean isBalanced 			    = false;
		char[] bracerArr                = bracerStr.toCharArray();
		Stack<Character> openBraceStack = new Stack<Character>();
		
		char braceChar;
		//1- Iterate through list of braces given
		for (int i=0; i < bracerArr.length ; i++) {
			
			braceChar = bracerArr[i];
			
			//1.1 - if it is opening type brace, then put it inside stack
			if(braceChar == '{' || braceChar == '[' || braceChar == '(') {
				openBraceStack.push(braceChar);
			}
			
			//1.2 - if it is closing type brace, then go inside
			else if(braceChar == '}' || braceChar == ']' || braceChar == ')') {
				
				//1.2.1 - if first character itself closing brace, then break and also if not balanced return false.
				if(openBraceStack.isEmpty() || !isBalanced(openBraceStack.pop(), braceChar)) {
					break;
				}
				//1.2.2 - Take first element of stack and compare it with closing brace, if it matches balanced true for given pair and move ahead for next char.
				else {
					isBalanced = true;
					continue;
				}
			}
		}
		//1.3 after all the matches, if the characters still left over in the stack then the string is not balanced 
		if(!openBraceStack.isEmpty()) isBalanced = false;
		
		return isBalanced;
	}
	
	/**Compares opening and closing char and returns true if it is balanced.
	 * 	
	 * @param openingChar
	 * @param closingChar
	 * @return isBalanced true if the opening and closing char forms balance.
	 */
	private boolean isBalanced(char openingChar, char closingChar) {		
		//0 - check for parentheses
      	if (openingChar == '(' && closingChar == ')') 		return true;
      	
		//1 - check for flower braces
        else if (openingChar == '{' && closingChar == '}')	return true;
      	
		//2 - check for square braces
        else if (openingChar == '[' && closingChar == ']')  return true;
      	
		//3 - return false if above condition fails.
        else return false;		
	}
}
