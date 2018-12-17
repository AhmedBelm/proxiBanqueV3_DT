package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.ClientService;
import fr.formation.proxi.metier.Client;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

public class ClientService {

	private static final ClientService INSTANCE = new ClientService(AccountDao.getInstance(), ClientDao.getInstance());
	
	private ClientDao daoClient;
	
	private AccountDao daoAccount;
	
	public ClientService(AccountDao daoAccount, ClientDao daoClient) {
		this.daoClient = daoClient;
		this.daoAccount = daoAccount;
	}

	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}
	
	public List<Client> getAll() {
		return this.daoClient.readAll();
	}
	
	public Client read(Integer id) {
		return this.daoClient.read(id);
	}

	public Boolean transfer(Float val, Integer compteDebite, Integer compteCredite, Integer clientId) {
		return null;
	}
	
	public Client check(String firstname , String lastname) {
        return this.daoClient.check(firstname, lastname);
    }
}
