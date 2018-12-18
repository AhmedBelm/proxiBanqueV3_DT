package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;


import fr.formation.proxi.metier.Card;

public class CardDao extends AbstractDao<Card> {

	private static final CardDao INSTANCE = new CardDao();
	
	@Override
	public Card read(Integer id) {
		return this.read(id, new Card());
	}
	
	public List<Card> readAll(Integer id) {
		List<Card> accounts = new ArrayList<>();
		TypedQuery<Card> query = this.em.createQuery(JpqlQueries.READ_ALL_CARD, Card.class);
		accounts.addAll(query.getResultList());
		return accounts;
	}
	
	public static CardDao getInstance() {
		return CardDao.INSTANCE;
	}

	@Override
	public List<Card> readAll() {
		return null;
	}

	
}
