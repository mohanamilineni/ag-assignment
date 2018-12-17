package com.ag.todoservices.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ag.todoservices.domain.Todo;
import com.ag.todoservices.repository.TodoRepository;

/**
 * Created by AMK on 17/12/18.
 */
public class TodoServiceImplTest {

	ToDoServiceImpl todoService;
	
	@Mock
	TodoRepository todoRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		todoService = new ToDoServiceImpl(todoRepository);
	}

	@Test
	public void testGetAllTodos() {
		
        //given
        Todo todo1= new Todo();
        todo1.setId(1L);
        todo1.setText("aaaaaaaaaaaaaaaaaaaaaaaaa");

        Todo todo2= new Todo();
        todo1.setId(2L);
        todo2.setText("fdsfsffadf'rwerwr'rwerwrewrewrwrarw");
        
        List<Todo> todos = Arrays.asList(todo1, todo2);
        
		//When
        when(todoService.getAllTodos()).thenReturn(todos);
        
        List<Todo> returnedTodos = todoService.getAllTodos();

        //then
        assertEquals(returnedTodos.size(), 2);
        verify(todoRepository, times(1)).findAll();
        verify(todoRepository, never()).findById(anyLong());
	}

	@Test
	public void testGetTodoById() {
		
		//given
        Todo todo= new Todo();
        todo.setId(1L);
        todo.setText("aaaaaaaaaaaaaaaaaaaaaaaaa");
        
        Optional<Todo> todoOptional = Optional.of(todo);

        when(todoRepository.findById(anyLong())).thenReturn(todoOptional);

        Todo returnedTodo = todoService.getTodoById(1L);

        assertNotNull(returnedTodo);
        verify(todoRepository, times(1)).findById(anyLong());
        verify(todoRepository, never()).findAll();
	}

	@Test
	public void testSaveTodo() {
		
        //given
        Todo todo= new Todo();
        todo.setId(1L);
        todo.setText("aaaaaaaaaaaaaaaaaaaaaaaaa");
				
        //when
        when(todoRepository.save(todo)).thenReturn(todo);
        Todo savedTodo = todoService.saveTodo(todo);

        //then
        assertEquals(savedTodo.getText(), todo.getText());
        verify(todoRepository, times(1)).save(todo);		
	}

	@Test
	public void testUpdateTodo() {
		
		//given
        Todo todo= new Todo();
        todo.setId(1L);
        todo.setText("aaaaaaaaaaaaaaaaaaaaaaaaa");
        
        Optional<Todo> todoOptional = Optional.of(todo);

        when(todoRepository.findById(anyLong())).thenReturn(todoOptional);
        when(todoRepository.save(todo)).thenReturn(todo);

        Todo returnedTodo = todoService.updateTodo(1L, todo);

        assertNotNull(returnedTodo);
        verify(todoRepository, never()).findAll();		
	}

	@Test
	public void testDeleteTodoById() {
	
        //given
        Long idToDelete = Long.valueOf(1L);

        //no 'when', since method has void return type
        todoService.deleteTodoById(idToDelete);

        //then
        verify(todoRepository, times(1)).deleteById(anyLong());
	}

}
