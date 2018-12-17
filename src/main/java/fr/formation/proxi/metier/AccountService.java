package fr.formation.proxi.metier;

import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.AccountService;
import fr.formation.proxi.metier.Account;
import fr.formation.proxi.persistance.AccountDao;

public class AccountService {

	private static final AccountService INSTANCE = new AccountService();
	
	private CardDao cardDao;
	
	private CheckDao checkDao;

	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}
	
	public List<Account> getAll(Integer idClient) {
		List<Account> accounts = new ArrayList<>();

		accounts = this.clientDao.read(idClient).getAccounts();

		return accounts;
	}

	public List<Account> getAllSavingAccounts(Integer idClient) {
		return null;
	}

	public List<Account> getAllCurrentAccounts(Integer idClient) {
		return null;
	}

	
	public AccountDao getDao() {
		return this.accountDao;
	}
}
