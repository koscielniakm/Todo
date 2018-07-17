package todo.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("r1")
public class R1 {

	@GET
	public String hello() {
		return "configured";
	}
	
}
