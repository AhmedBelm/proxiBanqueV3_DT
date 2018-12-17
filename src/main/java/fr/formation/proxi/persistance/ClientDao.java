package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.Client;

public class ClientDao extends AbstractDao<Client> {
	
	private static final ClientDao INSTANCE = new ClientDao();
	
	
	public Client read(Integer id) {
		return this.read(id, new Client());
	}

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
