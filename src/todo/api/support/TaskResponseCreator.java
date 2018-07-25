package todo.api.support;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.core.Response;

import todo.entites.Task;

public class TaskResponseCreator {

	public TaskResponseCreator() { }
	
	public Response createJsonFromList(List<Task> list) {
		if (list == null || list.size() == 0)
			return Response.noContent().build();
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		for(Task t : list)
			jsonArrayBuilder.add(Json.createObjectBuilder()
				.add("id", t.getId())
				.add("id_list", t.getList().getId())
				.add("name", t.getName())
				.add("description", t.getDescription())
				.add("status", t.getStatus())
			);
		return Response.ok(jsonArrayBuilder.build()).build();
	}
	
	public Response createJsonFromSingleObject(Task task) {
		if (task == null)
			return Response.noContent().build();
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		jsonArrayBuilder.add(Json.createObjectBuilder()
				.add("id", task.getId())
				.add("id_list", task.getList().getId())
				.add("name", task.getName())
				.add("description", task.getDescription())
				.add("status", task.getStatus())
			);	
		return Response.ok(jsonArrayBuilder.build()).build();
	}
	
	
}
