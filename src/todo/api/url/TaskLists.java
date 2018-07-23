package todo.api.url;

import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import todo.api.support.TaskListResponseCreator;
import todo.api.support.TaskListValidator;
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
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTasklist(JsonObject json) {
		String taskListName = json.getString("name");
		if(TaskListValidator.validateName(taskListName)) {
			TaskList createdTaskList = new TaskList();
			createdTaskList.setName(taskListName);
			getDaoTaskList().create(createdTaskList);
			return Response.ok().build();
		} else {
			return Response.status(400).build();
		}
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
