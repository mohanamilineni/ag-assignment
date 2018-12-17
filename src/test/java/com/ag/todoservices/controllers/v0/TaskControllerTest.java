package com.ag.todoservices.controllers.v0;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ag.todoservices.services.TaskService;
import com.ag.todoservices.controllers.exception.TodoServicesControllerExceptionHandler;
import com.ag.todoservices.controllers.v0.TaskController;
import com.ag.todoservices.domain.Task;

/**
 * Created by AMK on 17/12/18.
 */

public class TaskControllerTest {

	@Mock
	TaskService taskService;
	
    @InjectMocks
	TaskController taskController;
    
	@Rule
	public ExpectedException thrown;
	
    MockMvc mockMvc;
    
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
        mockMvc = MockMvcBuilders.standaloneSetup(taskController)
				 .setControllerAdvice(new TodoServicesControllerExceptionHandler())
				 .build();
        
        thrown = ExpectedException.none();
	}

	@Test
	public void testValidateBrackets() throws Exception {
		
        //given
        Task task= new Task();
        task.setInput("[]");
        task.setIsBalanced(true);
       
		//When
        when(taskService.validateBrackets(task)).thenReturn(task);

		//Then
        mockMvc.perform(get(TaskController.BASE_URL + "/validateBrackets?input=[]")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.input", equalTo("[]")))
                .andExpect(jsonPath("$.isBalanced", equalTo(true)));

        verify(taskService, times(1)).validateBrackets(task);
	}
   
}
