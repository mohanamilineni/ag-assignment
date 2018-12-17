package com.ag.todoservices.controllers.v0;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ag.todoservices.domain.Task;
import com.ag.todoservices.services.TaskService;


/**
 * Created by AMK on 17/12/18.
 */
@RestController
@RequestMapping(TaskController.BASE_URL)
public class TaskController {

	/******************* INITIALIZATION*************************/
	
	public static final String BASE_URL = "/api/v0/tasks";
	
	public final TaskService taskService;

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
    @ResponseStatus(HttpStatus.OK)
	public Task validateBrackets(@Valid Task task) {
		return taskService.validateBrackets(task);				
	}
	
}
