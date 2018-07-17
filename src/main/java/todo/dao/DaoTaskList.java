package todo.dao;

import java.util.List;

import todo.entites.TaskList;

public class DaoTaskList extends AbstractDao implements Dao {

	public void create(TaskList list) {
		super.create(list);
	}
	
	public void update(TaskList list) {
		if (list.getId() <= 0) throw new IllegalArgumentException();
		super.update(list);
	}
	
	public void remove(int id) {
		if (id <= 0) throw new IllegalArgumentException();
		super.remove(TaskList.class, id);
	}

	public TaskList getById(int id) {
		if (id <= 0) throw new IllegalArgumentException();
		TaskList searchedList = PersistenceCreator.getEntityManager().find(TaskList.class, id);
		PersistenceCreator.closeResources();
		return searchedList;
	}
	
	public List<TaskList> getAll() {
		List<TaskList> lists = PersistenceCreator.
			getEntityManager().createQuery("FROM Tasklist l", TaskList.class).getResultList();
		PersistenceCreator.closeResources();
		return lists;
	}
	
}