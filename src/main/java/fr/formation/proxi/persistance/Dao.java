package fr.formation.proxi.persistance;

import java.util.List;

/**
 * Definition d'une interface comportant les 4 méthodes élémentaires de
 * manipulation de donnees CRUD + readALL.
 * 
 * @param <T> classe qui represente le type de donnees manipule par le DAO.
 */
public interface Dao<T> {

	/**
	 * Lis les informations d'une entite de BDD
	 *  
	 * @param id l'identifiant d'une entite en base de donnees
	 * @return T l'entit� construite � partir des informations recuperees
	 */
	public T read(Integer id);
	
	/**
	 * Recupere toutes les entit�s (lignes) d'une table
	 * 
	 * @return List<T> la liste de toutes les entites lues.
	 */
	public List<T> readAll();
	
	/**
	 * Créer une nouvelle entité dans la BDD
	 * 
	 * @param entity
	 * @return T l'entité créé
	 */
	public T create(T entity);
	
	/**
	 * Met à jour une entité de la BDD
	 * 
	 * @param entity
	 * @return l'entité mis à jour.
	 */
	public T update(T entity);
	
	/**
	 * Supprime une entité de la BDD
	 * 
	 * @param id
	 * @return un booléan précisant la suppression ou non de l'entité.
	 */
	public boolean delete(Integer id);
	
}
