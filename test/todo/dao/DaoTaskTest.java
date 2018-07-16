package todo.dao;

import org.junit.Before;
import org.junit.Test;

import todo.entites.Task;

public class DaoTaskTest {
	
	private DaoTask daoTask;
	
	@Before
	public void before() {
		daoTask = new DaoTask();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUpdateTaskWithWrongId() {
		Task wrongIdTask = new Task();
		wrongIdTask.setId(-1);
		daoTask.update(wrongIdTask);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveTaskWithWrongId() {
		daoTask.remove(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetByIdWithWrongId() {
		daoTask.getById(-1);
	}
	
}
