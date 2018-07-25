package todo.api.url;

import javax.json.JsonObject;
import javax.ws.rs.core.Response;

public interface CrudApi {

	public Response getAll();
	public Response getById(int id);
	public Response create(JsonObject json);
	public Response update(JsonObject json);
	public Response remove(JsonObject json);
	
}
