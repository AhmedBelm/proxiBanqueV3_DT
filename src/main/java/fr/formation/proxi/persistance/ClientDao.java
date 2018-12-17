package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.Client;

public class ClientDao extends AbstractDao<Client> {
	
	private static final ClientDao INSTANCE = new ClientDao();
	
	
	public Client read(Integer id) {
		return INSTANCE.read(id);
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
}
