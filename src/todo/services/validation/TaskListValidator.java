package todo.services.validation;

import todo.entites.TaskList;

public class TaskListValidator {

	private static final int NAME_MIN_LENGTH = 3; 
	private static final int NAME_MAX_LENGTH = 30; // Max database varchar length 

	public static boolean validateBeforeCreate(TaskList taskList) {
		if (validateName(taskList.getName()))
			return true;
		else
			return false;
	}
	
	public static boolean validateBeforeUpdate(TaskList taskList) {
		if (validateId(taskList.getId()) && validateName(taskList.getName()))
			return true;
		else
			return false;
	}
	
	public static boolean validateBeforeRemove(int id) {
		return validateId(id);
	}
	
	private static boolean validateId(int id) {
		if (id > 0) return true;
		else return false;
	}
	
	private static boolean validateName(String name) {
		if (name == null || name.equals(""))
			return false;
		if (name.length() > NAME_MIN_LENGTH && name.length() < NAME_MAX_LENGTH)
			return true;
		else
			return false;
	}

}
