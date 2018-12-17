package fr.formation.proxi.metier;

import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.AccountService;
import fr.formation.proxi.metier.Account;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.CardDao;
import fr.formation.proxi.persistance.CheckDao;
import fr.formation.proxi.persistance.ClientDao;

public class AccountService {

	private static final AccountService INSTANCE = new AccountService();
	
	private AccountDao accountDao;
	
	private CardDao cardDao;
	
	private CheckDao checkDao;

	private ClientDao clientDao;

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
