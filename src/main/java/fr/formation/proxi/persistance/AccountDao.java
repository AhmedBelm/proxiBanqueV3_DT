package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.Account;

public class AccountDao extends AbstractDao<Account> {

	private static final AccountDao INSTANCE = new AccountDao();
	
	public Account read(Integer id) {
		return this.read(id, new Account());
	}

	public List<Account> readAll() {
		List<Account> clients = new ArrayList<>();
		TypedQuery<Account> query = this.em.createQuery(JpqlQueries.READ_ALL_ACCOUNT, Account.class);
		query.setParameter("idAccount", id);
		clients.addAll(query.getResultList());
		return clients;
	}

	public static AccountDao getInstance() {
		return AccountDao.INSTANCE;
	}
}
