package todo.services.crud;

import java.util.List;

import todo.dao.DaoTask;
import todo.entites.Task;
import todo.services.validation.TaskValidator;
import todo.services.validation.Validator;

public class TaskService {

	private DaoTask taskAccess;
	
	private Validator<Task> validator;
	
	public TaskService() {
		taskAccess = new DaoTask();
		validator = new TaskValidator();
	}
	
	public synchronized boolean create(Task task) {
		if (validator.validateBeforeCreate(task)) {
			taskAccess.create(task);
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized boolean update(Task task) {
		if (validator.validateBeforeUpdate(task)) {
			taskAccess.update(task);
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized boolean remove(int id) {
		if (validator.validateBeforeRemove(id)) {
			taskAccess.remove(id);
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized List<Task> getAll() {
		return taskAccess.getAll();
	}
	
	public synchronized Task getById(int id) {
		return taskAccess.getById(id);
	}
	
	public synchronized List<Task> getByTaskListId(int taskListId) {
		return taskAccess.getByTaskListId(taskListId);
	}
	
}
