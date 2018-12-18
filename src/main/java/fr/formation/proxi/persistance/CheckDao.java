package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.Check;

/**
 * Classe regroupant les méthodes à effectuer sur les chéquiers
 * Respect le Design Paterne Dao
 * 
 * @author Ahmed & Sidney
 *
 */
public class CheckDao extends AbstractDao<Check> {
	
	private static final CheckDao INSTANCE = new CheckDao();
	
	/**
	 * {@inheritDoc} <br>
	 * <br>
	 * Permet de recuperer les informations d'un chéquier a partir de son id.
	 */
	public Check read(Integer id) {
		return INSTANCE.read(id, new Check());
	}
	
	/**
	 * {@inheritDoc} <br>
	 * <br>
	 * Permet de recuperer l'ensemble des chéquiers du client.
	 */
	public List<Check> readAll(Integer id) {
		List<Check> checks = new ArrayList<>();
		TypedQuery<Check> query = this.em.createQuery(JpqlQueries.READ_ALL_CHECK, Check.class);
		query.setParameter("idCheck", id);
		checks.addAll(query.getResultList());
		return checks;
	}
	public static CheckDao getInstance() {
		return CheckDao.INSTANCE;
	}
	
	@Override
	public List<Check> readAll() {
		return null;
	}

}
