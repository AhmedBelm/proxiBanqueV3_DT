package fr.formation.proxi.metier;

import java.util.List;

import fr.formation.proxi.metier.ClientService;
import fr.formation.proxi.metier.Account;
import fr.formation.proxi.metier.Client;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

/**
 * Classe regroupant les méthodes de manpulation des clients.
 * Respecte le design pattern singleton.
 * 
 * @author Ahmed & Sidney
 *
 */
public class ClientService {

	private static final ClientService INSTANCE = new ClientService(AccountDao.getInstance(), ClientDao.getInstance());
	
	private ClientDao daoClient;
	
	private AccountDao daoAccount;
	
	public ClientService(AccountDao daoAccount, ClientDao daoClient) {
		this.daoClient = daoClient;
		this.daoAccount = daoAccount;
	}

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}
	
	/**
	 * Recupère la liste de tous les clients suivis par le conseiller.
	 * 
	 * @return La liste des clients du conseiller.
	 */
	public List<Client> getAll() {
		return this.daoClient.readAll();
	}
	
	public Client read(Integer id) {
		return this.daoClient.read(id);
	}

	/**
	 * Permet de faire un virement entre deux comptes d'un m�me client. Cette
	 * méthode ne fait pas de virement intra-compte ni de virement qui rendrait le
	 * compte débit� en solde n�gatif.
	 * 
	 * @param value         Le montant du virement � effectuer.
	 * @param compteDebite  Le compte � d�biter.
	 * @param compteCredite Le compte � cr�diter
	 * @return False si le virement aurait rendu le compte d�bit� en solde n�gatif.
	 *         True sinon.
	 */
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
	
	
	/**
	 * Permet de retourner le chequier d'un client
	 * 
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	public Client check(String firstname , String lastname) {
        return this.daoClient.check(firstname, lastname);
    }

	/**
	 * Permet d'effectuer un retrait d'argent à hauteur de 300€
	 * 
	 * @param value
	 * @param debitId
	 * @param clientId
	 * @return
	 */
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
