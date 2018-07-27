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

import todo.api.support.TaskResponseCreator;
import todo.entites.Task;
import todo.services.crud.TaskService;

@Path("task")
public class TaskApi implements CrudApi {
	
	/* use only by get method */
	private TaskService taskService;
	/* use only by get method */
	private TaskResponseCreator responseCreator;
	
	@GET
	@Path("/")
	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Task> tasks = getService().getAll();
		return getResponseCreator().createJsonFromList(tasks);
	}
	
	@GET
	@Path("/{id}")
	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") int id) {
		Task task = getService().getById(id);
		return getResponseCreator().createJsonFromSingleObject(task);
	}
	
	@GET
	@Path("/tasklist/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByTaskListId(@PathParam("id") int id) {
		List<Task> tasks = getService().getByTaskListId(id);
		return getResponseCreator().createJsonFromList(tasks);
	}

	@POST
	@Path("/")
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(JsonObject json) {
		Task createdTask = new Task();
		Integer idOfList = json.getInt("id_list");
		String name = json.getString("name");
		String description = json.getString("description");
		String status = json.getString("status");
		createdTask.setTaskListId(idOfList);
		createdTask.setName(name);
		createdTask.setDescription(description);
		createdTask.setStatus(status);
		if (getService().create(createdTask))
			return Response.ok().build();
		 else
			return Response.status(400).build();
	}

	@PUT
	@Path("/")
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(JsonObject json) {
		Task taskToUpdate = new Task();
		Integer id = json.getInt("id");
		String name = json.getString("name");
		String description = json.getString("description");
		String status = json.getString("status");
		taskToUpdate.setId(id);
		taskToUpdate.setName(name);
		taskToUpdate.setDescription(description);
		taskToUpdate.setStatus(status);
		if (getService().update(taskToUpdate)) {
			return Response.ok().build();
		} else {
			return Response.status(400).build();
		}
	}

	@DELETE
	@Path("/")
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	public Response remove(JsonObject json) {
		int taskToDeleteId = json.getInt("id");
		if (getService().remove(taskToDeleteId)) {
			return Response.ok().build();
		} else {
			return Response.status(400).build();
		}
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
