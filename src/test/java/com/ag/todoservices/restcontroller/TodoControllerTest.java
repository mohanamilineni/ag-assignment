package com.ag.todoservices.restcontroller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ag.todoservices.restcontroller.exception.TodoServicesControllerExceptionHandler;
import com.ag.todoservices.services.ToDoService;
import com.ag.todoservices.domain.Todo;

public class TodoControllerTest extends AbstractRestControllerTest {

	@Mock
	ToDoService todoService;
	
    @InjectMocks
	TodoController todoController;
	
    MockMvc mockMvc;
    
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
        mockMvc = MockMvcBuilders.standaloneSetup(todoController)
				 .setControllerAdvice(new TodoServicesControllerExceptionHandler())
				 .build();
	}
	
	
	@Test
	public void testGetTodos() throws Exception {
		
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

		//Then
        mockMvc.perform(get(TodoController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        verify(todoService, times(1)).getAllTodos();

	}

	@Test
	public void testGetTodo() throws Exception {
		
        //given
        Todo todo1= new Todo();
        todo1.setId(1L);
        todo1.setText("abfdacsdfadsfsdfasvgrtrt");

		//when
		when(todoService.getTodoById(anyLong())).thenReturn(todo1);

        //then
        mockMvc.perform(get(TodoController.BASE_URL + "/" + anyLong())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text", equalTo("abfdacsdfadsfsdfasvgrtrt")));
	}

	@Test
	public void testSaveTodo() throws Exception {
        //given
        Todo todo= new Todo();
        todo.setId(1L);
        todo.setText("One of My favorite company is Auto and General");

        Todo returnTodo = new Todo();
        returnTodo.setText(todo.getText());        

        //when
        when(todoService.saveTodo(todo)).thenReturn(returnTodo);

        //then
        mockMvc.perform(post(TodoController.BASE_URL)
               .contentType(MediaType.APPLICATION_JSON)
               .content(asJsonString(todo)))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.text", equalTo("One of My favorite company is Auto and General")));
	}
	
	@Test
	public void testUpdateTodo() throws Exception {
		
        //given
        Todo todo= new Todo();
        todo.setId(1L);
        todo.setText("patch test case");

        Todo returnTodo = new Todo();
        returnTodo.setText(todo.getText());
        returnTodo.setIsCompleted(true);

        //when
        when(todoService.updateTodo(1L, todo)).thenReturn(returnTodo);

        //then
        mockMvc.perform(patch(TodoController.BASE_URL + "/1")
               .contentType(MediaType.APPLICATION_JSON)
               .content(asJsonString(todo)))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.text", equalTo("patch test case")))
               .andExpect(jsonPath("$.isCompleted", equalTo(true)))
               ;

	}
	
    @Test
    public void testNotFoundException() throws Exception {

        when(todoService.getTodoById(anyLong())).thenThrow(com.ag.todoservices.exception.ResourceNotFoundException.class);

        mockMvc.perform(get(TodoController.BASE_URL + "/222")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    
}
