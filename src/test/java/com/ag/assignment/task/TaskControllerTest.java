package com.ag.assignment.task;

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

import com.ag.assignment.exception.TodoServicesControllerExceptionHandler;
import com.ag.assignment.task.Task;
import com.ag.assignment.task.TaskController;
import com.ag.assignment.task.TaskService;

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
        task.setId(1L);
        task.setInput("[]");
        task.setBalanced(true);
       
		//When
        when(taskService.validateBrackets(task)).thenReturn(task);

		//Then
        mockMvc.perform(get(TaskController.BASE_URL + "/validateBrackets?input=[]")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
	}
   
}
