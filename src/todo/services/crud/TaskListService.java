package todo.services.crud;

import java.util.List;

import todo.dao.DaoTaskList;
import todo.entites.TaskList;
import todo.services.validation.TaskListValidatorImpl;

public class TaskListService {

	private DaoTaskList taskListAccess;
	
	private TaskListValidatorImpl validator;
	
	public TaskListService() {
		taskListAccess = new DaoTaskList();
		validator = new TaskListValidatorImpl();
	}
	
	public synchronized boolean create(TaskList taskList) {
		if (validator.validateBeforeCreate(taskList)) {
			taskListAccess.create(taskList);
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized boolean update(TaskList taskList) {
		if (validator.validateBeforeUpdate(taskList)) {
			taskListAccess.update(taskList);
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized boolean remove(int id) {
		if (validator.validateBeforeRemove(id)) {
			taskListAccess.remove(id);
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized List<TaskList> getAll() {
		return taskListAccess.getAll();
	}
	
	public synchronized TaskList getById(int id) {
		return taskListAccess.getById(id);
	}
	
}
