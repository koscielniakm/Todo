package todo.services.crud;

import java.util.List;

import todo.dao.DaoTaskList;
import todo.entites.TaskList;
import todo.services.validation.TaskListValidator;

public class TaskListService {

	private DaoTaskList taskListAccess;
	
	public TaskListService() {
		taskListAccess = new DaoTaskList();
	}
	
	public synchronized boolean create(TaskList taskList) {
		if (TaskListValidator.validateBeforeCreate(taskList)) {
			taskListAccess.create(taskList);
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized boolean update(TaskList taskList) {
		if (TaskListValidator.validateBeforeUpdate(taskList)) {
			taskListAccess.update(taskList);
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized boolean remove(int id) {
		if (TaskListValidator.validateBeforeRemove(id)) {
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
