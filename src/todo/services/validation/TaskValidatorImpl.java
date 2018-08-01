package todo.services.validation;

import todo.entites.Task;

public class TaskValidatorImpl implements Validator<Task> {

	private static final int NAME_MIN_LENGTH = 3;
	private static final int NAME_MAX_LENGTH = 30;
	private static final int DESCRIPTION_MIN_LENGTH = 0;
	private static final int DESCRIPTION_MAX_LENGTH = 150;
	private static final String[] STATUS = { "INPROG", "DONE" };
	
	@Override
	public boolean validateBeforeCreate(Task object) {
		if (validateName(object.getName())
			&& validateDescription(object.getDescription())
			&& validateTaskList(object.getTaskListId())
		) return true;
		else
			return false;
	}

	@Override
	public boolean validateBeforeUpdate(Task object) {
		if (validateName(object.getName())
				&& validateDescription(object.getDescription())
				&& validateTaskList(object.getTaskListId())
			) return true;
			else
				return false;
	}

	@Override
	public boolean validateBeforeRemove(int id) {
		return validateId(id);
	}

	private boolean validateId(int id) {
		if (id > 0) return true;
		else return false;
	}
	
	private boolean validateName(String name) {
		if (name.length() > NAME_MIN_LENGTH && name.length() < NAME_MAX_LENGTH)
			return true;
		else
			return false;
	}
	
	private boolean validateDescription(String description) {
		if (description.length() > DESCRIPTION_MIN_LENGTH && description.length() < DESCRIPTION_MAX_LENGTH)
			return true;
		else
			return false;
	}
	
	private boolean validateStatus(String status) {
		for (String s : STATUS)
			if (s == status)
				return true;
		return false;
	}
	
	private boolean validateTaskList(int taskListId) {
		if (taskListId < 0) return false;
		else return true;
	}
	
}
