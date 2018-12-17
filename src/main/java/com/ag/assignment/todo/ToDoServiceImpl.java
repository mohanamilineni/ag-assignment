package com.ag.assignment.todo;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ag.assignment.exception.ResourceNotFoundException;

/**
 * Created by AMK on 17/12/18.
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
	public Todo getTodoById(final Long todoId) {
		return getValidTodo(todoId);
	}

   /**
 	* This method saves a particular Todo based on its input.
 	* @return	- Returns a Todo
 	*/
	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(convert(todo));
	}

	@Override
	public Todo updateTodo(Long todoId, Todo inputTodo){
        return todoRepository.findById(todoId).map(todo -> {

            if(inputTodo.getText() != null){
            	todo.setText(inputTodo.getText());
            }

            if(inputTodo.getIsCompleted() != null){
            	todo.setIsCompleted(inputTodo.getIsCompleted());
            }

            return todoRepository.save(todo);

        }).orElseThrow(() -> new ResourceNotFoundException("Item with "+ todoId + " not found"));
	}

	
   /**
 	* This method returns a delets Todo based on its id.
 	* @return	- Returns a Todo
 	*/
	@Override
	public void deleteTodoById(final Long todoId) {
		todoRepository.deleteById(todoId);
	}

	
	/**
	 * Returns a valid todo if exists with the given id, else throws Resource not found exception.
	 * @param tenantId
	 * @return
	 */
	private Todo getValidTodo(final Long todoId) {
		return todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("Item with "+ todoId + " not found"));		
	}	

	private Todo convert(Todo todo) {
		return todo.setIsCompleted(todo.getIsCompleted());
	}
}
