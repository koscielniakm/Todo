package todo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class PersistenceCreator {

	private static final String persistenceUnitName = "TodoUnit";
	
	private static EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	private static EntityManager entityManager;
	
	private PersistenceCreator() { }
	
	private synchronized static void createEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		entityManager = entityManagerFactory.createEntityManager();	
	}
	
	/* EntityManager and EntityTransaction returned by this methods
	 * after using should be closed by closeResources() mehtod ! */	
	public synchronized static EntityManager getEntityManager() {
		if(entityManager == null) createEntityManager();
		return entityManager;
	}
	
	public synchronized static EntityTransaction getTransaction() {
		if(entityManager == null) createEntityManager();
		return entityManager.getTransaction();
	}
	
	public synchronized static void closeResources() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
