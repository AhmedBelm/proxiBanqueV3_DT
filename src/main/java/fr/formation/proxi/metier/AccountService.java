package fr.formation.proxi.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.AccountService;
import fr.formation.proxi.metier.CurrentAccount;
import fr.formation.proxi.metier.SavingsAccount;
import fr.formation.proxi.metier.service.ChequeStatus;
import fr.formation.proxi.metier.Account;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.CardDao;
import fr.formation.proxi.persistance.CheckDao;
import fr.formation.proxi.persistance.ClientDao;
import fr.formation.proxi.presentation.AddCardServlet;

/**
 * Clsse regroupant les méthodes de manipulation des comptes
 * 
 * @author Ahmed & Sidney
 *
 */
public class AccountService {

	private static final AccountService INSTANCE = new AccountService();

	private AccountDao accountDao;

	private CardDao cardDao;

	private CheckDao checkDao;

	private ClientDao clientDao;

	public AccountService() {
		this.accountDao = new AccountDao();
		this.clientDao = new ClientDao();
	}

	/**
	 * instanciation du singleton
	 * 
	 * @return
	 */
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}

	/**
	 * Méthode permettant de récupérer laliste des comptesd d'un client défini
	 * 
	 * @param idClient
	 * @return
	 */
	public List<Account> getAll(Integer idClient) {
		List<Account> accounts = new ArrayList<>();

		accounts = this.clientDao.read(idClient).getAccounts();

		return accounts;
	}

	/**
	 * Méthode permettant d'afficher les comptes épargnes
	 * 
	 * @param idClient
	 * @return
	 */
	public List<Account> getAllSavingAccounts(Integer idClient) {
		List<Account> SavingAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.clientDao.read(idClient).getAccounts();

		for (Account account : accounts) {
			if (account instanceof SavingsAccount) {
				SavingAccounts.add(account);
			}
		}
		return SavingAccounts;
	}

	/**
	 * Méthode permettant d'afficher les comptes courrants
	 * 
	 * @param idClient
	 * @return
	 */
	public List<Account> getAllCurrentAccounts(Integer idClient) {
		List<Account> CurrentAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.clientDao.read(idClient).getAccounts();

		for (Account account : accounts) {
			if (account instanceof CurrentAccount) {
				CurrentAccounts.add(account);
			}
		}
		return CurrentAccounts;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public AccountDao getDao() {
		return this.accountDao;
	}
	
	/**
	 * Méthode permettant de créer une nouvelle carte en fonction de l'id du compte et de son type
	 * 
	 * @param idAccount
	 * @param type
	 * @return
	 */
	public boolean newCard(Integer idAccount, String type) {
        boolean result = true;
        CurrentAccount account = (CurrentAccount) this.accountDao.read(idAccount);
        if (account.getCard() != null) {
            if (account.getCard().getExpDate().isBefore(LocalDate.now())) {
                account.getCard().getIdCard();
                account.setCard(null);
            } else {
                result = false;
            }
        }
        return result;
    }
	
	public ChequeStatus statusCheque(Integer id) {
        Account account = this.accountDao.read(id);
        Check cheque = account.getCheck();
        ChequeStatus status = null;
        
        if(cheque == null) {
            
             status = new ChequeStatus("Premier chequier en cours de distribution ...", true);
            
        } else if (cheque.getReceiveDate().plusMonths(3).isBefore(LocalDate.now()) ) {
            
            status = new ChequeStatus("Tu auras ton cheque" , true );
            
        } else {
            
            status = new ChequeStatus("Tu auras pas ton cheque" , false );
            
        }
        return status;
    }
}
