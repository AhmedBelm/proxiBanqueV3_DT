package fr.formation.proxi.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySqlConnection {

    private static final MySqlConnection INSTANCE = new MySqlConnection();
    
    public static MySqlConnection getInstance() {
        return MySqlConnection.INSTANCE;
    }
    
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    
    
    /**
     * Constructeur par deffaut. Récupère l'instance d'EntityManagerFactory associé à notre unité de persistence.
     */
    public MySqlConnection() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("proxibanquev3");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}