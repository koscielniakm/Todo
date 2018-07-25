package todo.api.url;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import todo.api.support.TaskResponseCreator;
import todo.entites.Task;
import todo.services.crud.TaskService;

@Path("task")
public class Tasks {
	
	/* use only by get method */
	private TaskService taskService;
	/* use only by get method */
	private TaskResponseCreator responseCreator;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTaskLists() {
		List<Task> tasks = getService().getAll();
		return getResponseCreator().createJsonFromList(tasks);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTasklistById(@PathParam("id") int id) {
		Task task = getService().getById(id);
		return getResponseCreator().createJsonFromSingleObject(task);
	}
	
	private TaskResponseCreator getResponseCreator() {
		if (responseCreator == null)
			responseCreator = new TaskResponseCreator();
		return responseCreator;
	}
	
	private TaskService getService() {
		if(taskService == null)
			taskService = new TaskService();
		return taskService;
	}
}
