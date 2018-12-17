package fr.formation.proxi.persistance;

public class CheckDao extends AbstractDao<Account> {
	
	private static final AccountDao INSTANCE = new AccountDao();
	
	@Override
	public Check read(Integer id) {
		return INSTANCE.read(id, new Account());
	}
	
	public List<Check> readAll(Integer id) {
		List<Check> checks = new ArrayList<>();
		TypedQuery<Check> query = this.em.createQuery(JpqlQueries.READ_ALL_CHECK, Check.class);
		query.setParameter("idCheck", id);
		accounts.addAll(query.getResultList());
		return accounts;
	}
	public static CheckDao getInstance() {
		return CheckDao.INSTANCE;
	}
	
	@Override
	public List<Check> readAll() {
		return null;
	}

}
