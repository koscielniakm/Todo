package todo.dao;

import java.util.List;

import todo.entites.Task;

public class DaoTask extends AbstractDao implements Dao {

	public void create(Task task) {
		super.create(task);
	}
	
	public void update(Task task) {
		if (task.getId() <= 0) throw new IncorrectIdException();
		super.update(task);
	}

	public void remove(int id) {
		if (id <= 0) throw new IncorrectIdException();
		super.remove(Task.class, id);
	}
	
	public Task getById(int id) {
		Task searchedTask = PersistenceCreator.getEntityManager().find(Task.class, id);
		PersistenceCreator.closeResources();
		return searchedTask;
	}
	
	public List<Task> getAll() {
		List<Task> tasks = PersistenceCreator.
			getEntityManager().createQuery("FROM Task t", Task.class).getResultList();
		PersistenceCreator.closeResources();
		return tasks;
	}
	
}
