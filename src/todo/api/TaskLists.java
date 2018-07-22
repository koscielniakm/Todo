package todo.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import todo.dao.DaoTaskList;
import todo.entites.TaskList;

@Path("tasklists")
public class TaskLists {

	private DaoTaskList taskListAccess;
	
	private TaskListResponseCreator responseCreator;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTaskLists() {
		taskListAccess = getDaoTaskList();
		List<TaskList> allTaskLists = taskListAccess.getAll();
		return getResponseCreator().createJsonFromList(allTaskLists);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTasklistById(@PathParam("id") int taskListId) {
		taskListAccess = getDaoTaskList();
		TaskList taskList = taskListAccess.getById(taskListId);
		return getResponseCreator().createJsonFromSingleObject(taskList);
	}
	
	private DaoTaskList getDaoTaskList() {
		if (taskListAccess == null)
			taskListAccess = new DaoTaskList();
		return taskListAccess;
	}
	
	private TaskListResponseCreator getResponseCreator() {
		if (responseCreator == null)
			responseCreator = new TaskListResponseCreator();
		return responseCreator;
	}
	
}
