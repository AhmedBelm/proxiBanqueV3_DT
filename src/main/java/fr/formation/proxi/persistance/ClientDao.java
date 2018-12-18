package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.Client;

/**
 * Classe regroupant les traitement à effectuer sur un client
 * Respecte le Design paterne Dao
 * 
 * @author Adminl
 *
 */
public class ClientDao extends AbstractDao<Client> {
	
	private static final ClientDao INSTANCE = new ClientDao();
	
	/**
	 * {@inheritDoc} <br>
	 * <br>
	 * Permet de recuperer les informations d'un client a partir de son id.
	 */
	public Client read(Integer id) {
		return this.read(id, new Client());
	}
	
	/**
	 * {@inheritDoc} <br>
	 * <br>
	 * Permet de recuperer l'ensemble des clients.
	 */
	public List<Client> readAll(Integer id) {
		List<Client> clients = new ArrayList<>();
		TypedQuery<Client> query = this.em.createQuery(JpqlQueries.READ_ALL_CLIENT, Client.class);
		query.setParameter("id_adv", id);
		clients.addAll(query.getResultList());
		return clients;
	}
	
	public static ClientDao getInstance() {
		return ClientDao.INSTANCE;
	}

	public List<Client> readAll() {
		return null;
	}

	
	/**
	 * Méthode permettant de retourner un client en fonction de son nom et prénom
	 * 
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	public Client check(String firstname , String lastname) {
        Client client = new Client();
        TypedQuery<Client> query = this.em
                .createQuery(JpqlQueries.SELECT_CLIENT_BY_NAME, Client.class);
        query.setParameter("firstname",firstname);
        query.setParameter("lastname",lastname);
            try {
            	client = query.getSingleResult();
			} catch (PersistenceException e) {
				client = null;
			}
        return client;
    }
}
