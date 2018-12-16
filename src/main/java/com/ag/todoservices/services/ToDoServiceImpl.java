/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */
package com.ag.todoservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ag.todoservices.domain.Todo;
import com.ag.todoservices.exception.ResourceNotFoundException;
import com.ag.todoservices.repository.TodoRepository;

/**
 * This class acts as an implementation for Todo Services and internally leverages Todo Repository 
 * @author Mohan AMILINENI - 16/11/2018
 *
 */
@Service
public class ToDoServiceImpl implements ToDoService {

	private final TodoRepository  todoRepository;
	
	public ToDoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository  = todoRepository;
	}
	
   /**
	* This method returns all todos data available in database.
	* @return	- Returns all Todo available in db
	*/
	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

   /**
	* This method returns a particular Todo based on its id.
	* @return	- Returns a Todo
	*/
	@Override
	public Todo getTodoById(Long todoId) {
		return getValidTodo(todoId);
	}

   /**
 	* This method saves a particular Todo based on its input.
 	* @return	- Returns a Todo
 	*/
	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo updateTodo(Long todoId, Todo todo){
		Todo existingTodo = getValidTodo(todoId);		
		return todoRepository.save(mapValues(existingTodo, todo));		
	}

	
   /**
 	* This method returns a delets Todo based on its id.
 	* @return	- Returns a Todo
 	*/
	@Override
	public void deleteTodoById(Long todoId) {
		todoRepository.deleteById(todoId);
	}

	
	/**
	 * Returns a valid todo if exists with the given id, else throws Resource not found exception.
	 * @param tenantId
	 * @return
	 */
	private Todo getValidTodo(Long todoId) {

		Optional<Todo> todoOptional = todoRepository.findById(todoId);
		if(!todoOptional.isPresent()) {
			throw new ResourceNotFoundException("Item with "+ todoId.toString() + " not found");
		}
		return todoOptional.get();
	}
	
	private Todo mapValues(Todo existingTodo, Todo newTodo) {
		if(!isNullOrEmpty(newTodo.getText())) {
			existingTodo.setText(newTodo.getText());
		}
		if(newTodo.getIsCompleted() != existingTodo.getIsCompleted()) {
			existingTodo.setIsCompleted(newTodo.getIsCompleted());
		}
		return existingTodo;
	}
	
    private boolean isNullOrEmpty(String str) {
		return str == null || str.trim().length() == 0 || "null".equalsIgnoreCase(str.trim());
	}

}
