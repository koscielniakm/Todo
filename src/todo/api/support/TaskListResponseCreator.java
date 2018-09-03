package todo.api.support;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.core.Response;

import todo.entites.TaskList;

public class TaskListResponseCreator {

	public TaskListResponseCreator() { }
	
	public Response createJsonFromList(List<TaskList> list) {
		if (list == null || list.size() == 0)
			return Response.noContent().build();
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		for(TaskList tl : list)
			jsonArrayBuilder.add(Json.createObjectBuilder()
				.add("id", tl.getId())
				.add("name", tl.getName())
			);
		return Response.ok(jsonArrayBuilder.build()).build();
	}
	
	public Response createJsonFromSingleObject(TaskList taskList) {
		if (taskList == null)
			return Response.noContent().build();
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		jsonArrayBuilder.add(Json.createObjectBuilder()
				.add("id", taskList.getId())
				.add("name", taskList.getName())
			);	
		return Response.ok(jsonArrayBuilder.build()).build();
	}
	
}
