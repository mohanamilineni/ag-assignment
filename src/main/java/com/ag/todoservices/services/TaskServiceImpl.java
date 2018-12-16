/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.services;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
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
		task.setIsBalanced(isBalanced(task.getInput().trim()));	
		return task;
	}

	/******************* PRIVATE APIs*************************/
	
	
	final Map<Character, Character> brackets = new HashMap<Character, Character>() {{put('{', '}');put('(', ')');put('[', ']');}};    

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
    public boolean isBalanced(String strToCheck) {
		//0- Declarations
        Deque<Character> openBraceStack = new ArrayDeque<Character>();        
        int strLength = strToCheck.length();
        
		//1- Iterate through list of braces given
        for (int i = 0; i < strLength; i++) {
            char currentChar = strToCheck.charAt(i);
            
			//1.1 - if it is opening type brace, then put it inside stack
            if (isOpenBracket(currentChar)) openBraceStack.push(currentChar);
            
			//1.2 - if it is closing type brace, then check is this matching with corresponding closing brace of LIFO element 
            else if (isClosingBracket(currentChar) && isNotMatching(openBraceStack, currentChar)) return false;            
        }
        //2 - if any of the braces still left over in stack, then string is not balanced.
        return openBraceStack.isEmpty();
    }
    
    private boolean isNotMatching(Deque<Character> openBraceStack, char currentChar) {
        return openBraceStack.size() == 0 || !brackets.get(openBraceStack.pop()).equals(currentChar);
    }

    private boolean isClosingBracket(char currentChar) {
        return brackets.values().contains(currentChar);
    }

    private boolean isOpenBracket(char currentChar) {
        return brackets.containsKey(currentChar);
    }
}
