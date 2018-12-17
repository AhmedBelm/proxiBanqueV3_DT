package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.ClientService;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

public class ClientService {

	private static final ClientService INSTANCE = new ClientService(AccountDao.getInstance(), ClientDao.getInstance());
	
	private ClientDao daoClient;
	
	private AccountDao daoAccount;
	
	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}
	
	public List<Client> getAll() {
		return this.daoClient.readAll();
	}
	
	public Client read(Integer id) {
		return this.daoClient.read(id);
	}
}
