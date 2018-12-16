/*
 * @fullReview  Mohan AMILINENI  16/11/2018  Initial Version 
 * 
 */

package com.ag.todoservices.services;


import java.util.List;

import com.ag.todoservices.domain.Todo;

/**
 * This class acts as an interface for todo Services 
 * @author Mohan AMILINENI
 *
 */
public interface ToDoService {
	
  /**
	* This method returns all todos data available in database.
	* @return	- Returns all Todo available in db
	*/
	public List<Todo> getAllTodos();

   /**
	* This method returns a particular Todo based on its id.
	* @return	- Returns a Todo
	*/
	public Todo getTodoById(Long todoId);    
    
   /**
 	* This method saves a particular Todo based on its input.
 	* @return	- Returns a Todo
 	*/
	public Todo saveTodo(Todo todo);
	
    /**
  	 * This method updates a particular Todo based on its input.
 	 * @return	- Returns a Todo
 	 */
	 public Todo updateTodo(Long todoId, Todo todo);
           
   /**
 	* This method returns a delets Todo based on its id.
 	* @return	- Returns a Todo
 	*/
	public void deleteTodoById(Long todoId);

}

