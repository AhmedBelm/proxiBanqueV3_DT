package fr.formation.proxi.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Représentation d'une connexion à MySQL avec l'API JPA.
 * 
 * @author Ahmet & Sidney
 *
 */
public class MySqlConnection {

	/**
	 * Déclaration du singleton
	 */
	private static final MySqlConnection INSTANCE = new MySqlConnection();

	/**
	 * @return MysqlConnection l'instance unique (singleton) de connexion BDD.
	 */
	public static MySqlConnection getInstance() {
		return MySqlConnection.INSTANCE;
	}

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	/**
	 * Constructeur par deffaut. Récupère l'instance d'EntityManagerFactory associé
	 * à notre unité de persistence.
	 */
	public MySqlConnection() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("proxibanquev3");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * @return EntityManager une instance capable d'effectuer les opérations
	 *         CRUD sur la base de données.
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
}
