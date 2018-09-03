package todo.services.validation;

import todo.entites.TaskList;

public class TaskListValidator implements Validator<TaskList> {

	private static final int NAME_MIN_LENGTH = 3; 
	private static final int NAME_MAX_LENGTH = 30; // Max database varchar length 

	public boolean validateBeforeCreate(TaskList taskList) {
		if (validateName(taskList.getName()))
			return true;
		else
			return false;
	}
	
	public boolean validateBeforeUpdate(TaskList taskList) {
		if (validateId(taskList.getId()) && validateName(taskList.getName()))
			return true;
		else
			return false;
	}
	
	public boolean validateBeforeRemove(int id) {
		return validateId(id);
	}
	
	private boolean validateId(int id) {
		if (id > 0) return true;
		else return false;
	}
	
	private boolean validateName(String name) {
		if (name == null || name.equals(""))
			return false;
		if (name.length() > NAME_MIN_LENGTH && name.length() < NAME_MAX_LENGTH)
			return true;
		else
			return false;
	}

}
