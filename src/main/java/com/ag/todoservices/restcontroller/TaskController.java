/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.restcontroller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ag.todoservices.domain.Task;
import com.ag.todoservices.services.TaskService;


/**
 * This class acts as a controller gateway for all the tasks operations 
 * @author Mohan AMILINENI
 *
 */
@RestController
@RequestMapping(TaskController.BASE_URL)
public class TaskController {

	/******************* INITIALIZATION*************************/
	
	public static final String BASE_URL = "/api/v0/tasks";
	
	private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }         

	

	/******************* PUBLIC APIs*************************/
	
	/**
	 * Evaluates a given brackets string is balanced or not.
	 * Criteria is to have every opening bracket must have its corresponding bracket in an ordered form.
	 * e.g. [] 		- true
	 *      {[()]}  - true
	 *      {[)]}   - false
	 *      )[]}    - false
	 * 
	 * @param bracerStr	- Accepts brackets string as input query parameter
	 * @return			- task result with isBalanced boolean value and validated text.
	 */
	@GetMapping("/validateBrackets")
	public Task validateBrackets(@Valid Task task) {
		return taskService.validateBrackets(task);				
	}
	
}
