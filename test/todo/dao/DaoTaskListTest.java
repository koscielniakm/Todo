package todo.dao;

import org.junit.Before;
import org.junit.Test;

import todo.entites.TaskList;

public class DaoTaskListTest {

	private DaoTaskList daoTaskList;
	
	@Before
	public void before() {
		daoTaskList = new DaoTaskList();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUpdateTaskListWithWrongId() {
		TaskList wrongTaskList = new TaskList();
		wrongTaskList.setId(-1);
		daoTaskList.update(wrongTaskList);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteTaskListWithWrongId() {
		daoTaskList.remove(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetByIdWithWrongId() {
		daoTaskList.getById(-1);
	}
	
}
