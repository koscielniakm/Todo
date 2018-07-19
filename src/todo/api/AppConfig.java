package todo.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("todo")
public class AppConfig extends Application {
	
	private Set<Class<?>> resources = new HashSet<>();
	
	public AppConfig() {
		System.out.println("app config constructor");
		resources.add(R1.class);
	}
	
	public Set<Class<?>> getClasses() {
		return resources;
	}
	
}
