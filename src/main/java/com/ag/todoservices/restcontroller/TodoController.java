/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.restcontroller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ag.todoservices.domain.Todo;
import com.ag.todoservices.services.ToDoService;

/**
 * This class acts as a controller gateway for all the Todo  operations 
 * @author Mohan AMILINENI
 *
 */
@RestController
@RequestMapping(TodoController.BASE_URL)
public class TodoController {

	/******************* INITIALIZATION*************************/
	
	public static final String BASE_URL = "/api/v0/todo";	
	private final ToDoService todoService;

    public TodoController(ToDoService todoService) {
        this.todoService = todoService;
    }         

	
	/******************* PUBLIC APIs*************************/
	
	/**
	 * API to get all todos data using GET.
	 * @return	- Returns all Todo Models in the form of json.
	 */	
	@GetMapping("")
    @ResponseStatus(HttpStatus.OK)
	public List<Todo> getTodos() {
		return todoService.getAllTodos();
	}	
	
	/**
	 * API to retrieve particular Todo
	 * @param id	- Accepts id as path parameter
	 * @return		- Returns Todo in the form of json. 
	 */
	@GetMapping("/{todoId}")
    @ResponseStatus(HttpStatus.OK)
	public Todo getTodo(@PathVariable Long todoId) {
		return todoService.getTodoById(todoId);
	}

	/**
	 * API to update particular Todo based on id
	 * @param id	- Accepts id as path parameter
	 * @param todo	- Accepts Todo in the form of input json.
	 * @return		- Returns Todo in the form of json. 
	 * @throws Exception 
	 */
	@PatchMapping("/{todoId}")
    @ResponseStatus(HttpStatus.OK)
	public Todo updateTodo(@PathVariable Long todoId, @Valid @RequestBody Todo todo) throws Exception {	
		return todoService.updateTodo(todoId, todo);
	}

	/**
	 * API to create todo data using POST.
	 * @param todo	- Accepts Todo as input
	 * @return		- Returns Todo in the form of json.
	 * @throws Exception 
	 */
	@PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
	public Todo saveTodo(@Valid @RequestBody Todo todo) throws Exception {
		return todoService.saveTodo(todo);		
	}
	
}
