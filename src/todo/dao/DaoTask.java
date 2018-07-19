package todo.dao;

import java.util.List;

import todo.entites.Task;

public class DaoTask extends AbstractDao implements Dao {
	
	public void create(Task task) {
		super.create(task);
	}
	
	public void update(Task task) {
		if (task.getId() <= 0) throw new IllegalArgumentException();
		super.update(task);
	}

	public void remove(int id) {
		if (id <= 0) throw new IllegalArgumentException();
		super.remove(Task.class, id);
	}
	
	public Task getById(int id) {
		if (id <= 0) throw new IllegalArgumentException();
		Task searchedTask = persistenceCreator.getEntityManager().find(Task.class, id);
		persistenceCreator.closeResources();
		return searchedTask;
	}
	
	public List<Task> getAll() {
		List<Task> tasks = persistenceCreator.
			getEntityManager().createQuery("FROM Task t", Task.class).getResultList();
		persistenceCreator.closeResources();
		return tasks;
	}
	
}
