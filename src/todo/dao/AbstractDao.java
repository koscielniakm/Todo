package todo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import todo.entites.DbEntity;

public abstract class AbstractDao {

	public AbstractDao() { }
	
	protected void create(DbEntity entity) {
		PersistenceCreator.getTransaction().begin();
		PersistenceCreator.getEntityManager().persist(entity);
		PersistenceCreator.getTransaction().commit();
		PersistenceCreator.closeResources();
	}
	
	protected void update(DbEntity entity) {
		PersistenceCreator.getTransaction().begin();
		PersistenceCreator.getEntityManager().merge(entity);
		PersistenceCreator.getTransaction().commit();
		PersistenceCreator.closeResources();
	}
	
	protected <T extends DbEntity> void remove(Class<T> entity, int id) {
		EntityManager entityManager = PersistenceCreator.getEntityManager();
		EntityTransaction currentTransation = entityManager.getTransaction();
		currentTransation.begin();
		Query query = entityManager.createQuery("DELETE " + entity.getName() + " e where e.id = " + id);
		query.executeUpdate();
		currentTransation.commit();
		PersistenceCreator.closeResources();
	}
	
}
