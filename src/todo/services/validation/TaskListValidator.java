package todo.services.validation;

import todo.entites.TaskList;

public interface TaskListValidator {

	public boolean validateBeforeCreate(TaskList object);
	public boolean validateBeforeUpdate(TaskList object);
	public boolean validateBeforeRemove(int id);
	
}
