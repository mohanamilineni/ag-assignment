package com.ag.assignment.todo;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AMK on 17/12/18.
 */
@RestController
@RequestMapping(TodoController.BASE_URL)
@Validated
public class TodoController {

	/******************* INITIALIZATION*************************/
	
	public static final String BASE_URL = "/api/v0/todo";	
	private final ToDoService todoService;

    public TodoController(final ToDoService todoService) {
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
