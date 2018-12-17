package com.ag.assignment.task;

/**
 * Created by AMK on 17/12/18.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ag.assignment.task.Task;
import com.ag.assignment.task.TaskServiceImpl;

public class TaskServiceImplTest {

	TaskServiceImpl taskService;
	

	@Before
	public void setUp() throws Exception {
		taskService = new TaskServiceImpl();
	}

	/*This test case tests for following use cases
	 * 
	 *  1. []     - getIsBalanced must be true.
    	2. [[]    - getIsBalanced must be false.
		3. [[]]   - getIsBalanced must be true.
		4. {[()]} - getIsBalanced must be true.
		5. {[)]}  - getIsBalanced must be false.
		6. )[]}   - getIsBalanced must be false.
	 */
	@Test
	public void testValidateBrackets() {
		
        //given
        Task task= new Task();
        
        //Use case 1 - Check for getIsBalanced true for []
        task.setInput("[]");
        Task validatedTask = taskService.validateBrackets(task);
        assertNotNull(validatedTask);
        assertEquals(true, validatedTask.getIsBalanced());
                
        //Use case 2 - Check for getIsBalanced false for [[]
        task.setInput("[[]");
        validatedTask = taskService.validateBrackets(task);
        assertNotNull(validatedTask);
        assertEquals(false, validatedTask.getIsBalanced());
        
        //Use case 3 - Check for getIsBalanced false for [[]]
        task.setInput("[[]]");
        validatedTask = taskService.validateBrackets(task);
        assertNotNull(validatedTask);
        assertEquals(true, validatedTask.getIsBalanced());

        //Use case 4 - Check for getIsBalanced true for {[()]}
        task.setInput("{[()]}");
        validatedTask = taskService.validateBrackets(task);
        assertNotNull(validatedTask);
        assertEquals(true, validatedTask.getIsBalanced());

        //Use case 5 - Check for getIsBalanced false for {[)]}
        task.setInput("{[)]}");
        validatedTask = taskService.validateBrackets(task);
        assertNotNull(validatedTask);
        assertEquals(false, validatedTask.getIsBalanced());
        
		//Use case 6 - Check for getIsBalanced false for )[]}
		task.setInput(")[]}");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.getIsBalanced());
		
		//Use case 7 - Check for getIsBalanced true for {}[]()
		task.setInput("{}[]()");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(true, validatedTask.getIsBalanced());

		//Use case 8 - Check for getIsBalanced false for {[()}]
		task.setInput("{[()}]");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.getIsBalanced());
		
		//Use case 9 - Check for getIsBalanced false for {[()}]
		task.setInput("{[()}]");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.getIsBalanced());

		//Use case 10 - Check for getIsBalanced true here
		task.setInput("[{()()}({[]})]({}[({})])((((((()[])){}))[]{{{({({({{{{{{}}}}}})})})}}}))[][][]");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(true, validatedTask.getIsBalanced());

		//Use case 11 - Check for getIsBalanced false here
		task.setInput("[{()()}({[]})]({}[({})])((((((()[])){}))[]{{{({({({{{{{{}}}}}})})})}}}))[][][]{");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.getIsBalanced());

		//Use case 12 - Check for getIsBalanced false here
		task.setInput("{");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.getIsBalanced());

		//Use case 13 - Check for getIsBalanced false here
		task.setInput("[[");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.getIsBalanced());

	}
	
}
