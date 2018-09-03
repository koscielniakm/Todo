package todo.services.validation;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import todo.entites.TaskList;

@RunWith(MockitoJUnitRunner.class)
public class TaskListValidatorTest {

	@Mock
	private TaskList taskList;
	
	private Validator<TaskList> taskListValidator;
	
	public TaskListValidatorTest() {
		
	}
	
	@Before
	private void before() {
		taskListValidator = new TaskListValidator();
	}
	
	@Test
	private void testValidation() {
		
	}
	
}
