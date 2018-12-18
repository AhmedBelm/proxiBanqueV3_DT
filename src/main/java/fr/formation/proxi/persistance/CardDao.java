package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;


import fr.formation.proxi.metier.Card;

/**
 * Classe regroupant les méthodes à efffectuer sur les cartes.
 * Respecte le Design Paterne Dao.
 * 
 * @author Ahmed & Sidney
 *
 */
public class CardDao extends AbstractDao<Card> {

	private static final CardDao INSTANCE = new CardDao();
	
	/**
	 * {@inheritDoc} <br>
	 * <br>
	 * Permet de recuperer les informations d'une carte a partir de son id.
	 */
	public Card read(Integer id) {
		return this.read(id, new Card());
	}
	
	/**
	 * {@inheritDoc} <br>
	 * <br>
	 * Permet de recuperer l'ensemble des cartes du client.
	 */
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
