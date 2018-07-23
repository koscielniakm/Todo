package todo.dao;

import java.util.List;

import todo.entites.TaskList;

public class DaoTaskList extends AbstractDao implements Dao {

	public DaoTaskList() { }
	
	public void create(TaskList list) {
		super.create(list);
	}
	
	public void update(TaskList list) {
		super.update(list);
	}
	
	public void remove(int id) {
		super.remove(TaskList.class, id);
	}

	public TaskList getById(int id) {
		TaskList searchedList = persistenceCreator.getEntityManager().find(TaskList.class, id);
		persistenceCreator.closeResources();
		return searchedList;
	}
	
	public List<TaskList> getAll() {
		List<TaskList> lists = persistenceCreator.
			getEntityManager().createQuery("FROM TaskList t", TaskList.class).getResultList();
		persistenceCreator.closeResources();
		return lists;
	}
	
}