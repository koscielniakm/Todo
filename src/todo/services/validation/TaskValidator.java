package todo.services.validation;

import todo.entites.Task;

public interface TaskValidator {

	public boolean validateBeforeCreate(Task object);
	public boolean validateBeforeUpdate(Task object);
	public boolean validateBeforeRemove(int id);
	
}
