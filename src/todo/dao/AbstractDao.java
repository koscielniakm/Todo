package todo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import todo.entites.DbEntity;

public abstract class AbstractDao {

	protected PersistenceCreator persistenceCreator;
	
	public AbstractDao() {
		persistenceCreator = new PersistenceCreator();
	}
	
	protected void create(DbEntity entity) {
		persistenceCreator.getTransaction().begin();
		persistenceCreator.getEntityManager().persist(entity);
		persistenceCreator.getTransaction().commit();
		persistenceCreator.closeResources();
	}
	
	protected void update(DbEntity entity) {
		persistenceCreator.getTransaction().begin();
		persistenceCreator.getEntityManager().merge(entity);
		persistenceCreator.getTransaction().commit();
		persistenceCreator.closeResources();
	}
	
	protected <T extends DbEntity> void remove(Class<T> entity, int id) {
		EntityManager entityManager = persistenceCreator.getEntityManager();
		EntityTransaction currentTransation = entityManager.getTransaction();
		currentTransation.begin();
		Query query = entityManager.createQuery("DELETE " + entity.getName() + " e where e.id = " + id);
		query.executeUpdate();
		currentTransation.commit();
		persistenceCreator.closeResources();
	}
	
}
