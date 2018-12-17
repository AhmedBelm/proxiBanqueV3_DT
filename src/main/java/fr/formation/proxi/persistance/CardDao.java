package fr.formation.proxi.persistance;

public class CardDao extends AbstractDao<Account> {

	private static final AccountDao INSTANCE = new AccountDao();
	
	@Override
	public Card read(Integer id) {
		return this.read(id, new Card());
	}
	
	public List<Card> readAll(Integer id) {
		List<Card> cards = new ArrayList<>();
		TypedQuery<Card> query = this.em.createQuery(JpqlQueries.READ_ALL_CARD, CardDao.class);
		query.setParameter("idCard", id);
		cards.addAll(query.getResultList());
		return cards;
	}
	
	public static CardDao getInstance() {
		return CardDao.INSTANCE;
	}
	
	@Override
	public List<Card> readAll() {
		return null;
	}
}
