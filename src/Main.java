import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import todo.entites.Task;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TodoUnit");
		EntityManager man = factory.createEntityManager();
		EntityTransaction trans = man.getTransaction();
		trans.begin();
		Task t = new Task();
		t.setId(0);
		t.setIdList(1);
		t.setName("name");
		t.setDescription("desc");
		t.setStatus("xxx");
		man.persist(t);
		trans.commit();
		man.close();
	}
}
