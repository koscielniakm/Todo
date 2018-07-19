package todo.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import todo.dao.DaoTask;

@Path("test")
public class R1 {

	@GET
	public String hello() {
		DaoTask dao = new DaoTask();
		return dao.getById(1).getName();
	}
	
}
