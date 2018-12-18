package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.ClientService;
import fr.formation.proxi.metier.Account;
import fr.formation.proxi.metier.CurrentAccount;
import fr.formation.proxi.metier.SavingsAccount;
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

	public boolean transfer(Float value, Integer debitId, Integer creditId,
            Integer clientId) {
        boolean transferOK = true;
        Client client = this.daoClient.read(clientId);
        Account compteDebite = client.getAccountById(debitId);
        Account compteCredite = client.getAccountById(creditId);
        if (compteDebite.getIdAccount() == compteCredite.getIdAccount()) {
            return transferOK;
        } else if (compteDebite.getBalance() - value < 0) {
            transferOK = false;
            return transferOK;
        } else if (value > 900) {
        	transferOK = false;
        	return transferOK;
        } else {
            compteCredite.setBalance(compteCredite.getBalance() + value);
            this.daoAccount.update(compteCredite);

            compteDebite.setBalance(compteDebite.getBalance() - value);
            this.daoAccount.update(compteDebite);

            return transferOK;
        }
    }
	
	public Client check(String firstname , String lastname) {
        return this.daoClient.check(firstname, lastname);
    }

	public Boolean withdraw(Float value, Integer debitId, Integer clientId) {
		boolean withdrawOK = true;
		Client client = this.daoClient.read(clientId);
		Account compteDebite = client.getAccountById(debitId);
		if (compteDebite.getBalance() - value < 0) {
			withdrawOK = false;
		} else if (value > 300) {
			withdrawOK = false;
			return withdrawOK;
		} else {
			compteDebite.setBalance(compteDebite.getBalance() - value);
			this.daoAccount.update(compteDebite);
		}
		return withdrawOK;
	}
}
