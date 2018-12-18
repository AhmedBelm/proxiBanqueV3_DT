package fr.formation.proxi.persistance;

import javax.persistence.EntityManager;

/**
 * Classe qui implémente les Design Pattern DAO
 * 
 * @author Ahmed & sidney
 * @param <T>
 */
public abstract class AbstractDao<T> implements Dao<T>{

	/**
	 * Mémorisation de l'instance d'EntityManager pour chaque DAO.
	 */	
	protected EntityManager em;
	
	/**
	 * Constructeur qui récupère une instance d'EntityManager
	 */
	public AbstractDao() {
		this.em = MySqlConnection.getInstance().getEntityManager();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T create(T entity) {
		this.em.getTransaction().begin();
		this.em.persist(entity);
		this.em.getTransaction().commit();
		return entity;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T update(T entity) {
		this.em.getTransaction().begin();
		entity = this.em.merge(entity);
		this.em.getTransaction().commit();
		return entity;
	}

	/**
	 * Lecture d'une entité gracce à son identifiant
	 */
	@SuppressWarnings("unchecked")
	protected T read(Integer id, T entity) {
		T result = null;
		result = (T)this.em.find(entity.getClass(), id);
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(Integer id) {
		this.em.getTransaction().begin();
		T entity = this.read(id);
		this.em.remove(entity);
		this.em.getTransaction().commit();
		return false;
	}
	
}
