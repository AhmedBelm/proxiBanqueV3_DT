package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.Account;

/**
 * Classe permettant les opération CRUD pour les comptes des clients
 * 
 * @author Ahmed & Sidney
 *
 */
public class AccountDao extends AbstractDao<Account> {

	private static final AccountDao INSTANCE = new AccountDao();

	/**
	 * {@inheritDoc} <br>
	 * <br>
	 * Recupere un compte en particulier à partir de son id.
	 */
	public Account read(Integer id) {
		return this.read(id, new Account());
	}

	/**
	 * {@inheritDoc} <br>
	 * <br>
	 * Recupere l'ensemble des comptes enregistres. 
	 */
	public List<Account> readAll(Integer id) {
		List<Account> clients = new ArrayList<>();
		TypedQuery<Account> query = this.em.createQuery(JpqlQueries.READ_ALL_ACCOUNT, Account.class);
		query.setParameter("idAccount", id);
		clients.addAll(query.getResultList());
		return clients;
	}

	public static AccountDao getInstance() {
		return AccountDao.INSTANCE;
	}

	@Override
	public List<Account> readAll() {
		return null;
	}
}
