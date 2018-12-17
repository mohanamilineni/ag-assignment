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
	 *  1. []     - isBalanced must be true.
    	2. [[]    - isBalanced must be false.
		3. [[]]   - isBalanced must be true.
		4. {[()]} - isBalanced must be true.
		5. {[)]}  - isBalanced must be false.
		6. )[]}   - isBalanced must be false.
	 */
	@Test
	public void testValidateBrackets() {
		
        //given
        Task task= new Task();
        
        //Use case 1 - Check for isBalanced true for []
        task.setInput("[]");
        Task validatedTask = taskService.validateBrackets(task);
        assertNotNull(validatedTask);
        assertEquals(true, validatedTask.isBalanced());
                
        //Use case 2 - Check for isBalanced false for [[]
        task.setInput("[[]");
        validatedTask = taskService.validateBrackets(task);
        assertNotNull(validatedTask);
        assertEquals(false, validatedTask.isBalanced());
        
        //Use case 3 - Check for isBalanced false for [[]]
        task.setInput("[[]]");
        validatedTask = taskService.validateBrackets(task);
        assertNotNull(validatedTask);
        assertEquals(true, validatedTask.isBalanced());

        //Use case 4 - Check for isBalanced true for {[()]}
        task.setInput("{[()]}");
        validatedTask = taskService.validateBrackets(task);
        assertNotNull(validatedTask);
        assertEquals(true, validatedTask.isBalanced());

        //Use case 5 - Check for isBalanced false for {[)]}
        task.setInput("{[)]}");
        validatedTask = taskService.validateBrackets(task);
        assertNotNull(validatedTask);
        assertEquals(false, validatedTask.isBalanced());
        
		//Use case 6 - Check for isBalanced false for )[]}
		task.setInput(")[]}");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.isBalanced());
		
		//Use case 7 - Check for isBalanced true for {}[]()
		task.setInput("{}[]()");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(true, validatedTask.isBalanced());

		//Use case 8 - Check for isBalanced false for {[()}]
		task.setInput("{[()}]");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.isBalanced());
		
		//Use case 9 - Check for isBalanced false for {[()}]
		task.setInput("{[()}]");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.isBalanced());

		//Use case 10 - Check for isBalanced true here
		task.setInput("[{()()}({[]})]({}[({})])((((((()[])){}))[]{{{({({({{{{{{}}}}}})})})}}}))[][][]");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(true, validatedTask.isBalanced());

		//Use case 11 - Check for isBalanced false here
		task.setInput("[{()()}({[]})]({}[({})])((((((()[])){}))[]{{{({({({{{{{{}}}}}})})})}}}))[][][]{");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.isBalanced());

		//Use case 12 - Check for isBalanced false here
		task.setInput("{");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.isBalanced());

		//Use case 13 - Check for isBalanced false here
		task.setInput("[[");
		validatedTask = taskService.validateBrackets(task);
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.isBalanced());

	}
	
}