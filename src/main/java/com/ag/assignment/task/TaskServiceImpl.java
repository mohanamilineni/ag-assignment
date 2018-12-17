package com.ag.assignment.task;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;


/**
 * Created by AMK on 17/12/18.
 */

@Service
@SuppressWarnings("serial")
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
		task.setBalanced(isBalanced(task.getInput().trim()));	
		return task;
	}

	/******************* PRIVATE APIs*************************/
	
	
	private static final Map<Character, Character> brackets = new HashMap<Character, Character>() {{put('{', '}');put('(', ')');put('[', ']');}};    

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
    public boolean isBalanced(final String strToCheck) {
		       
    	// 1 - odd number would always result in false
        if ((strToCheck.length() % 2) != 0) {
            return false;
        }
    	
    	//2- Declarations
        Deque<Character> openBraceStack = new ArrayDeque<Character>();        
        int strLength = strToCheck.length();
        
		//3- Iterate through list of braces given
        for (int i = 0; i < strLength; i++) {
            char currentChar = strToCheck.charAt(i);
            
			//4.1 - if it is opening type brace, then put it inside stack
            if (isOpenBracket(currentChar)) openBraceStack.push(currentChar);
            
			//4.2 - if it is closing type brace, then check is this matching with corresponding closing brace of LIFO element 
            else if (isClosingBracket(currentChar) && isNotMatching(openBraceStack, currentChar)) return false;            
        }
        //5 - if any of the braces still left over in stack, then string is not balanced.
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
