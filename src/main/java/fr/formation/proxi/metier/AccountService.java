package fr.formation.proxi.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.AccountService;
import fr.formation.proxi.metier.CurrentAccount;
import fr.formation.proxi.metier.SavingsAccount;
import fr.formation.proxi.metier.Account;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.CardDao;
import fr.formation.proxi.persistance.CheckDao;
import fr.formation.proxi.persistance.ClientDao;
import fr.formation.proxi.presentation.AddCardServlet;

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

	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}

	public List<Account> getAll(Integer idClient) {
		List<Account> accounts = new ArrayList<>();

		accounts = this.clientDao.read(idClient).getAccounts();

		return accounts;
	}

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

	public AccountDao getDao() {
		return this.accountDao;
	}
	
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
}
