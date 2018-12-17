package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.Check;

public class CheckDao extends AbstractDao<Check> {
	
	private static final CheckDao INSTANCE = new CheckDao();
	
	@Override
	public Check read(Integer id) {
		return INSTANCE.read(id, new Check());
	}
	
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
