package todo.api.url;

import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import todo.api.support.TaskListResponseCreator;
import todo.entites.TaskList;
import todo.services.crud.TaskListService;

@Path("tasklists")
public class TaskLists {

	/* use only by get method */
	private TaskListService taskListService;
	/* use only by get method */
	private TaskListResponseCreator responseCreator;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTaskLists() {
		List<TaskList> allTaskLists = getTaskListService().getAll();
		return getResponseCreator().createJsonFromList(allTaskLists);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTasklistById(@PathParam("id") int taskListId) {
		TaskList taskList = getTaskListService().getById(taskListId);
		return getResponseCreator().createJsonFromSingleObject(taskList);
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTasklist(JsonObject json) {
		String taskListName = json.getString("name");
		TaskList createdTaskList = new TaskList();
		createdTaskList.setName(taskListName);
		if (getTaskListService().create(createdTaskList)) {
			return Response.ok().build();
		} else {
			return Response.status(400).build();
		}
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTasklist(JsonObject json) {
		int taskListId = json.getInt("id");
		String taskListName = json.getString("name");
		TaskList taskListToUpdate = new TaskList();
		taskListToUpdate.setId(taskListId);
		taskListToUpdate.setName(taskListName);
		if (getTaskListService().update(taskListToUpdate)) {
			return Response.ok().build();
		} else {
			return Response.status(400).build();
		}
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeTasklist(JsonObject json) {
		int taskListId = json.getInt("id");
		if (getTaskListService().remove(taskListId)) {
			return Response.ok().build();
		} else {
			return Response.status(400).build();
		}
	}
	
	private TaskListResponseCreator getResponseCreator() {
		if (responseCreator == null)
			responseCreator = new TaskListResponseCreator();
		return responseCreator;
	}
	
	private TaskListService getTaskListService() {
		if(taskListService == null)
			taskListService = new TaskListService();
		return taskListService;
	}
	
}
