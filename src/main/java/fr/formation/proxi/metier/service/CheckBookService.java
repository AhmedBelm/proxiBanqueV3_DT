package fr.formation.proxi.metier.service;


import fr.formation.proxi.metier.Check;
import fr.formation.proxi.persistance.CheckDao;


public class CheckBookService {
    
    private static final CheckBookService INSTANCE = new CheckBookService();

    /**
     * Retourne le singleton de la classe.
     *
     * @return Le singleton.
     */
    public static CheckBookService getInstance() {
        return CheckBookService.INSTANCE;
    }

    private CheckDao daoCheque;

    public CheckBookService() {
        this.daoCheque = CheckDao.getInstance();
    }
    
    
    public Check read(Integer id) {    
        return this.daoCheque.read(id);    
    }
}