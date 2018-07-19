package todo.api;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import todo.dao.DaoTaskList;
import todo.entites.TaskList;

@Path("tasklists")
public class TaskLists {

	DaoTaskList taskListAccess;
	
	@GET
	public Response getAllTaskLists() {
		taskListAccess = new DaoTaskList();
		List<TaskList> allTaskLists = taskListAccess.getAll();
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		
		for(TaskList tl : allTaskLists)
			jsonArrayBuilder.add(Json.createObjectBuilder()
				.add("id", tl.getId())
				.add("name", tl.getName())
			);
		
		return Response.ok(jsonArrayBuilder.build()).build();
	}
	
}
